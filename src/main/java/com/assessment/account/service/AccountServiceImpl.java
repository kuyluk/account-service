package com.assessment.account.service;

import com.assessment.account.entity.AccountEntity;
import com.assessment.account.model.Account;
import com.assessment.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> retrieveAllAccounts() {
        Iterable<AccountEntity> accountEntities = accountRepository.findAll();
        List<Account> accounts = new ArrayList<>();
        accountEntities.forEach(ae -> accounts.add(new Account(ae.getId(), ae.getFirstName(), ae.getSecondName(), ae.getAccountNumber())));
        return accounts;
    }

    @Override
    public String addAccount(Account account) {

        AccountEntity accountEntity = new AccountEntity(null, account.getFirstName(), account.getSecondName(), account.getAccountNumber());
        accountRepository.save(accountEntity);
        return "account has been successfully added";
    }
}
