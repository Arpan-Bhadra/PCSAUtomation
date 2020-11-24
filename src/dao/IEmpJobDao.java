package dao;

import java.util.List;

import model.EmpJob;

public interface IEmpJobDao {
	List<EmpJob> getAllEmpJob();
	void AddEmpJob(EmpJob emp);
	EmpJob getEmpJobById(int id);
	void updateEmpJob(EmpJob id);
	void deactivateEmpJob(EmpJob emp);
	void deleteEmpJob(int id);

}

