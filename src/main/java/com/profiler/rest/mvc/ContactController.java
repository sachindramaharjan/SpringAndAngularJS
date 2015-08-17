package com.profiler.rest.mvc;

import com.profiler.core.entity.Account;
import com.profiler.core.entity.Contact;
import com.profiler.core.service.AccountService;
import com.profiler.core.service.ContactService;
import com.profiler.core.service.exception.AccountExistException;
import com.profiler.core.service.exception.ContactDoesNotExistException;
import com.profiler.core.service.exception.ContactExistsException;
import com.profiler.rest.exeception.ConflictException;
import com.profiler.rest.exeception.NotFoundException;
import com.profiler.rest.resources.ContactResource;
import com.profiler.rest.resources.asm.ContactResourceAsm;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

/**
 * Created by sachindra on 27/07/2015.
 */
@Controller
@RequestMapping(value="/rest/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/{ID}")
    public ResponseEntity<ContactResource> getContact(@PathVariable("ID") Long id){
        Contact contact = contactService.getContact(id);
        if(contact != null){
            ContactResource res = new ContactResourceAsm().toResource(contact);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/delete/{ID}", method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable(value="ID") Long id)
    {
        try{
            contactService.deleteContact(id);
        }catch (ContactDoesNotExistException ex){
            throw new NotFoundException();
        }
    }

}