package com.profiler.rest.mvc;

import com.profiler.core.entity.Account;
import com.profiler.core.entity.Contact;
import com.profiler.core.service.AccountService;
import com.profiler.core.service.ContactService;
import com.profiler.core.service.exception.AccountDoesNotExistException;
import com.profiler.core.service.exception.AccountExistException;
import com.profiler.core.service.util.AccountList;
import com.profiler.core.service.util.ContactList;
import com.profiler.rest.exeception.ConflictException;
import com.profiler.rest.exeception.NotFoundException;
import com.profiler.rest.resources.AccountListResource;
import com.profiler.rest.resources.AccountResource;
import com.profiler.rest.resources.ContactListResource;
import com.profiler.rest.resources.ContactResource;
import com.profiler.rest.resources.asm.AccountListResourceAsm;
import com.profiler.rest.resources.asm.AccountResourceAsm;
import com.profiler.rest.resources.asm.ContactListResourceAsm;
import com.profiler.rest.resources.asm.ContactResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sachindra on 27/07/2015.
 */
@Controller
@RequestMapping(value = "/rest/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public ResponseEntity<AccountResource> getAccount(@PathVariable("Id") Long id){
         Account account = accountService.getAccount(id);

        if(account != null) {
            AccountResource res = new AccountResourceAsm().toResource(account);
        return new ResponseEntity<>(res, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountResource> createAccount( @RequestBody AccountResource sentAccount){
        try {
            Account createAccount = accountService.createAccount(sentAccount.toAccount());
            AccountResource res = new AccountResourceAsm().toResource(createAccount);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<>(res, headers, HttpStatus.CREATED);
        }catch (AccountExistException ex){
            throw new ConflictException();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<AccountListResource> getAllAccounts(@RequestParam(value="name", required=false) String name){
        AccountList accountList = null;

        if(name == null){
            accountList = accountService.getAllAccounts();
        }else{
            Account account = accountService.getAccountByName(name);
            accountList = new AccountList(new ArrayList<>());
            if(account != null){
                accountList.setAccountList(Arrays.asList(account));
            }
        }

        AccountListResource res = new AccountListResourceAsm().toResource(accountList);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/{accountId}/contacts", method = RequestMethod.GET)
    public ResponseEntity<ContactListResource> getContactsByAccount(@PathVariable("accountId") Long accountId){
        try {
            ContactList contactList = accountService.getContactsByAccount(accountId);
            ContactListResource contactListResource = new ContactListResourceAsm().toResource(contactList);
            return new ResponseEntity<>(contactListResource, HttpStatus.OK);
        }catch (AccountDoesNotExistException ex){
            throw new NotFoundException();
        }
    }

    @RequestMapping(value = "/{accountId}/contacts", method = RequestMethod.POST)
    public  ResponseEntity<ContactResource> createContact(@PathVariable("accountId") Long accountId,
                                                          @RequestBody ContactResource newContactRes){
        try {
            Contact createContact = contactService.addContact(accountId, newContactRes.toContact());
            ContactResource res = new ContactResourceAsm().toResource(createContact);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<>(res, headers, HttpStatus.CREATED);
        }catch (AccountExistException ex){
            throw new NotFoundException();
        }
    }


}
