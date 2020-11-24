package model;

public class EmpSkill {
	private int esID;
	private int employeeId;
	private int skillId;
	private String expDate;
	
	public EmpSkill() {
		super();
	}

	public EmpSkill(int employeeId, int skillId, String expDate) {
		super();
		this.employeeId = employeeId;
		this.skillId = skillId;
		this.expDate = expDate;
	}

	public int getEsID() {
		return esID;
	}

	public void setEsID(int esID) {
		this.esID = esID;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "EmpSkill [esID=" + esID + ", employeeId=" + employeeId + ", skillId=" + skillId + ", expDate=" + expDate
				+ "]";
	}
	

}
