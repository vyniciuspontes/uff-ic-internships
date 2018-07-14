package br.com.uff.internships.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	private List<InternshipStudentStatus> internshipStudentStatuses = new ArrayList<>();

	public InternshipStudent(InternshipStudentPK id) {
		this.id = id;
	}
	
	public InternshipStudent() {
	}

	public InternshipStudentPK getId() {
		return this.id;
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