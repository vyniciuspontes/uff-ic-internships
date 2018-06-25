package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student_foreign_laguage database table.
 * 
 */
@Entity
@Table(name="student_foreign_laguage")
@NamedQuery(name="StudentForeignLaguage.findAll", query="SELECT s FROM StudentForeignLaguage s")
public class StudentForeignLaguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudentForeignLaguagePK id;

	@Column(name="reading_level", nullable=false, length=1)
	private String readingLevel;

	@Column(name="speaking_level", nullable=false, length=1)
	private String speakingLevel;

	@Column(name="writting_level", nullable=false, length=1)
	private String writtingLevel;

	//bi-directional many-to-one association to ForeignLanguage
	@ManyToOne
	@JoinColumn(name="foreign_language_id", nullable=false, insertable=false, updatable=false)
	private ForeignLanguage foreignLanguage;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="student_id", nullable=false, insertable=false, updatable=false)
	private Student student;

	public StudentForeignLaguage() {
	}

	public StudentForeignLaguagePK getId() {
		return this.id;
	}

	public void setId(StudentForeignLaguagePK id) {
		this.id = id;
	}

	public String getReadingLevel() {
		return this.readingLevel;
	}

	public void setReadingLevel(String readingLevel) {
		this.readingLevel = readingLevel;
	}

	public String getSpeakingLevel() {
		return this.speakingLevel;
	}

	public void setSpeakingLevel(String speakingLevel) {
		this.speakingLevel = speakingLevel;
	}

	public String getWrittingLevel() {
		return this.writtingLevel;
	}

	public void setWrittingLevel(String writtingLevel) {
		this.writtingLevel = writtingLevel;
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