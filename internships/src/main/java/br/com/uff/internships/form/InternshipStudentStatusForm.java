package br.com.uff.internships.form;

import br.com.uff.internships.entity.InternshipStudentStatus;

public class InternshipStudentStatusForm {

	private Integer studentId;
	private InternshipStudentStatus.Status currentStatus;
	private Integer InternshipId;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public InternshipStudentStatus.Status getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(InternshipStudentStatus.Status currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Integer getInternshipId() {
		return InternshipId;
	}

	public void setInternshipId(Integer internshipId) {
		InternshipId = internshipId;
	}

}
