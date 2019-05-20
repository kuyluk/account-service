package com.assessment.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


    @GetMapping(value = "accounts")
    public void retrieveAllAccounts(){

    }

}
