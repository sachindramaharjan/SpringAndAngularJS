package com.profiler.rest.resources;

import com.profiler.core.entity.Account;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachindra on 27/07/2015.
 */
public class AccountListResource extends ResourceSupport {

    List<AccountResource> accountList = new ArrayList<>();

    public List<AccountResource> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountResource> accountList) {
        this.accountList = accountList;
    }

}
