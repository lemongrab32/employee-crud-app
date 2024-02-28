package com.github.lemongrab32.somecrud.services;

import com.github.lemongrab32.somecrud.repository.AddressRepository;
import com.github.lemongrab32.somecrud.repository.entities.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

}
