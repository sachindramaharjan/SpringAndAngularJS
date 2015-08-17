package com.profiler.core.service.impl;

import com.profiler.core.entity.Address;
import com.profiler.core.entity.Contact;
import com.profiler.core.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sachindra on 29/07/2015.
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public List<Address> findAddressByContact(Contact contact) {
        return null;
    }
}
