package com.profiler.test;


import com.profiler.core.entity.Account;
import com.profiler.core.service.AccountService;
import com.profiler.core.service.exception.AccountExistException;
import com.profiler.core.service.util.AccountList;
import com.profiler.rest.mvc.AccountController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.endsWith;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by sachindra on 27/07/2015.
 */
public class AccountControllerTest {

    @InjectMocks
    AccountController accountController;

    @Mock
    AccountService accountService;

    MockMvc mockMvc;

    private ArgumentCaptor<Account> accountCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        accountCaptor = ArgumentCaptor.forClass(Account.class);
    }

    @Test
    public void getAccountTest() throws Exception{
        Account account = new Account();
        account.setId(1L);
        account.setName("bob");
        account.setPassword("marley");

        when(accountService.getAccount(1L)).thenReturn(account);

        mockMvc.perform(get("/account/1"))
                .andDo(print())
                .andExpect(jsonPath("$.name", is(account.getName())))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllAccountTest() throws Exception{
        Account account = new Account();
        account.setId(1L);
        account.setName("bob");
        account.setPassword("marley");

        Account account1 = new Account();
        account1.setId(2L);
        account1.setName("boby");
        account1.setPassword("margy");

        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        accounts.add(account1);

        AccountList accountList = new AccountList(accounts);

        when(accountService.getAllAccounts()).thenReturn(accountList);

        mockMvc.perform(get("/account/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createNotExistingAccountTest() throws Exception{
        Account account = new Account();
        account.setId(1L);
        account.setName("bob");
        account.setPassword("marley");

        when(accountService.createAccount(any(Account.class))).thenReturn(account);

        mockMvc.perform(post("/account/new")
                .content("{\"name\":\"bob\",\"password\":\"marley\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.name", is(account.getName())))
                .andExpect(header().string("Location", endsWith("/account/1")))
                .andExpect(status().isCreated());

        verify(accountService).createAccount(accountCaptor.capture());

        String name = accountCaptor.getValue().getName();
        String password = accountCaptor.getValue().getPassword();
        assertEquals("bob", name);
        assertEquals("marley", password);

    }

    @Test
    public void createExistingAccount() throws Exception{
        Account account = new Account();
        account.setId(1L);
        account.setName("bob");
        account.setPassword("marley");

        when(accountService.createAccount(any(Account.class))).thenThrow(new AccountExistException());

        mockMvc.perform(post("/account/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"bob\",\"password\":\"marley\"}"))
                .andExpect(status().isConflict());
    }


}
