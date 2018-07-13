package br.com.uff.internships.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class UserRegistrationForm {

	@NotEmpty
	@NotNull
	private String name;

	@NotNull
	@DateTimeFormat (pattern="yyyy-MM-dd") 
	private Date bornDate;
	
	@NotEmpty
	@NotNull
	@Email
	private String email;

	@NotNull
	private String address;

	@NotNull
	private String complement;

	@NotEmpty
	@NotNull
	private String password;

	@NotNull
	private Integer cityId;

	private String resume;
	
	public UserRegistrationForm() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}
