package model;

public class EmpSkill {

	private int ESId;
	private int EmployeeId;
	private int SkillId;
	private int ExpYear;
	
	public EmpSkill() {
		
	}

	

	public EmpSkill(int employeeId, int skillId, int expYear) {
		super();
		this.EmployeeId = employeeId;
		this.SkillId = skillId;
		this.ExpYear = expYear;
	}



	public int getESId() {
		return ESId;
	}

	public void setESId(int eSId) {
		ESId = eSId;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public int getSkillId() {
		return SkillId;
	}

	public void setSkillId(int skillId) {
		SkillId = skillId;
	}

	public int getExpYear() {
		return ExpYear;
	}

	public void setExpYear(int expYear) {
		ExpYear = expYear;
	}

	@Override
	public String toString() {
		return "EmpSkill [ESId=" + ESId + ", EmployeeId=" + EmployeeId + ", SkillId=" + SkillId + ", ExpYear=" + ExpYear
				+ "]";
	}
	
	
}