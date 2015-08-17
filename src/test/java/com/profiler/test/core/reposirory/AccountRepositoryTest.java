package com.profiler.test.core.reposirory;

import com.profiler.core.entity.Account;
import com.profiler.core.entity.Address;
import com.profiler.core.entity.Contact;
import com.profiler.core.repository.jpa.AccountRepository;
import com.profiler.core.repository.jpa.ContactRepository;
import com.profiler.rest.mvc.AccountController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
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

@RunWith(SpringJUnit4ClassRunner.class)   //Enable autowiring
@ContextConfiguration("classpath:spring/business-config.xml") //spring configuration
public class AccountRepositoryTest {

    @InjectMocks
    AccountController controller;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ContactRepository contactRepository;

    MockMvc mockMvc;

    @Before
    @Transactional
    @Rollback(false)
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        Account acc = new Account();
        acc.setName("test");
        acc.setPassword("test");
        accountRepository.save(acc);

        Address address = new Address();
        address.setStreet("Goldfinch Ave");
        address.setCity("Fairfield");

        Address address1 = new Address();
        address1.setStreet("Goldfinch Ave");
        address1.setCity("Fairfield");

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address1);

        Contact contact = new Contact();
        contact.setFirstname("John");
        contact.setMiddlename("Chris");
        contact.setLastname("Froome");
        contact.setAddress(addressList);
        contact.setAccount(acc);
        contactRepository.save(contact);

        Contact contact1 = new Contact();
        contact1.setFirstname("Johnny");
        contact1.setMiddlename("Johnny");
        contact1.setLastname("YesPapa");
        contact1.setAddress(addressList);
        contact1.setAccount(acc);
        contactRepository.save(contact1);

    }

    @Test
    @Transactional
    public void AccountInsertTest(){
        Account acc = accountRepository.findByName("test");
        assertNotNull(acc);
        assertEquals(acc.getName(), "test");
    }

    @Test
    @Transactional
    public void findContactsByAccountTest() throws Exception{
        Account account = accountRepository.findOne(1L);
        List<Contact> acc = contactRepository.findByAccount(account);
        System.out.println(acc.size());
    }
}
