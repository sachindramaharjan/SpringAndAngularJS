package com.profiler.core.service.util;

import com.profiler.core.entity.Contact;
import com.profiler.rest.resources.ContactResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachindra on 28/07/2015.
 */
public class ContactList {
    List<Contact> contactList= new ArrayList<>();

    public ContactList(List<Contact> contactList){
        this.contactList = contactList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
