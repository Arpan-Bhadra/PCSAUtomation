package dao;

import java.util.List;

import model.Skill;

public interface ISkillDao {
	List<Skill> getAllSkills();
	void addSkill(Skill sk);
	Skill getSkillById(int id);
	void updateSkill(Skill sk);
	void deleteSkill(int id);
	void deactivateSkill(int id);
}