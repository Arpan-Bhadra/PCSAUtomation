package dao;

import java.util.List;
import model.Job;

public interface IJobDao {
	List<Job> getAllJob();
	void AddJob(Job emp);
	Job getJobById(int id);
	void updateJob(Job emp);
	void deactivateJob(Job emp);
	void deleteJob(int id);
}
