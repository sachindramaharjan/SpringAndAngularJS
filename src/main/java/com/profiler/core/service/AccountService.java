package com.profiler.core.service;

import com.profiler.core.entity.Account;
import com.profiler.core.service.util.AccountList;
import com.profiler.core.service.util.ContactList;
import com.profiler.rest.resources.AccountResource;

import java.util.List;

/**
 * Created by sachindra on 27/07/2015.
 */
public interface AccountService {

    public Account getAccount(Long id);
    public Account getAccountByName(String name);
    public AccountList getAllAccounts();
    public Account createAccount(Account account);
    public void deleteAccount(Long id);
    public ContactList getContactsByAccount(Long accountId);

}
