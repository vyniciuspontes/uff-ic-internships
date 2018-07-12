package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the student_foreign_laguage database table.
 * 
 */
@Entity
@Table(name = "student_foreign_language")
@NamedQuery(name = "StudentForeignLanguage.findAll", query = "SELECT s FROM StudentForeignLanguage s")
public class StudentForeignLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudentForeignLanguagePK id;

	@Column(name = "level", nullable = false, length = 1)
	private String level;

	// bi-directional many-to-one association to ForeignLanguage
	@ManyToOne
	@JoinColumn(name = "foreign_language_id", nullable = false, insertable = false, updatable = false)
	private ForeignLanguage foreignLanguage;

	// bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false, insertable = false, updatable = false)
	private Student student;

	public StudentForeignLanguage() {
	}

	public StudentForeignLanguagePK getId() {
		return this.id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setId(StudentForeignLanguagePK id) {
		this.id = id;
	}

	public ForeignLanguage getForeignLanguage() {
		return this.foreignLanguage;
	}

	public void setForeignLanguage(ForeignLanguage foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}