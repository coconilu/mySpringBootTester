package dev.wangyaohui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dev.wangyaohui.entity.Person;
import dev.wangyaohui.repository.PersonRepository;
import junit.framework.Assert;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JPATests {
	@Autowired
	PersonRepository personRepository;

	@Test
	public void testPerson(){
		Person person = new Person("wangyaohui", "male");
		
		personRepository.save(person);
		
		for (Person p: personRepository.findAll()){
			if ("wangyaohui".equals(p.getName())){
				Assert.assertEquals("male", p.getSex());
			}
		}
		
		Assert.assertEquals("male", personRepository.testQuery("wangyaohui").getSex());
		
		Assert.assertEquals(1, personRepository.testSetNmae("wanghuangming", "wangyaohui"));
	}
}
