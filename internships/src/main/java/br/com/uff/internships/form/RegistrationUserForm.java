package br.com.uff.internships.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RegistrationUserForm {

	@NotEmpty
	@NotNull
	private String name;

	@NotEmpty
	@NotNull
	private String bornDate;
	
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
	
	public RegistrationUserForm() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
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
