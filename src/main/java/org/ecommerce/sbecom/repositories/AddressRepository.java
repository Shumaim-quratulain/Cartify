package org.ecommerce.sbecom.repositories;

import org.ecommerce.sbecom.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface AddressRepository extends JpaRepository<Address, Long> {

}
