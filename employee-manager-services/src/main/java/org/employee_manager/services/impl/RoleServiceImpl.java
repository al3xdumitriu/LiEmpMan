package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Role;
import org.employee_manager.services.RoleService;
import org.employee_manager.services.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> saveAll(List<Role> listRoles) {
		return roleRepository.save(listRoles);
	}

	@Override
	public Role findById(Long id) {
		return roleRepository.getOne(id);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
