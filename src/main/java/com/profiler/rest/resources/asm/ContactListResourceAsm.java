package com.profiler.rest.resources.asm;

import com.profiler.core.service.util.ContactList;
import com.profiler.rest.mvc.ContactController;
import com.profiler.rest.resources.ContactListResource;
import com.profiler.rest.resources.ContactResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

/**
 * Created by sachindra on 28/07/2015.
 */
public class ContactListResourceAsm extends ResourceAssemblerSupport<ContactList, ContactListResource> {

    public ContactListResourceAsm(){
        super(ContactController.class, ContactListResource.class);
    }

    @Override
    public ContactListResource toResource(ContactList contactList) {
        List<ContactResource> contactResourceList = new ContactResourceAsm().toResources(contactList.getContactList());
        ContactListResource res = new ContactListResource();
        res.setContactResources(contactResourceList);
        return res;
    }
}
