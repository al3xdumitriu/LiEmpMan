package org.employee_manager.services.repositories;

import java.util.List;

import org.employee_manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("select e from Employee e where e.name=:name") // hql
	List<Employee> getByName(@Param("name") String name);

	@Query("UPDATE Employee SET name = :name, cnp = :cnp, phone = :phone, email = :email, experienceLevel = :experienceLevel, jobTitle = :jobTitle WHERE id = :id")
	@Modifying
	void updateById(@Param("name") String name,@Param("cnp") Long cnp, @Param("phone") String phone,
			@Param("email") String email, @Param("experienceLevel") String experienceLevel,
			@Param("jobTitle") String jobTitle,  @Param("id") Long id);

}
