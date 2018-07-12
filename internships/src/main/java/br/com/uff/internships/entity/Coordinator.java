package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the coordinator database table.
 * 
 */
@Entity
@Table(name = "coordinator")
@NamedQuery(name = "Coordinator.findAll", query = "SELECT c FROM Coordinator c")
public class Coordinator extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "teacher_code", nullable = false, length = 20)
	private String teacherCode;

	public Coordinator() {
	}

	public String getTeacherCode() {
		return this.teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

}