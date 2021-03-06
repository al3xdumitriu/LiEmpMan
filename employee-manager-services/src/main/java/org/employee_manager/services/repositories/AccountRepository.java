package org.employee_manager.services.repositories;

import java.util.List;

import org.employee_manager.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("select a from Account a where a.username=:username")
	Account findAccountByName(@Param("username") String username);

	@Query("select a from Account a where a.username=:username and a.password=:password")
	Account findAccountByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	@Query("select a from Account a where a.username=:username and a.password=:password")
	List<Account> findMultipleAccountsByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
