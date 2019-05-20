package com.assessment.account.service;

import com.assessment.account.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> retrieveAllAccounts();

    String addAccount(Account account);
}
