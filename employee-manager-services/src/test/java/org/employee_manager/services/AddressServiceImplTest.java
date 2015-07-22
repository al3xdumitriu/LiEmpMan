package org.employee_manager.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.employee_manager.model.Address;
import org.employee_manager.model.Employee;
import org.junit.Test;

import junit.framework.Assert;

public class AddressServiceImplTest extends BaseServicesTest {

	@Test
	public void testSaveAddress() {
		Address address = new Address();
		address.setCity("city");
		address.setCode("1234");
		address.setCountry("country");
		address.setStreet("street");
		address.setStreetNo(11);
		Address newAddress = this.addressService.saveAddress(address);

		Assert.assertEquals("city", newAddress.getCity());
		Assert.assertEquals("1234", newAddress.getCode());
		Assert.assertEquals("country", newAddress.getCountry());
		Assert.assertEquals("street", newAddress.getStreet());
		Assert.assertEquals(11, newAddress.getStreetNo());
	}

	@Test
	public void testFindById() {
		Address address = new Address();
		address.setCity("city");
		address.setCode("1234");
		address.setCountry("country");
		address.setStreet("street");
		address.setStreetNo(11);

		Address newAddress = this.addressService.saveAddress(address);
		Address found = this.addressService.findById(newAddress.getId());
		Assert.assertEquals(address.getCity(), newAddress.getCity());
	}

	@Test
	public void testSaveAllAddresses() {
		Address address1 = new Address();
		address1.setCity("city");
		address1.setCode("1234");
		address1.setCountry("country");
		address1.setStreet("street");
		address1.setStreetNo(11);

		Address address2 = new Address();
		address2.setCity("city");
		address2.setCode("1234");
		address2.setCountry("country");
		address2.setStreet("street");
		address2.setStreetNo(11);

		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address1);
		addresses.add(address2);

		List<Address> newAddresses = this.addressService.saveAllAddresses(addresses);
		Assert.assertEquals(addresses.get(0).getCity(), newAddresses.get(0).getCity());
		Assert.assertEquals(addresses.get(1).getCity(), newAddresses.get(1).getCity());
	}

	@Test
	public void testFindAllAddresses() {
		Address address1 = new Address();
		address1.setCity("city");
		address1.setCode("1234");
		address1.setCountry("country");
		address1.setStreet("street");
		address1.setStreetNo(11);

		Address address2 = new Address();
		address2.setCity("city");
		address2.setCode("1234");
		address2.setCountry("country");
		address2.setStreet("street");
		address2.setStreetNo(11);

		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address1);
		addresses.add(address2);

		List<Address> newAddresses = this.addressService.saveAllAddresses(addresses);
		List<Address> foundAddresses = this.addressService.findAllAddresses();
		Assert.assertEquals(addresses.size(), foundAddresses.size());
		Assert.assertEquals(addresses.get(0).getCity(), foundAddresses.get(0).getCity());
		Assert.assertEquals(addresses.get(1).getCity(), foundAddresses.get(1).getCity());
	}
}
