package bootcamp.co.jp.netprotections.dto;


public class MemberJudgeResponseDto {
	
	private String memberName;
	private boolean enlistedPropriety;
	
	public MemberJudgeResponseDto() {
		super();
	}
	
	public MemberJudgeResponseDto(String memberName, boolean enlistedPropriety) {
		this.memberName = memberName;
		this.enlistedPropriety = enlistedPropriety;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public boolean getEnlistedPropriety() {
		return enlistedPropriety;
	}	
}
