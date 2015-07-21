package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Achievement;
import org.employee_manager.services.AchievementService;
import org.employee_manager.services.repositories.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AchievementServiceImpl implements AchievementService{
	
	@Autowired
    private AchievementRepository achievementRepository;

	@Override
	public Achievement saveAchievement(Achievement achievement) {
		return this.achievementRepository.save(achievement);
	}

	@Override
	public Achievement findById(Long id) {
		return this.achievementRepository.findOne(id);
	}

	@Override
	public List<Achievement> saveAllAchievements(List<Achievement> achievements) {
		return this.achievementRepository.save(achievements);
	}

	@Override
	public List<Achievement> findAllAchievements() {
		return this.achievementRepository.findAll();
	}

}
