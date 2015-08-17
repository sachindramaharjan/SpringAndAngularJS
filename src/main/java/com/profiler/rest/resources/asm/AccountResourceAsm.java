package com.profiler.rest.resources.asm;

import com.profiler.core.entity.Account;
import com.profiler.rest.mvc.AccountController;
import com.profiler.rest.resources.AccountResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by sachindra on 27/07/2015.
 */
public class AccountResourceAsm extends ResourceAssemblerSupport<Account, AccountResource> {

    public AccountResourceAsm(){
        super(AccountController.class, AccountResource.class);
    }

    @Override
    public AccountResource toResource(Account account) {
        AccountResource accountResource = new AccountResource();
        accountResource.setRid(account.getId());
        accountResource.setName(account.getName());
        accountResource.setPassword(account.getPassword());
        Link link = linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel();
        Link contactsLink = linkTo(methodOn(AccountController.class).getContactsByAccount(account.getId())).withRel("contacts");
        accountResource.add(link);
        accountResource.add(contactsLink);
        return accountResource;
    }
}
