package com.profiler.core.service.impl;

import com.profiler.core.entity.Account;
import com.profiler.core.entity.Address;
import com.profiler.core.entity.Contact;
import com.profiler.core.repository.jpa.AccountRepository;
import com.profiler.core.repository.jpa.AddressRepository;
import com.profiler.core.repository.jpa.ContactRepository;
import com.profiler.core.service.AccountService;
import com.profiler.core.service.exception.AccountDoesNotExistException;
import com.profiler.core.service.exception.AccountExistException;
import com.profiler.core.service.util.AccountList;
import com.profiler.core.service.util.ContactList;
import com.profiler.rest.resources.ContactResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sachindra on 27/07/2015.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ContactRepository contactRepository;

//    @Autowired
//    AddressRepository addressRepository;

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public Account getAccountByName(String name) {
        return accountRepository.findByName(name);
    }

    @Override
    public AccountList getAllAccounts() {
        return new AccountList(accountRepository.findAll());
    }

    @Override
    public Account createAccount(Account account) {
        Account existsAccount = accountRepository.findByName(account.getName());

        if(existsAccount == null){
           return accountRepository.save(account);
        }else{
            throw new AccountExistException();
        }
    }

    @Override
    public void deleteAccount(Long id) {
        Account existsAccount = accountRepository.findOne(id);

        if(existsAccount == null){
            accountRepository.delete(id);
        }else{
            throw new AccountExistException();
        }
    }

    @Override
    public ContactList getContactsByAccount(Long accountId) {

        Account account = accountRepository.findOne(accountId);
        if(account == null){
            throw new AccountDoesNotExistException();
        }

        List<Contact> contacts = contactRepository.findByAccount(account);

//        for(Contact c: contacts){
//            List<Address> addresses = addressRepository.findAddressByContact(c);
//            c.setAddress(addresses);
//        }

        ContactList contactList = new ContactList(contacts);

        return contactList;
    }
}
