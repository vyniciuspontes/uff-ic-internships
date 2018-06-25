package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the internship database table.
 * 
 */
@Entity
@Table(name="internship")
@NamedQuery(name="Internship.findAll", query="SELECT i FROM Internship i")
public class Internship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(precision=10, scale=2)
	private BigDecimal allowance;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date deadline;

	@Column(length=3000)
	private String description;

	@Column(nullable=false, length=50)
	private String title;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id", nullable=false)
	private Company company;

	//bi-directional many-to-many association to Skill
	@ManyToMany
	@JoinTable(
		name="internship_skill"
		, joinColumns={
			@JoinColumn(name="internship_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="skill_id", nullable=false)
			}
		)
	private List<Skill> skills;

	//bi-directional many-to-many association to Student
	@ManyToMany
	@JoinTable(
		name="internship_student"
		, joinColumns={
			@JoinColumn(name="internship_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="student_Id", nullable=false)
			}
		)
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

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}