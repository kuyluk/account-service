package com.assessment.account.controller;

import com.assessment.account.model.Account;
import com.assessment.account.model.ResponseMessage;
import com.assessment.account.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Account> retrieveAllAccounts(){

        return accountService.retrieveAllAccounts();
    }

    @PostMapping(value = "/accounts", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage addAccount(@RequestBody Account account){

        String message = accountService.addAccount(account);
        return new ResponseMessage(message);
    }

    @DeleteMapping(value = "/accounts/{id}")
    public ResponseMessage removeAccount(@PathVariable Integer id){

        return new ResponseMessage("account successfully deleted");
    }

}
