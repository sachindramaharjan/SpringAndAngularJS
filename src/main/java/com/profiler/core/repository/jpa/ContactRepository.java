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
public interface ContactRepository extends JpaRepository<Contact, Long> {

   @Query("SELECT c FROM contact c WHERE c.firstname = :firstname and c.middlename = :middlename " +
           "                                                      and c.lastname = :lastname")
   public Contact findByName(@Param(value="firstname") String firstname,
                             @Param(value="middlename") String middlename,
                             @Param(value="lastname") String lastname);

   public List<Contact> findByAccount(Account account);
}
