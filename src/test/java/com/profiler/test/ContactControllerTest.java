package com.profiler.test;

import com.profiler.core.entity.Address;
import com.profiler.core.entity.Contact;
import com.profiler.core.service.AccountService;
import com.profiler.core.service.ContactService;
import com.profiler.rest.mvc.ContactController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by sachindra on 27/07/2015.
 */
public class ContactControllerTest {

    @InjectMocks
    ContactController controller;

    @Mock
    ContactService contactService;

    MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getContactTest() throws Exception{
        Address address = new Address();
        address.setId(1L);
        address.setStreet("Goldfinch Ave");
        address.setCity("Fairfield");

        Address address1 = new Address();
        address1.setId(2L);
        address1.setStreet("Goldfinch Ave");
        address1.setCity("Fairfield");

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address1);

        Contact contact = new Contact();
        contact.setAddress(addressList);
        contact.setId(1L);
        contact.setFirstname("John");
        contact.setMiddlename("Chris");
        contact.setLastname("Froome");

        when(contactService.getContact(1L)).thenReturn(contact);

        mockMvc.perform(get("/contact/1")).andDo(print());

    }

}
