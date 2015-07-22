package org.employee_manager.services;

import java.util.ArrayList;
import java.util.List;

import org.employee_manager.model.Account;
import org.employee_manager.model.Role;
import org.junit.Test;

import junit.framework.Assert;

public class AccountServiceImplTest extends BaseServicesTest {

	@Test
	public void testSave() {

		Account testAccount = new Account();
		testAccount.setUsername("d.diaconu");
		testAccount.setPassword("password");
		testAccount.setRoles(null);
		testAccount.setEmployeeId(null);

		Account savedAccount = this.accountService.save(testAccount);

		Assert.assertNotNull(savedAccount);
		Assert.assertEquals("d.diaconu", savedAccount.getUsername());
		Assert.assertEquals("password", savedAccount.getPassword());
		Assert.assertNull(savedAccount.getRoles());
		Assert.assertNull(savedAccount.getEmployeeId());
	}

	@Test
	public void testFindById() {

		Account testAccount = new Account();
		testAccount.setUsername("d.diaconu");
		testAccount.setPassword("password");
		testAccount.setRoles(null);
		testAccount.setEmployeeId(null);

		Account savedAccount = this.accountService.save(testAccount);
		Account findedAccount = this.accountService.findById(savedAccount.getId());

		Assert.assertNotNull(findedAccount);
		Assert.assertEquals("d.diaconu", findedAccount.getUsername());
		Assert.assertEquals("password", findedAccount.getPassword());
		Assert.assertNull(findedAccount.getRoles());
		Assert.assertNull(findedAccount.getEmployeeId());

	}

	@Test
	public void testFindAll() {

		List<Account> listAccounts = new ArrayList<Account>();
		int nrAccounts = this.accountService.findAll().size();

		Account firstAccount = new Account();
		firstAccount.setUsername("d.diaconu");
		firstAccount.setPassword("password");
		listAccounts.add(firstAccount);

		Account secondAccount = new Account();
		secondAccount.setUsername("d.diaconu");
		secondAccount.setPassword("password");
		listAccounts.add(secondAccount);

		List<Account> savedAccounts = this.accountService.saveAll(listAccounts);
		List<Account> foundAccounts = this.accountService.findAll();

		Assert.assertNotNull(foundAccounts);
		List<Role> listRoles = this.roleService.findAll();
		Assert.assertEquals(nrAccounts + 2, foundAccounts.size());
		Assert.assertEquals(true, foundAccounts.contains(firstAccount));
		Assert.assertEquals(true, foundAccounts.contains(secondAccount));
	}

	@Test
	public void saveAll() {

		List<Account> allAccounts = new ArrayList<Account>();

		Account firstAccount = new Account();
		firstAccount.setUsername("d.diaconu");
		firstAccount.setPassword("password");
		firstAccount.setEmployeeId(null);
		firstAccount.setRoles(null);
		allAccounts.add(firstAccount);

		Account secondAccount = new Account();
		secondAccount.setUsername("d.pancu");
		secondAccount.setPassword("password2");
		secondAccount.setEmployeeId(null);
		secondAccount.setRoles(null);
		allAccounts.add(secondAccount);

		List<Account> savedAccounts = this.accountService.saveAll(allAccounts);

		Assert.assertNotNull(savedAccounts);
		Assert.assertEquals(allAccounts.size(), savedAccounts.size());
		Assert.assertEquals("d.diaconu", savedAccounts.get(0).getUsername());
		Assert.assertEquals("d.pancu", savedAccounts.get(1).getUsername());
		Assert.assertNull(savedAccounts.get(0).getEmployeeId());
		Assert.assertNull(savedAccounts.get(0).getRoles());

	}

}
