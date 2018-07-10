package br.com.uff.internships.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u where u.email=?") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 100)
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name = "born_date", nullable = false)
	private Date bornDate;

	@Column(length = 100)
	private String complement;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 100)
	private String password;

	// bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	@Column(nullable = true, length = 3000)
	private String resume;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBornDate() {
		return this.bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getComplement() {
		return this.complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", address=" + address + ", bornDate=" + bornDate + ", complement=" + complement
				+ ", email=" + email + ", name=" + name + ", password=" + password + ", city=" + city + ", resume="
				+ resume + "]";
	}

}