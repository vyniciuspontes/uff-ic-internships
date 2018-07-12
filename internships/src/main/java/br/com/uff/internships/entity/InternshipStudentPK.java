package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the internship_student database table.
 * 
 */
@Embeddable
public class InternshipStudentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="internship_id", insertable=false, updatable=false, unique=true, nullable=false) 
	private int internshipId;

	 @Column(insertable=false, updatable=false, unique=true, nullable=false) 
	private int student_Id;

	public InternshipStudentPK() {
	}
	public int getInternshipId() {
		return this.internshipId;
	}
	public void setInternshipId(int internshipId) {
		this.internshipId = internshipId;
	}
	public int getStudent_Id() {
		return this.student_Id;
	}
	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InternshipStudentPK)) {
			return false;
		}
		InternshipStudentPK castOther = (InternshipStudentPK)other;
		return 
			(this.internshipId == castOther.internshipId)
			&& (this.student_Id == castOther.student_Id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.internshipId;
		hash = hash * prime + this.student_Id;
		
		return hash;
	}
}