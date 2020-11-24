package dao;
import java.util.List;

import model.Skill;
public interface ISkillDao {
	List<Skill> getAllSkill();
	void AddSkill(Skill emp);
	Skill getSkillById(int id);
	void updateSkill(Skill emp);
	void deactivateSkill(Skill emp);
	void deleteSkill(int id);

}
