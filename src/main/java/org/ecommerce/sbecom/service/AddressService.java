package org.ecommerce.sbecom.service;

import jakarta.validation.Valid;
import org.ecommerce.sbecom.model.User;
import org.ecommerce.sbecom.payload.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService  {

    AddressDTO createAddress(AddressDTO addressDTO, User user);

    List<AddressDTO> getAddresses();

    AddressDTO getAddressById(Long addressId);

    List<AddressDTO> getUserAddresses(User user);

    AddressDTO updateAddress(Long addressId, @Valid AddressDTO addressDTO);

    String deleteAddress(Long addressId);
}
