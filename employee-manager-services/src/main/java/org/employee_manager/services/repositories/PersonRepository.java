package org.employee_manager.services.repositories;

import org.employee_manager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	@Query("select p from Person p where p.name=:name") //hql
	Person getByName(@Param("name") String name);
	
	@Query("update Person set name = :name where id = :id")
    @Modifying
	void updateById(@Param("name") String name, @Param("id") Long id);
	
	@Query(value = "select name from person where id=:id", nativeQuery=true) //sql clasic
	String getNameById(@Param("id") Long id);
	
	//select new net.cycleon.anypoint.edi.model.ABCD(ed.id, ed.name) from ABCD ed
	
}
