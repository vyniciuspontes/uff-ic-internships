package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the student_foreign_laguage database table.
 * 
 */
@Embeddable
public class StudentForeignLanguagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="student_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int studentId;

	@Column(name="foreign_language_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int foreignLanguageId;

	public StudentForeignLanguagePK() {
	}
	public int getStudentId() {
		return this.studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getForeignLanguageId() {
		return this.foreignLanguageId;
	}
	public void setForeignLanguageId(int foreignLanguageId) {
		this.foreignLanguageId = foreignLanguageId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StudentForeignLanguagePK)) {
			return false;
		}
		StudentForeignLanguagePK castOther = (StudentForeignLanguagePK)other;
		return 
			(this.studentId == castOther.studentId)
			&& (this.foreignLanguageId == castOther.foreignLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.studentId;
		hash = hash * prime + this.foreignLanguageId;
		
		return hash;
	}
}