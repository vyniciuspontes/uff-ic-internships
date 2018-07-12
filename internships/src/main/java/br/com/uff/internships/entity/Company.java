package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=14)
	private String cnpj;

	//bi-directional many-to-one association to CoreActivity
	@ManyToOne
	@JoinColumn(name="core_activity_id", nullable=false)
	private CoreActivity coreActivity;

	//bi-directional many-to-one association to Internship
	@OneToMany(mappedBy="company")
	private List<Internship> internships;

	public Company() {
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public CoreActivity getCoreActivity() {
		return this.coreActivity;
	}

	public void setCoreActivity(CoreActivity coreActivity) {
		this.coreActivity = coreActivity;
	}

	public List<Internship> getInternships() {
		return this.internships;
	}

	public void setInternships(List<Internship> internships) {
		this.internships = internships;
	}

	public Internship addInternship(Internship internship) {
		getInternships().add(internship);
		internship.setCompany(this);

		return internship;
	}

	public Internship removeInternship(Internship internship) {
		getInternships().remove(internship);
		internship.setCompany(null);

		return internship;
	}

}