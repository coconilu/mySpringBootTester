package dev.wangyaohui;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import dev.wangyaohui.entity.Person;
import dev.wangyaohui.repository.PersonRepository;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoApplicationTests {
	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext webapp;
	
	@Autowired
	PersonRepository personRepository;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webapp).build();
	}

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void hello() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		Assert.assertEquals("状态码不对", 200, status);
		Assert.assertEquals("返回消息不对", "hello booter!", content);
	}
	
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
