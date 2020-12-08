package dao;
import java.util.List;

import model.EmpSkill;

public interface IEmpSkillDao {
	List<EmpSkill> getAllSkills();
	void addSkills(EmpSkill emp);
	EmpSkill getSkillById(int id);
	void updateSkill(EmpSkill emp);
	//void deactivateSkill(int id);
	int deleteSkill(int id);
}