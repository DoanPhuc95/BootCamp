package bootcamp.co.jp.netprotections.dto;

import java.util.ArrayList;

public class MembersJugdeResponseDto {
	private ArrayList<MemberJudgeResponseDto> judgedCandidatesResultList;
	
	public MembersJugdeResponseDto(ArrayList<MemberJudgeResponseDto> judgedCandidatesResultList) {
		this.judgedCandidatesResultList = judgedCandidatesResultList;
	}
	
	public ArrayList<MemberJudgeResponseDto> getJudgedCandidatesResultList() {
		return judgedCandidatesResultList;
	}
}
