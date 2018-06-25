package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the internship_student database table.
 * 
 */
@Entity
@Table(name="internship_student")
@NamedQuery(name="InternshipStudent.findAll", query="SELECT i FROM InternshipStudent i")
public class InternshipStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InternshipStudentPK id;

	//bi-directional many-to-one association to InternshipStudentStatus
	@OneToMany(mappedBy="internshipStudent")
	private List<InternshipStudentStatus> internshipStudentStatuses;

	public InternshipStudent() {
	}

	public InternshipStudentPK getId() {
		return this.id;
	}

	public void setId(InternshipStudentPK id) {
		this.id = id;
	}

	public List<InternshipStudentStatus> getInternshipStudentStatuses() {
		return this.internshipStudentStatuses;
	}

	public void setInternshipStudentStatuses(List<InternshipStudentStatus> internshipStudentStatuses) {
		this.internshipStudentStatuses = internshipStudentStatuses;
	}

	public InternshipStudentStatus addInternshipStudentStatus(InternshipStudentStatus internshipStudentStatus) {
		getInternshipStudentStatuses().add(internshipStudentStatus);
		internshipStudentStatus.setInternshipStudent(this);

		return internshipStudentStatus;
	}

	public InternshipStudentStatus removeInternshipStudentStatus(InternshipStudentStatus internshipStudentStatus) {
		getInternshipStudentStatuses().remove(internshipStudentStatus);
		internshipStudentStatus.setInternshipStudent(null);

		return internshipStudentStatus;
	}

}