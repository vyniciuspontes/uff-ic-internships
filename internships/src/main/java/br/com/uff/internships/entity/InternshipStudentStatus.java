package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the internship_student_status database table.
 * 
 */
@Entity
@Table(name="internship_student_status")
@NamedQuery(name="InternshipStudentStatus.findAll", query="SELECT i FROM InternshipStudentStatus i")
public class InternshipStudentStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String commentary;

	private String status;

	//bi-directional many-to-one association to InternshipStudent
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="internship_id", referencedColumnName="internship_id"),
		@JoinColumn(name="student_id", referencedColumnName="student_Id")
		})
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

}