package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Account;
import org.employee_manager.services.AccountService;
import org.employee_manager.services.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> saveAll(List<Account> listAccount) {
		return accountRepository.save(listAccount);
	}

	@Override
	public Account findById(Long id) {
		return accountRepository.findOne(id);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findAccountByName(String username) {
		return accountRepository.findAccountByName(username);
	}


}
