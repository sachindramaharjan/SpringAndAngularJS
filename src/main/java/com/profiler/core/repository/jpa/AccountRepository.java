package com.profiler.core.repository.jpa;

import com.profiler.core.entity.Account;
import com.profiler.core.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Created by sachindra on 27/07/2015.
 */

public interface AccountRepository extends JpaRepository<Account, Long>{

    //@Query("Select a from account a where a.name = :name")
    Account findByName(@Param(value="name") String name);

}
