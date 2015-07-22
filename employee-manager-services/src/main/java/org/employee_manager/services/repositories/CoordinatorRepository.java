package org.employee_manager.services.repositories;

import org.employee_manager.model.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface CoordinatorRepository extends JpaRepository<Coordinator, Long>{

}
