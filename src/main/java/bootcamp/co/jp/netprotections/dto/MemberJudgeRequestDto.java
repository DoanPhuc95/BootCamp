
package bootcamp.co.jp.netprotections.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class MemberJudgeRequestDto {
	private String memberName;
	
	@Min(0)
	@Max(5)
	private int eventPlanning;
	
	@Min(0)
	@Max(5)
	
	private int cogitation;
	
	@Min(0)
	@Max(5)
	private int coodination;
	
	@Min(0)
	@Max(5)
	private int programmingAbility;
	
	@Min(0)
	@Max(5)
	private int infrastructureKnowledge;

	public MemberJudgeRequestDto(String memberName, int eventPlanning, int cogitation, int coodination, 
			int programmingAbility, int infrastructureKnowledge) {
		this.memberName = memberName;
		this.eventPlanning = eventPlanning;
		this.cogitation = cogitation;
		this.coodination = coodination;
		this.programmingAbility = programmingAbility;
		this.infrastructureKnowledge = infrastructureKnowledge;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getEventPlanning() {
		return eventPlanning;
	}

	public void setEventPlanning(int eventPlanning) {
		this.eventPlanning = eventPlanning;
	}

	public int getCogitation() {
		return cogitation;
	}

	public void setCogitation(int cogitation) {
		this.cogitation = cogitation;
	}

	public int getCoodination() {
		return coodination;
	}

	public void setCoodination(int coodination) {
		this.coodination = coodination;
	}

	public int getProgrammingAbility() {
		return programmingAbility;
	}

	public void setProgrammingAbility(int programmingAbility) {
		this.programmingAbility = programmingAbility;
	}

	public int getInfrastructureKnowledge() {
		return infrastructureKnowledge;
	}

	public void setInfrastructureKnowledge(int infrastructureKnowledge) {
		this.infrastructureKnowledge = infrastructureKnowledge;
	}
	
	@JsonIgnore
	public int getTotalPoint() {
		return eventPlanning + cogitation + coodination + programmingAbility + infrastructureKnowledge;
	}
}
