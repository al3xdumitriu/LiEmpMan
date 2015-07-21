
package org.employee_manager.services;

import java.util.ArrayList;
import java.util.List;

import org.employee_manager.model.Account;
import org.employee_manager.model.Role;
import org.junit.Test;
import junit.framework.Assert;

public class RoleServiceImplTest extends BaseServicesTest {

	@Test
	public void testSave() {

		Role testRole = new Role();
		testRole.setName("Java-Developer");
		testRole.setDescription("develops web applications and desktop application using java tehnology!");
		Account myAccount = null;
		testRole.setAccountId(myAccount);

		Role roleSaved = this.roleService.save(testRole);

		Assert.assertNotNull(roleSaved);
		Assert.assertEquals("Java-Developer", roleSaved.getName());
		Assert.assertNull(roleSaved.getAccountId());
	}

	@Test
	public void testFindById() {

		Role testRole = new Role();
		testRole.setName("Java-Developer");
		testRole.setDescription("develops web applications and desktop application using java tehnology!");
		Account testAccount = null;
		testRole.setAccountId(testAccount);

		Role resultRole = this.roleService.save(testRole);
		Role roleFound = this.roleService.findById(resultRole.getId());

		Assert.assertNotNull(roleFound);
		Assert.assertEquals("Java-Developer", resultRole.getName());
		Assert.assertEquals("develops web applications and desktop application using java tehnology!",
				resultRole.getDescription());
		Assert.assertNull(resultRole.getAccountId());

	}

	@Test
	public void testFindAll() {

		int nrRoles = this.roleService.findAll().size();
		Role firstRole = new Role();
		firstRole.setName("Java-Developer");
		firstRole.setDescription("develops web Applications using java tehnology");
		firstRole.setAccountId(null);

		roleService.save(firstRole);

		Role secondRole = new Role();
		secondRole.setName("Test-Developer");
		secondRole.setDescription("tests web Applications using java tehnology");
		secondRole.setAccountId(null);
		roleService.save(secondRole);

		List<Role> listRoles = this.roleService.findAll();

		Assert.assertNotNull(listRoles);
		Assert.assertEquals(nrRoles + 2, listRoles.size());
		Assert.assertEquals(true, listRoles.contains(firstRole));
		Assert.assertNull(listRoles.get(0).getAccountId());
		Assert.assertNull(listRoles.get(1).getAccountId());
		Assert.assertEquals(true, listRoles.contains(secondRole));
	}

	@Test
	public void saveAll() {

		List<Role> myRoleList = new ArrayList<Role>();

		Role firstRole = new Role();
		firstRole.setName("Java-Developer");
		firstRole.setAccountId(null);
		Role secondRole = new Role();

		secondRole.setName("Test-Developer");
		secondRole.setAccountId(null);

		myRoleList.add(firstRole);
		myRoleList.add(secondRole);

		List<Role> savedRoles = this.roleService.saveAll(myRoleList);

		Assert.assertNotNull(savedRoles);
		Assert.assertEquals(myRoleList.size(), savedRoles.size());
		Assert.assertEquals("Java-Developer", savedRoles.get(0).getName());
		Assert.assertNull(savedRoles.get(0).getAccountId());
		Assert.assertNull(savedRoles.get(1).getAccountId());
		Assert.assertEquals("Test-Developer", savedRoles.get(1).getName());

	}

}
