package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the foreign_language database table.
 * 
 */
@Entity
@Table(name="foreign_language")
@NamedQuery(name="ForeignLanguage.findAll", query="SELECT f FROM ForeignLanguage f")
public class ForeignLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=50)
	private String name;

	//bi-directional many-to-one association to StudentForeignLaguage
	@OneToMany(mappedBy="foreignLanguage")
	private List<StudentForeignLaguage> studentForeignLaguages;

	public ForeignLanguage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentForeignLaguage> getStudentForeignLaguages() {
		return this.studentForeignLaguages;
	}

	public void setStudentForeignLaguages(List<StudentForeignLaguage> studentForeignLaguages) {
		this.studentForeignLaguages = studentForeignLaguages;
	}

	public StudentForeignLaguage addStudentForeignLaguage(StudentForeignLaguage studentForeignLaguage) {
		getStudentForeignLaguages().add(studentForeignLaguage);
		studentForeignLaguage.setForeignLanguage(this);

		return studentForeignLaguage;
	}

	public StudentForeignLaguage removeStudentForeignLaguage(StudentForeignLaguage studentForeignLaguage) {
		getStudentForeignLaguages().remove(studentForeignLaguage);
		studentForeignLaguage.setForeignLanguage(null);

		return studentForeignLaguage;
	}

}