package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Coordinator;
import org.employee_manager.model.Employee;

public interface CoordinatorService {
    
    Coordinator save(Coordinator coordinator);

    List<Coordinator> saveAll(List<Coordinator> coordinator);

    Coordinator findById(Long id);

    List<Coordinator> findAll();
}
