package com.github.lemongrab32.somecrud.repository;

import com.github.lemongrab32.somecrud.repository.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
