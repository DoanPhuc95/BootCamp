package bootcamp.co.jp.netprotections.service;

import bootcamp.co.jp.netprotections.dto.MembersJudgeRequestDto;
import bootcamp.co.jp.netprotections.dto.MembersJugdeResponseDto;

public interface MemberJudgeService {
	public abstract MembersJugdeResponseDto judgeMembers(MembersJudgeRequestDto members);
}
