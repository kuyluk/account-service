package com.assessment.account.service;

import com.assessment.account.model.Account;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public List<Account> retrieveAllAccounts() {
        return Arrays.asList(new Account());
    }
}
