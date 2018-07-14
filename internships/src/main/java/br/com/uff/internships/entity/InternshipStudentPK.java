package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the internship_student database table.
 * 
 */
@Embeddable
public class InternshipStudentPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "internship_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int internshipId;

	@Column(name = "student_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int studentId;

	public InternshipStudentPK() {
	}

	public InternshipStudentPK(int internshipId, int studentId) {
		super();
		this.internshipId = internshipId;
		this.studentId = studentId;
	}

	public int getInternshipId() {
		return this.internshipId;
	}

	public void setInternshipId(int internshipId) {
		this.internshipId = internshipId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InternshipStudentPK)) {
			return false;
		}
		InternshipStudentPK castOther = (InternshipStudentPK) other;
		return (this.internshipId == castOther.internshipId) && (this.studentId == castOther.studentId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.internshipId;
		hash = hash * prime + this.studentId;

		return hash;
	}
}