package com.assessment.account.repository;

import com.assessment.account.model.Account;

import java.util.List;

public interface AccountRepository {

    List<Account> retrieveAccounts();
}
