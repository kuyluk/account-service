package com.assessment.account.controller;

import com.assessment.account.model.Account;
import com.assessment.account.model.ResponseMessage;
import com.assessment.account.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final static String ACCOUNTS_ENDPOINT = "/rest/account/json";

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = ACCOUNTS_ENDPOINT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Account> retrieveAllAccounts(){

        return accountService.retrieveAllAccounts();
    }

    @PostMapping(value = ACCOUNTS_ENDPOINT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage addAccount(@RequestBody Account account){

        String message = accountService.addAccount(account);
        return new ResponseMessage(message);
    }

    @DeleteMapping(value = ACCOUNTS_ENDPOINT + "/{id}")
    public ResponseMessage removeAccount(@PathVariable Integer id){

        String message = accountService.removeAccount(id);
        return new ResponseMessage(message);
    }

}
