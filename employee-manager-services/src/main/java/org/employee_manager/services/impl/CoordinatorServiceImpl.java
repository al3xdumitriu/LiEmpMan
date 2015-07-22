package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Coordinator;
import org.employee_manager.services.CoordinatorService;
import org.employee_manager.services.repositories.CoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoordinatorServiceImpl implements CoordinatorService {

    @Autowired
    private CoordinatorRepository coordinatorRepository;
    
    @Override
    public Coordinator save(Coordinator coordinator) {
        return coordinatorRepository.save(coordinator);
    }

    @Override
    public List<Coordinator> saveAll(List<Coordinator> coordinatorList) {
        return coordinatorRepository.save(coordinatorList);
    }

    @Override
    public Coordinator findById(Long id) {
        return coordinatorRepository.findOne(id);
    }

    @Override
    public List<Coordinator> findAll() {
        return coordinatorRepository.findAll();
    }
}
