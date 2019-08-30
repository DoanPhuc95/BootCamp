package bootcamp.co.jp.netprotections.controller;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;

import bootcamp.co.jp.netprotections.dto.*;

public class MemberJudgeControllerTest extends AbstractTest{
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void testCheckUser() throws Exception {
		String uri = "/api/v1/check";
		// create request object
		MemberJudgeRequestDto member1 = new MemberJudgeRequestDto("test0", 4, 4, 4, 4, 4);
		MemberJudgeRequestDto member2 = new MemberJudgeRequestDto("test1", 0, 4, 4, 4, 4);
		MemberJudgeRequestDto member3 = new MemberJudgeRequestDto("test2", 4, 0, 4, 4, 4);
		MemberJudgeRequestDto member4 = new MemberJudgeRequestDto("test3", 4, 4, 0, 4, 4);
		MemberJudgeRequestDto member5 = new MemberJudgeRequestDto("test4", 1, 1, 1, 1, 1);
		MemberJudgeRequestDto member6 = new MemberJudgeRequestDto("", 4, 4, 4, 4, 4);
		boolean test[] = {true, false, false, false, false};
		ArrayList<MemberJudgeRequestDto> list = new ArrayList<>();
		list.add(member1); list.add(member2); list.add(member3); 
		list.add(member4); list.add(member5); list.add(member6);
		MembersJudgeRequestDto membersDto = new MembersJudgeRequestDto(list);

		String json = super.mapToJson(membersDto);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json)).andReturn();
		// response
		MockHttpServletResponse response = result.getResponse();
		MembersJugdeResponseDto responseObj = new Gson().fromJson(response.getContentAsString(), MembersJugdeResponseDto.class);
		assertEquals(200, response.getStatus());
		assertEquals(responseObj.getJudgedCandidatesResultList().size(), 6);
		for(int i=0; i<5; i++)
			Assert.assertEquals(test[i], responseObj.getJudgedCandidatesResultList().get(i).getEnlistedPropriety());
		//test6
		Assert.assertEquals(false, responseObj.getJudgedCandidatesResultList().get(5).getEnlistedPropriety());
		Assert.assertEquals(null, responseObj.getJudgedCandidatesResultList().get(5).getMemberName());
	}
	
	@Test
	public void testUnsualUser() throws Exception {
		String uri = "/api/v1/check";
		// create request object
		MemberJudgeRequestDto member1 = new MemberJudgeRequestDto("test1", 4, 4, 4, 4, 4);
		MemberJudgeRequestDto member2 = new MemberJudgeRequestDto("test2", 0, 7, 4, 4, 5);
		ArrayList<MemberJudgeRequestDto> list = new ArrayList<>();
		list.add(member1); list.add(member2);
		MembersJudgeRequestDto membersDto = new MembersJudgeRequestDto(list);

		String json = super.mapToJson(membersDto);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json)).andReturn();
		assertEquals(400, result.getResponse().getStatus());
		
		//全角
		json = "{\"memberCandidatesList\":[{\"memberName\":\"野崎\",\"eventPlanning\":3,\"cogitation\":４,\"coodination\":1,\"programmingAbility\":1,\"infrastructureKnowledge\":1}]}";
		result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json)).andReturn();
		assertEquals(400, result.getResponse().getStatus());
	}
	
	@Test
	public void testNullUser() throws Exception {
		String uri = "/api/v1/check";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("")).andReturn();
		
		assertEquals(400, result.getResponse().getStatus());
	}
}
