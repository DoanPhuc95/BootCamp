package bootcamp.co.jp.netprotections.service;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import bootcamp.co.jp.netprotections.dto.MemberJudgeRequestDto;
import bootcamp.co.jp.netprotections.dto.MemberJudgeResponseDto;
import bootcamp.co.jp.netprotections.dto.MembersJudgeRequestDto;
import bootcamp.co.jp.netprotections.dto.MembersJugdeResponseDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemeberJudgeServiceTest {
	@Autowired
	private MemberJudgeService service;
	
	@Test
	public void testJudgeMembers() {
		MemberJudgeRequestDto member1 = new MemberJudgeRequestDto("test1", 4, 4, 4, 4, 4);
		MemberJudgeRequestDto member2 = new MemberJudgeRequestDto("test2", 0, 4, 4, 4, 4);
		ArrayList<MemberJudgeRequestDto> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		MembersJudgeRequestDto requestDto = new MembersJudgeRequestDto(list);
		MembersJugdeResponseDto result =service.judgeMembers(requestDto);
		Assert.assertEquals(2, result.getJudgedCandidatesResultList().size());
		for(MemberJudgeResponseDto mem: result.getJudgedCandidatesResultList()) {
			if(mem.getMemberName() == "test1")
				Assert.assertEquals(true, mem.getEnlistedPropriety());
			if(mem.getMemberName() == "test2")
				Assert.assertEquals(false, mem.getEnlistedPropriety());
		}
	}
}
