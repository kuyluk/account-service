package com.assessment.account.service;

import com.assessment.account.entity.AccountEntity;
import com.assessment.account.model.Account;
import com.assessment.account.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    private AccountService accountService;

    @Before
    public void setUp() {
        accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    public void shouldRetrieveAllAccounts() {

        List<Account> expectedAccounts = Arrays.asList(new Account(1, "John", "Doe", "1234"),
                new Account(2, "Jane", "Doe", "1235"),
                new Account(3, "Jim", "Taylor", "1236"));

        List<AccountEntity> accountEntities = Arrays.asList(new AccountEntity(1, "John", "Doe", "1234"),
                new AccountEntity(2, "Jane", "Doe", "1235"),
                new AccountEntity(3, "Jim", "Taylor", "1236"));

        when(accountRepository.findAll()).thenReturn(accountEntities);

        List<Account> accounts = accountService.retrieveAllAccounts();

        assertThat(accounts).isNotNull();
        assertThat(accounts).hasSize(3);
        assertThat(accounts).hasSameElementsAs(expectedAccounts);

        verify(accountRepository).findAll();
    }

    @Test
    public void shouldAddNewAccount_whenAccountIsValid() {

        AccountEntity savedAccountEntity = new AccountEntity(123, "John", "Doe", "1234");
        when(accountRepository.save(any(AccountEntity.class))).thenReturn(savedAccountEntity);

        Account account = new Account(null, "John", "Doe", "1234");

        String accountStatus = accountService.addAccount(account);

        assertThat(accountStatus).isNotBlank();
        assertThat(accountStatus).isEqualTo("account has been successfully added");

        AccountEntity accountEntity = new AccountEntity(null, "John", "Doe", "1234");
        verify(accountRepository).save(accountEntity);
    }

    @Test
    public void shouldRemoveAccount_whenAccountExists() {

        String accountStatus = accountService.removeAccount(1);

        assertThat(accountStatus).isNotBlank();
        assertThat(accountStatus).isEqualTo("account successfully deleted");

        verify(accountRepository).deleteById(1);
    }
}