package com.profiler.rest.resources.asm;

import com.profiler.core.entity.Account;
import com.profiler.core.service.util.AccountList;
import com.profiler.rest.mvc.AccountController;
import com.profiler.rest.resources.AccountListResource;
import com.profiler.rest.resources.AccountResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

/**
 * Created by sachindra on 27/07/2015.
 */
public class AccountListResourceAsm extends ResourceAssemblerSupport<AccountList, AccountListResource> {

    public AccountListResourceAsm(){
        super(AccountController.class, AccountListResource.class);
    }

    @Override
    public AccountListResource toResource(AccountList accountList) {
        List<AccountResource> resList = new AccountResourceAsm().toResources(accountList.getAccountList());
        AccountListResource listRes = new AccountListResource();
        listRes.setAccountList(resList);
        return listRes;
    }
}
