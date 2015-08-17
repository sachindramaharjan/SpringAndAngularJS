package com.profiler.test.core.reposirory;

import com.profiler.core.entity.Account;
import com.profiler.core.entity.Address;
import com.profiler.core.entity.Contact;
import com.profiler.core.repository.jpa.AccountRepository;
import com.profiler.core.repository.jpa.ContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sachindra on 28/07/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)   //Enable autowiring
@ContextConfiguration("classpath:spring/business-config.xml") //spring configuration
public class ContactRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ContactRepository contactRepository;

    Contact contact;

    @Before
    @Transactional
    @Rollback(false)
    public void setup(){

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

    }

    @Test
    public void addFindContactTest(){
        Contact con = contactRepository.findByName("John", "Chris", "Froome");
        assertNotNull(con);
        assertEquals(con.getFirstname(), "John");
    }

    @Test
    public void addDeleteContactTest(){
        contactRepository.delete(contact);
        assertEquals(contact.getFirstname(), "John");
    }

    @Test
    public void addUpdateContactTest(){
        contact.setMiddlename("Paris");
        contactRepository.save(contact);
        assertEquals(contact.getMiddlename(), "Paris");
    }

}
