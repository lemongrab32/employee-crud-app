package com.github.lemongrab32.somecrud.services;

import com.github.lemongrab32.somecrud.repository.entities.Address;

public interface AddressService {

    Address findById(Long id);

    void save(Address address);

}
