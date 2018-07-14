package br.com.uff.internships.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the internship database table.
 * 
 */
@Entity
@Table(name = "internship")
@NamedQuery(name = "Internship.findAll", query = "SELECT i FROM Internship i")
public class Internship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private BigDecimal allowance;

	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;

	private String description;

	private String title;

	// bi-directional many-to-one association to Company
	@ManyToOne(fetch=FetchType.EAGER)
	private Company company;

	// bi-directional many-to-many association to Skill
	@ManyToMany
	@JoinTable(name = "internship_skill", joinColumns = { @JoinColumn(name = "internship_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	private List<Skill> skills = new ArrayList<>();

	// bi-directional many-to-many association to Student
	@ManyToMany
	@JoinTable(name = "internship_student", joinColumns = {
			@JoinColumn(name = "internship_id") }, inverseJoinColumns = { @JoinColumn(name = "student_Id") })
	private List<Student> students;

	public Internship() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAllowance() {
		return this.allowance;
	}

	public void setAllowance(BigDecimal allowance) {
		this.allowance = allowance;
	}

	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void addSkill(Skill skill) {

		this.skills.add(skill);
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}