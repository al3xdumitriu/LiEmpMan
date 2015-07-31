package org.employee_manager.services.repositories;

import org.springframework.stereotype.Repository;
import org.employee_manager.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

	@Query("select j from Job j where j.name=:name")
	Job findJobByName(@Param("name") String name);
}
