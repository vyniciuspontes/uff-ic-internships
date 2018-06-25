package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the student_skill database table.
 * 
 */
@Embeddable
public class StudentSkillPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="student_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int studentId;

	@Column(name="skill_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int skillId;

	public StudentSkillPK() {
	}
	public int getStudentId() {
		return this.studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSkillId() {
		return this.skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StudentSkillPK)) {
			return false;
		}
		StudentSkillPK castOther = (StudentSkillPK)other;
		return 
			(this.studentId == castOther.studentId)
			&& (this.skillId == castOther.skillId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.studentId;
		hash = hash * prime + this.skillId;
		
		return hash;
	}
}