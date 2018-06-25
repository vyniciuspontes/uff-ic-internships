package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the skill database table.
 * 
 */
@Entity
@Table(name="skill")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=50)
	private String name;

	//bi-directional many-to-many association to Internship
	@ManyToMany(mappedBy="skills")
	private List<Internship> internships;

	//bi-directional many-to-one association to StudentSkill
	@OneToMany(mappedBy="skill")
	private List<StudentSkill> studentSkills;

	public Skill() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Internship> getInternships() {
		return this.internships;
	}

	public void setInternships(List<Internship> internships) {
		this.internships = internships;
	}

	public List<StudentSkill> getStudentSkills() {
		return this.studentSkills;
	}

	public void setStudentSkills(List<StudentSkill> studentSkills) {
		this.studentSkills = studentSkills;
	}

	public StudentSkill addStudentSkill(StudentSkill studentSkill) {
		getStudentSkills().add(studentSkill);
		studentSkill.setSkill(this);

		return studentSkill;
	}

	public StudentSkill removeStudentSkill(StudentSkill studentSkill) {
		getStudentSkills().remove(studentSkill);
		studentSkill.setSkill(null);

		return studentSkill;
	}

}