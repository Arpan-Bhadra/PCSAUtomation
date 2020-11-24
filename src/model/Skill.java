package model;

public class Skill {
	private int skillID;
	private String skillName;
	private String skillDescription;
	private String active;
	public Skill() {
		super();
	}
	public Skill(String skillName, String skillDescription, String active) {
		super();
		this.skillName = skillName;
		this.skillDescription = skillDescription;
		this.active = active;
	}
	public int getSkillID() {
		return skillID;
	}
	public void setSkillID(int skillID) {
		this.skillID = skillID;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillDescription() {
		return skillDescription;
	}
	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Skill [skillID=" + skillID + ", skillName=" + skillName + ", skillDescription=" + skillDescription
				+ ", active=" + active + "]";
	}
	
}
