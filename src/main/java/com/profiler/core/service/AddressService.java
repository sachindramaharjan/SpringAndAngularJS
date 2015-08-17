package com.profiler.core.service;

import com.profiler.core.entity.Address;
import com.profiler.core.entity.Contact;

import java.util.List;

/**
 * Created by sachindra on 29/07/2015.
 */
public interface AddressService {
    List<Address> findAddressByContact(Contact contact);
}
