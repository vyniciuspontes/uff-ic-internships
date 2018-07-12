package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="enrollment_code")
	private String enrollmentCode;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="student")
	private List<Experience> experiences;

	//bi-directional many-to-many association to Internship
	@ManyToMany(mappedBy="students")
	private List<Internship> internships;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="id")
	private User user;

	//bi-directional many-to-many association to ForeignLanguage
	@ManyToMany
	@JoinTable(
		name="student_foreign_language"
		, joinColumns={
			@JoinColumn(name="foreign_language_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="student_id")
			}
		)
	private List<ForeignLanguage> foreignLanguages;

	//bi-directional many-to-many association to Skill
	@ManyToMany
	@JoinTable(
		name="student_skill"
		, joinColumns={
			@JoinColumn(name="student_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="skill_id")
			}
		)
	private List<Skill> skills;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Internship> getInternships() {
		return this.internships;
	}

	public void setInternships(List<Internship> internships) {
		this.internships = internships;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ForeignLanguage> getForeignLanguages() {
		return this.foreignLanguages;
	}

	public void setForeignLanguages(List<ForeignLanguage> foreignLanguages) {
		this.foreignLanguages = foreignLanguages;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

}