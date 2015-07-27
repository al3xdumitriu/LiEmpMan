package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Account;

public interface AccountService {

	Account save(Account account);

	List<Account> saveAll(List<Account> listAccount);

	Account findById(Long id);

	List<Account> findAll();
	
	Account findAccountByName(String username);

}
