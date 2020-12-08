package model;

public class Job {
	private int JobId;
	private String JobTitle;
	private String JobDescription;
	private String CompanyName;
	private String Location;
	private String KeySkill;
	private String Salary;
	private String Active;
	
	public Job() {
		
	}
	
	public Job( String jobTitle, String jobDescription, String companyName,
			String location, String keySkill,String salary) {
		super();
		this.JobTitle = jobTitle;
		this.JobDescription = jobDescription;
		this.CompanyName = companyName;
		this.Location = location;
		this.KeySkill = keySkill;
		this.Salary = salary;
	}

	public int getJobId() {
		return JobId;
	}

	public void setJobId(int jobId) {
		JobId = jobId;
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}

	public String getJobDescription() {
		return JobDescription;
	}

	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getKeySkill() {
		return KeySkill;
	}

	public void setKeySkill(String keySkill) {
		KeySkill = keySkill;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String s6) {
		Salary = s6;
	}

	public String getActive() {
		return Active;
	}

	public void setActive(String active) {
		Active = active;
	}



	@Override
	public String toString() {
		return "Job [JobId=" + JobId + ", JobTitle=" + JobTitle + ", JobDescription=" + JobDescription
				+ ", CompanyName=" + CompanyName + ", Location=" + Location + ", KeySkill=" + KeySkill + ", Salary="
				+ Salary + ", Active=" + Active + "]";
	}

	

	
}