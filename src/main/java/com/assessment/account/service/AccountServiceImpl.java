package com.assessment.account.service;

import com.assessment.account.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public List<Account> retrieveAllAccounts() {
        throw new RuntimeException("Not implemented yet.");
    }
}
