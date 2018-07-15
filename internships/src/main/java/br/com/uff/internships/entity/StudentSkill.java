package br.com.uff.internships.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the student_skill database table.
 * 
 */
@Entity
@Table(name = "student_skill")
@NamedQuery(name = "StudentSkill.findAll", query = "SELECT s FROM StudentSkill s")
public class StudentSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudentSkillPK id;

	@Column(name = "level", nullable = false, length = 1)
	private String level;

	// bi-directional many-to-one association to Skill
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "skill_id", nullable = false, insertable = false, updatable = false)
	private Skill skill;

	// bi-directional many-to-one association to Student
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false, insertable = false, updatable = false)
	private Student student;

	public StudentSkill() {
	}

	public StudentSkillPK getId() {
		return this.id;
	}

	public void setId(StudentSkillPK id) {
		this.id = id;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}