package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the coordinator database table.
 * 
 */
@Entity
@Table(name="coordinator")
@NamedQuery(name="Coordinator.findAll", query="SELECT c FROM Coordinator c")
public class Coordinator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="teacher_code")
	private String teacherCode;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="id")
	private User user;

	public Coordinator() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherCode() {
		return this.teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}