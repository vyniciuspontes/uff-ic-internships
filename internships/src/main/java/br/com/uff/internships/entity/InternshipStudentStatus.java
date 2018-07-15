package br.com.uff.internships.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the internship_student_status database table.
 * 
 */
@Entity
@Table(name = "internship_student_status")
@NamedQuery(name = "InternshipStudentStatus.findAll", query = "SELECT i FROM InternshipStudentStatus i")
public class InternshipStudentStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String commentary;

	@Column
	private String status;

	@Column
	private Date datetime;

	// bi-directional many-to-one association to InternshipStudent
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "internship_id", referencedColumnName = "internship_id"),
			@JoinColumn(name = "student_id", referencedColumnName = "student_Id") })
	private InternshipStudent internshipStudent;

	public InternshipStudentStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentary() {
		return this.commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public InternshipStudent getInternshipStudent() {
		return this.internshipStudent;
	}

	public void setInternshipStudent(InternshipStudent internshipStudent) {
		this.internshipStudent = internshipStudent;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	static public enum Status {
		
		PROFILE_ANALYSIS, INTERVIEW_ANALYSIS, APPROVED , REFUSED
	}

}