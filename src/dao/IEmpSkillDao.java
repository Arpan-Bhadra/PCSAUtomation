package dao;
import java.util.List;

import model.EmpSkill;
public interface IEmpSkillDao {
	List<EmpSkill> getAllEmpSkill();
	void AddEmpSkill(EmpSkill emp);
	EmpSkill getEmpSkillById(int id);
	void updateEmpSkill(EmpSkill emp);
	void deactivateEmpSkill(EmpSkill emp);
	void deleteEmpSkill(int id);

}
