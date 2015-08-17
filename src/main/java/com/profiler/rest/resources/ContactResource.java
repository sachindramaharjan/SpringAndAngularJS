package com.profiler.rest.resources;

import com.profiler.core.entity.Address;
import com.profiler.core.entity.Contact;
import org.springframework.hateoas.ResourceSupport;


import java.util.List;

/**
 * Created by sachindra on 27/07/2015.
 */
public class ContactResource extends ResourceSupport {
    private Long rid;
    private String firstname;
    private String middlename;
    private String lastname;
    private String homeNumber;
    private String mobileNumber;
    private String workNumber;
    private String facebookLink;
    private String twitterLink;
    private String linkedInLink;
    private List<Address> address;

    public Long getRid() {
        return rid;
    }

    public void setId(Long rid) {
        this.rid = rid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Contact toContact(){
        Contact contact = new Contact();
        contact.setId(rid);
        contact.setFirstname(firstname);
        contact.setMiddlename(middlename);
        contact.setLastname(lastname);
        contact.setMobileNumber(mobileNumber);
        contact.setHomeNumber(homeNumber);
        contact.setWorkNumber(workNumber);
        contact.setFacebookLink(facebookLink);
        contact.setLinkedInLink(linkedInLink);
        contact.setTwitterLink(twitterLink);

        return contact;
    }
}
