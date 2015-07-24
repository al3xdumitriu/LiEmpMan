package org.employee_manager.services.repositories;

import org.employee_manager.model.Event;
import org.employee_manager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	@Query("select e from Event e where e.name=:name") //hql
	Event findByName(@Param("name") String name);
}
