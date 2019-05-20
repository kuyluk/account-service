package com.assessment.account.service;

import com.assessment.account.model.Account;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    private AccountService accountService;

    @Before
    public void setUp() {
        accountService = new AccountServiceImpl();
    }

    @Test
    public void shouldRetrieveAllAccounts() {

        List<Account> accounts = accountService.retrieveAllAccounts();

        assertThat(accounts).isNotNull();
    }
}