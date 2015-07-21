package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Achievement;

public interface AchievementService {
	
	Achievement saveAchievement(Achievement achievement);
	
	List<Achievement> saveAllAchievements(List<Achievement> achievements);
	
	Achievement findById(Long id);

	List<Achievement> findAllAchievements();
	
}
