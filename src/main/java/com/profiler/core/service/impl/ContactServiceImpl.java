package com.profiler.core.service.impl;

import com.profiler.core.entity.Account;
import com.profiler.core.entity.Contact;
import com.profiler.core.repository.jpa.AccountRepository;
import com.profiler.core.repository.jpa.AddressRepository;
import com.profiler.core.repository.jpa.ContactRepository;
import com.profiler.core.service.ContactService;
import com.profiler.core.service.exception.AccountDoesNotExistException;
import com.profiler.core.service.exception.ContactDoesNotExistException;
import com.profiler.core.service.exception.ContactExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sachindra on 27/07/2015.
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact addContact(Long accountId, Contact contact) {
        Account account = accountRepository.findOne(accountId);
        if(account == null){
            throw new AccountDoesNotExistException();
        }

        contact.setAccount(account);
        Contact newContact = contactRepository.save(contact);
        newContact.setAccount(account);
        return contact;
    }

    @Override
    public Contact updateContact(Long id, Contact updatedContact) {
        Contact oldContact = contactRepository.findOne(id);
        if(oldContact != null){
            updatedContact.setId(oldContact.getId());
            return contactRepository.save(updatedContact);
        }else{
            throw new ContactDoesNotExistException();
        }
    }

    @Override
    public void deleteContact(Long id) {
        Contact contact = contactRepository.findOne(id);
        if(contact == null){
            contactRepository.delete(contact);
        }else{
            throw new ContactExistsException();
        }
    }
}
