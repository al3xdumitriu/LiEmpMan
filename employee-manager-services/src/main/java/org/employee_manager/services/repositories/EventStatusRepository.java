package org.employee_manager.services.repositories;

import org.employee_manager.model.Event;
import org.employee_manager.model.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventStatusRepository extends JpaRepository<EventStatus, Long>{

}
