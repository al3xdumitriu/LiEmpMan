package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Address;

public interface AddressService {

	Address saveAddress(Address address);

	List<Address> saveAllAddresses(List<Address> achievements);

	Address findById(Long id);

	List<Address> findAllAddresses();

}
