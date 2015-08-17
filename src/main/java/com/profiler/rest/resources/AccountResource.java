package com.profiler.rest.resources;

import com.profiler.core.entity.Account;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by sachindra on 27/07/2015.
 */
public class AccountResource extends ResourceSupport {

    private Long rid;
    private String name;
    private String password;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
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

    public Account toAccount(){
        Account account = new Account();
        account.setName(name);
        account.setPassword(password);
        account.setId(rid);
        return account;
    }

}
