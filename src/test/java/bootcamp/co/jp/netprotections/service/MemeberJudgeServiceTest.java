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
		MembersJudgeRequestDto requestDto = new MembersJudgeRequestDto(list);
		MembersJugdeResponseDto result = service.judgeMembers(requestDto);
		Assert.assertEquals(6, result.getJudgedCandidatesResultList().size());
		for(int i=0; i<5; i++)
			Assert.assertEquals(test[i], result.getJudgedCandidatesResultList().get(i).getEnlistedPropriety());
		//test6
		Assert.assertEquals(false, result.getJudgedCandidatesResultList().get(5).getEnlistedPropriety());
		Assert.assertEquals(null, result.getJudgedCandidatesResultList().get(5).getMemberName());
	}
}
