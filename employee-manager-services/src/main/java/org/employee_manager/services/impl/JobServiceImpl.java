package org.employee_manager.services.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.employee_manager.model.Job;
import org.employee_manager.services.JobService;
import org.employee_manager.services.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;

	@Override
	public Job save(Job job) {
		return jobRepository.save(job);
	}

	@Override
	public List<Job> saveAll(List<Job> jobs) {
		return jobRepository.save(jobs);
	}

	@Override
	public Job findById(Long id) {
		return jobRepository.findOne(id);
	}

	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public Job findJobByName(String name) {
		return jobRepository.findJobByName(name);
	}

}
