
package bootcamp.co.jp.netprotections.dto;

import javax.validation.constraints.Size;

public class MemberJudgeRequestDto {
	private String memberName;
	
	@Size(min=1, max=5, message="It must be between 1 and 5")
	private int eventPlanning;
	
	@Size(min=1, max=5, message="It must be between 1 and 5")
	private int cogitation;
	
	@Size(min=1, max=5, message="It must be between 1 and 5")
	private int coodination;
	
	@Size(min=1, max=5, message="It must be between 1 and 5")
	private int programmingAbility;
	
	@Size(min=1, max=5, message="It must be between 1 and 5")
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
	
	public int getTotalPoint() {
		return eventPlanning + cogitation + coodination + programmingAbility + infrastructureKnowledge;
	}
}
