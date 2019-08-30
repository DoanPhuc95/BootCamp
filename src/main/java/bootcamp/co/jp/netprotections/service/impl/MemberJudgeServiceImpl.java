package bootcamp.co.jp.netprotections.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import bootcamp.co.jp.netprotections.dto.MemberJudgeRequestDto;
import bootcamp.co.jp.netprotections.dto.MemberJudgeResponseDto;
import bootcamp.co.jp.netprotections.dto.MembersJudgeRequestDto;
import bootcamp.co.jp.netprotections.dto.MembersJugdeResponseDto;
import bootcamp.co.jp.netprotections.service.MemberJudgeService;

@Service
public class MemberJudgeServiceImpl implements MemberJudgeService {

	@Override
	public MembersJugdeResponseDto judgeMembers(MembersJudgeRequestDto members) {
		ArrayList list = new ArrayList<MemberJudgeResponseDto>();
		MembersJugdeResponseDto result = new MembersJugdeResponseDto(list);
		for(MemberJudgeRequestDto member : members.getMemberCandidatesList()) 
			list.add(checkMember(member));
		
		return result;
	}
	
	private MemberJudgeResponseDto checkMember(MemberJudgeRequestDto member) {
		if(member.getMemberName() == null || member.getMemberName() == "") 
			return new MemberJudgeResponseDto(null, false);
		if((member.getEventPlanning() < 1) || member.getCogitation() < 1 || 
				member.getCoodination() < 1 || member.getTotalPoint() < 10)
			return new MemberJudgeResponseDto(member.getMemberName(), false);
		
		return new MemberJudgeResponseDto(member.getMemberName(), true);
	}
}
