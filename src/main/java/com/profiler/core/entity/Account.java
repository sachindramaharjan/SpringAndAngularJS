package com.profiler.core.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sachindra on 27/07/2015.
 */

@Entity(name="account")
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue
    @Column(name="account_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Contact> contactList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
