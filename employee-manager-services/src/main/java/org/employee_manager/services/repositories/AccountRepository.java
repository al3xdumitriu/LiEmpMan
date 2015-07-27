package org.employee_manager.services.repositories;

import org.employee_manager.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("select a from Account a where a.username=:username")
	Account findAccountByName(@Param("username") String username);

}
