package com.assessment.account.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


    @GetMapping(value = "accounts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String retrieveAllAccounts(){

        return "";
    }

}
