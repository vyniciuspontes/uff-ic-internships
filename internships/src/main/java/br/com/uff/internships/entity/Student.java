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
public class Student extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="enrollment_code", nullable=false, length=20)
	private String enrollmentCode;

	@Column(length=3000)
	private String resume;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="student")
	private List<Experience> experiences;

	//bi-directional many-to-many association to Internship
	@ManyToMany(mappedBy="students")
	private List<Internship> internships;

	//bi-directional many-to-one association to StudentForeignLaguage
	@OneToMany(mappedBy="student")
	private List<StudentForeignLaguage> studentForeignLaguages;

	//bi-directional many-to-one association to StudentSkill
	@OneToMany(mappedBy="student")
	private List<StudentSkill> studentSkills;

	public Student() {
	}

	public String getEnrollmentCode() {
		return this.enrollmentCode;
	}

	public void setEnrollmentCode(String enrollmentCode) {
		this.enrollmentCode = enrollmentCode;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
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

	public List<StudentForeignLaguage> getStudentForeignLaguages() {
		return this.studentForeignLaguages;
	}

	public void setStudentForeignLaguages(List<StudentForeignLaguage> studentForeignLaguages) {
		this.studentForeignLaguages = studentForeignLaguages;
	}

	public StudentForeignLaguage addStudentForeignLaguage(StudentForeignLaguage studentForeignLaguage) {
		getStudentForeignLaguages().add(studentForeignLaguage);
		studentForeignLaguage.setStudent(this);

		return studentForeignLaguage;
	}

	public StudentForeignLaguage removeStudentForeignLaguage(StudentForeignLaguage studentForeignLaguage) {
		getStudentForeignLaguages().remove(studentForeignLaguage);
		studentForeignLaguage.setStudent(null);

		return studentForeignLaguage;
	}

	public List<StudentSkill> getStudentSkills() {
		return this.studentSkills;
	}

	public void setStudentSkills(List<StudentSkill> studentSkills) {
		this.studentSkills = studentSkills;
	}

	public StudentSkill addStudentSkill(StudentSkill studentSkill) {
		getStudentSkills().add(studentSkill);
		studentSkill.setStudent(this);

		return studentSkill;
	}

	public StudentSkill removeStudentSkill(StudentSkill studentSkill) {
		getStudentSkills().remove(studentSkill);
		studentSkill.setStudent(null);

		return studentSkill;
	}

	@Override
	public String toString() {
		return "Student [enrollmentCode=" + enrollmentCode + ", resume=" + resume + ", getId()=" + getId()
				+ ", getAddress()=" + getAddress() + ", getBirthDate()=" + getBirthDate() + ", getComplement()="
				+ getComplement() + ", getEmail()=" + getEmail() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getPassword()=" + getPassword() + ", getCity()=" + getCity()
				+ "]";
	}
	
	

}