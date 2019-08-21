package bootcamp.co.jp.netprotections.dto;

import java.util.ArrayList;

import javax.validation.Valid;

public class MembersJudgeRequestDto {
	
	private ArrayList<MemberJudgeRequestDto> memberCandidatesList;
	
	public MembersJudgeRequestDto() {
		super();
	}

	public MembersJudgeRequestDto(ArrayList<MemberJudgeRequestDto> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
	}
	
	public ArrayList<MemberJudgeRequestDto> getMemberCandidatesList() {
		return memberCandidatesList;
	}
}
