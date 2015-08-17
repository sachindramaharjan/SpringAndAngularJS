package com.profiler.core.repository.jpa;

import com.profiler.core.entity.Address;
import com.profiler.core.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by sachindra on 29/07/2015.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select a from address a where a.contact = :contact")
    List<Address> findAddressByContact(@Param("contact")Contact contact);
}
