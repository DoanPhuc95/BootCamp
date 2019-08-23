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
		MemberJudgeRequestDto member1 = new MemberJudgeRequestDto("test1", 4, 4, 4, 4, 4);
		MemberJudgeRequestDto member2 = new MemberJudgeRequestDto("test2", 0, 4, 4, 4, 4);
		ArrayList<MemberJudgeRequestDto> list = new ArrayList<>();
		list.add(member1); list.add(member2);
		MembersJudgeRequestDto membersDto = new MembersJudgeRequestDto(list);

		String json = super.mapToJson(membersDto);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json)).andReturn();
		// reposense
		MockHttpServletResponse response = result.getResponse();
		MembersJugdeResponseDto responseObj = new Gson().fromJson(response.getContentAsString(), MembersJugdeResponseDto.class);
		assertEquals(200, response.getStatus());
		assertEquals(responseObj.getJudgedCandidatesResultList().size(), 2);
		
		for(MemberJudgeResponseDto mem: responseObj.getJudgedCandidatesResultList()) {
			if(mem.getMemberName() == "test1")
				Assert.assertEquals(true, mem.getEnlistedPropriety());
			if(mem.getMemberName() == "test2")
				Assert.assertEquals(false, mem.getEnlistedPropriety());
		}
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
	}
}
