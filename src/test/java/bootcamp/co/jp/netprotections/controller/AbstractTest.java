package bootcamp.co.jp.netprotections.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.co.jp.netprotections.NetprotectionsApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=NetprotectionsApplication.class)
@WebAppConfiguration
public abstract class AbstractTest {
	protected MockMvc mvc;
	
	@Autowired
	WebApplicationContext webContext;
	
	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}
	
	protected String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		String json = objMapper.writeValueAsString(object);
		return json;
	}
}
