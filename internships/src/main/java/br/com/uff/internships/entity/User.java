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
@NamedQueries({
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u where u.email=?")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 100)
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;

	@Column(length = 100)
	private String complement;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 80)
	private String lastName;

	@Column(nullable = false, length = 100)
	private String password;

	// bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

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

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", address=" + address + ", birthDate=" + birthDate + ", complement=" + complement
				+ ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", city=" + city + "]";
	}

}