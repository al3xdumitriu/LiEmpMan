package org.employee_manager.services.repositories;

import org.employee_manager.model.EventStatus;
import org.employee_manager.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> {

}
