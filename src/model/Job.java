package model;

public class Job {

	private int jobID;
	private String jobTitle;
	private  String jobDescription;
	private  String companyName;
	private  String location;
	private  String keySkill;
	private  float salary;
	private  String active;
	public Job() {
		super();
		
	}
	
	public Job(String jobTitle, String jobDescription, String companyName, String location, String keySkill,
			float salary) {
		super();
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.companyName = companyName;
		this.location = location;
		this.keySkill = keySkill;
		this.salary = salary;
	}

	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getKeySkill() {
		return keySkill;
	}
	public void setKeySkill(String keySkill) {
		this.keySkill = keySkill;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Job [jobID=" + jobID + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription
				+ ", companyName=" + companyName + ", location=" + location + ", keySkill=" + keySkill + ", salary="
				+ salary + ", active=" + active + "]";
	}
	
}