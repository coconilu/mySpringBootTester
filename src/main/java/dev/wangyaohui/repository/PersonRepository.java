package dev.wangyaohui.repository;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import dev.wangyaohui.entity.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	@Query("select p from Person p where p.name= :name")
	Person testQuery(@Param("name")String name);
	
	@Query("select p from Person p where p.name= :name")
	Map testMapper(@Param("name")String name);
	
	@Modifying
	@Transactional
	@Query("update Person p set p.name= ?1 where p.name= ?2")
	int testSetNmae(String newName, String oldName);
}
