package br.com.uff.internships.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name = "student")
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
public class Student extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "enrollment_code")
	private String enrollmentCode;

	// bi-directional many-to-one association to Experience
	@OneToMany(mappedBy = "student")
	private List<Experience> experiences;

	// bi-directional many-to-many association to Internship
	@ManyToMany(mappedBy = "students")
	private Set<Internship> internships;

	// bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name = "id")
	private User user;

	// bi-directional many-to-many association to ForeignLanguage
	@ManyToMany
	@JoinTable(name = "student_foreign_language", joinColumns = {
			@JoinColumn(name = "foreign_language_id") }, inverseJoinColumns = { @JoinColumn(name = "student_id") })
	private Set<ForeignLanguage> foreignLanguages;

	// bi-directional many-to-many association to Skill
	@ManyToMany
	@JoinTable(name = "student_skill", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	private Set<Skill> skills;

	// bi-directional many-to-one association to StudentForeignLanguage
	@OneToMany(mappedBy = "student")
	private List<StudentForeignLanguage> studentForeignLanguages;

	// bi-directional many-to-one association to StudentSkill
	@OneToMany(mappedBy = "student")
	private Set<StudentSkill> studentSkills;

	public Student() {
	}

	public List<StudentForeignLanguage> getStudentForeignLanguages() {
		return studentForeignLanguages;
	}

	public void setStudentForeignLanguages(List<StudentForeignLanguage> studentForeignLanguages) {
		this.studentForeignLanguages = studentForeignLanguages;
	}

	public Set<StudentSkill> getStudentSkills() {
		return studentSkills;
	}

	public void setStudentSkills(Set<StudentSkill> studentSkills) {
		this.studentSkills = studentSkills;
	}

	public String getEnrollmentCode() {
		return this.enrollmentCode;
	}

	public void setEnrollmentCode(String enrollmentCode) {
		this.enrollmentCode = enrollmentCode;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setStudent(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setStudent(null);

		return experience;
	}

	public Set<Internship> getInternships() {
		return this.internships;
	}

	public void setInternships(Set<Internship> internships) {
		this.internships = internships;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ForeignLanguage> getForeignLanguages() {
		return this.foreignLanguages;
	}

	public void setForeignLanguages(Set<ForeignLanguage> foreignLanguages) {
		this.foreignLanguages = foreignLanguages;
	}

	public Set<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

}