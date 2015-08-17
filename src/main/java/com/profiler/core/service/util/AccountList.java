package com.profiler.core.service.util;

import com.profiler.core.entity.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachindra on 27/07/2015.
 */
public class AccountList {
    List<Account> accountList = new ArrayList<>();

    public AccountList(List<Account> accountList){
        this.accountList = accountList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
