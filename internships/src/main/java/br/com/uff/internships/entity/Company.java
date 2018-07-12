package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String cnpj;

	//bi-directional many-to-one association to CoreActivity
	@ManyToOne
	@JoinColumn(name="core_activity_id")
	private CoreActivity coreActivity;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="id")
	private User user;

	//bi-directional many-to-one association to Internship
	@OneToMany(mappedBy="company")
	private List<Internship> internships;

	public Company() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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