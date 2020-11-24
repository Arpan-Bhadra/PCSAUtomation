package model;

public class EmpJob {
	private int ejID;
	private int employeeId;
	private int jobId;
	private String recruited;
	public EmpJob() {
		super();
		
	}
	public EmpJob(int employeeId, int jobId, String recruited) {
		super();
		this.employeeId = employeeId;
		this.jobId = jobId;
		this.recruited = recruited;
	}
	public int getEjID() {
		return ejID;
	}
	public void setEjID(int ejID) {
		this.ejID = ejID;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getRecruited() {
		return recruited;
	}
	public void setRecruited(String recruited) {
		this.recruited = recruited;
	}
	@Override
	public String toString() {
		return "EmpJob [ejID=" + ejID + ", employeeId=" + employeeId + ", jobId=" + jobId + ", recruited=" + recruited
				+ "]";
	}
	
	}	