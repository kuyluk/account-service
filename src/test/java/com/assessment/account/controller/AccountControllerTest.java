package com.assessment.account.controller;

import com.assessment.account.model.Account;
import com.assessment.account.model.ResponseMessage;
import com.assessment.account.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

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

        when(accountService.retrieveAllAccounts()).thenReturn(accounts);

        String expectedJson = new ObjectMapper().writeValueAsString(accounts);

        mockMvc.perform(get("/accounts"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string(expectedJson))
                ;

        verify(accountService).retrieveAllAccounts();

    }

    @Test
    public void shouldAddAnAccount_whenRequestBodyIsValid() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(anAccount(1, "John", "Doe", "1234"));
        String responseMessage = objectMapper.writeValueAsString(new ResponseMessage("account has been successfully added"));

        mockMvc.perform(post("/accounts")
                    .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(responseMessage))
                ;
    }

    private Account anAccount(int id, String firstName, String secondName, String accountNumber){
        return new Account(id, firstName, secondName, accountNumber);
    }
}