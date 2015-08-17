package com.profiler.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachindra on 28/07/2015.
 */
public class ContactListResource extends ResourceSupport {

    List<ContactResource> contactResources = new ArrayList<>();

    public List<ContactResource> getContactResources() {
        return contactResources;
    }

    public void setContactResources(List<ContactResource> contactResources) {
        this.contactResources = contactResources;
    }
}
