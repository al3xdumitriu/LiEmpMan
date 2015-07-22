package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Role;

public interface RoleService {

	Role save(Role role);

	List<Role> saveAll(List<Role> listRoles);

	Role findById(Long id);

	List<Role> findAll();
}
