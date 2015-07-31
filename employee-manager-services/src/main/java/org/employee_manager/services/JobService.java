package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Job;

public interface JobService {

	Job save(Job job);

	List<Job> saveAll(List<Job> jobs);

	Job findById(Long id);

	List<Job> findAll();

	Job findJobByName(String name);

}
