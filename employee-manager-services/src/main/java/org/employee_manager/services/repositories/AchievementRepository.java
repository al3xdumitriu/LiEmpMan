package org.employee_manager.services.repositories;

import java.util.List;

import org.employee_manager.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
	@Query("select p from Achievement p where p.name=:name") //hql
	List<Achievement> getByName(@Param("name") String name);
}
