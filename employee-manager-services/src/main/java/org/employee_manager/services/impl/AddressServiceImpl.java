package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Address;
import org.employee_manager.services.AddressService;
import org.employee_manager.services.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address saveAddress(Address address) {
		return this.addressRepository.save(address);
	}

	@Override
	public Address findById(Long id) {
		return this.addressRepository.findOne(id);
	}

	@Override
	public List<Address> saveAllAddresses(List<Address> addresses) {
		return this.addressRepository.save(addresses);
	}

	@Override
	public List<Address> findAllAddresses() {
		return this.addressRepository.findAll();
	}

}
