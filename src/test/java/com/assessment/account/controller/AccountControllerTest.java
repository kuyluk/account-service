package com.assessment.account.controller;

import com.assessment.account.model.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AccountController controller;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void shouldRetrieveAllAccounts() throws Exception {

        List<Account> accounts = new ArrayList<>();
        accounts.add(anAccount(1, "John", "Doe", "1234"));

        String expectedJson = new ObjectMapper().writeValueAsString(accounts);

        mockMvc.perform(MockMvcRequestBuilders.get("/accounts"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string(expectedJson))
                ;
    }


    private Account anAccount(int id, String firstName, String secondName, String accountNumber){
        return new Account(id, firstName, secondName, accountNumber);
    }
}