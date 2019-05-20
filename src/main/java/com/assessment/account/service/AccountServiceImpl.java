package com.assessment.account.service;

import com.assessment.account.model.Account;
import com.assessment.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> retrieveAllAccounts() {
        return accountRepository.retrieveAccounts();
    }
}
