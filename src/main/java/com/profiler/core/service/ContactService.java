package com.profiler.core.service;

import com.profiler.core.entity.Contact;

/**
 * Created by sachindra on 27/07/2015.
 */
public interface ContactService {

    public Contact getContact(Long id);
    public Contact addContact(Long accountId, Contact contact);
    public Contact updateContact(Long id, Contact updatedContact);
    public void deleteContact(Long id);

}
