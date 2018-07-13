package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the skill database table.
 * 
 */
@Entity
@Table(name = "skill")
@NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	// bi-directional many-to-many association to Internship
	@ManyToMany(mappedBy = "skills")
	private List<Internship> internships;

	// bi-directional many-to-many association to Student
	@ManyToMany(mappedBy = "skills")
	private List<Student> students;

	public Skill() {
	}

	public Skill(Integer id) {
		this.id = id;
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

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}