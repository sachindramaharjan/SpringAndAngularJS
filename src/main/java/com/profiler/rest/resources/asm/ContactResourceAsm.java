package com.profiler.rest.resources.asm;

import com.profiler.core.entity.Contact;
import com.profiler.rest.mvc.ContactController;
import com.profiler.rest.resources.ContactResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by sachindra on 27/07/2015.
 */
public class ContactResourceAsm extends ResourceAssemblerSupport<Contact, ContactResource>{

    public ContactResourceAsm(){
        super(ContactController.class, ContactResource.class);
    }

    @Override
    public ContactResource toResource(Contact contact) {
        ContactResource res = new ContactResource();
        res.setId(contact.getId());
        res.setFirstname(contact.getFirstname());
        res.setMiddlename(contact.getMiddlename());
        res.setLastname(contact.getLastname());
        res.setHomeNumber(contact.getHomeNumber());
        res.setWorkNumber(contact.getWorkNumber());
        res.setMobileNumber(contact.getMobileNumber());
        res.setFacebookLink(contact.getFacebookLink());
        res.setLinkedInLink(contact.getLinkedInLink());
        res.setTwitterLink(contact.getTwitterLink());
        res.setAddress(contact.getAddress());

        Link link = linkTo(methodOn(ContactController.class).getContact(contact.getId())).withSelfRel();

        res.add(link);

        return res;
    }
}
