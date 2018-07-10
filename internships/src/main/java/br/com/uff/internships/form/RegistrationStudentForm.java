package br.com.uff.internships.form;

import javax.validation.constraints.NotNull;

public class RegistrationStudentForm extends RegistrationUserForm{
	
	@NotNull
	private String enrollmentCode;

	public RegistrationStudentForm() {}
	
	public String getEnrollmentCode() {
		return enrollmentCode;
	}

	public void setEnrollmentCode(String enrollmentCode) {
		this.enrollmentCode = enrollmentCode;
	}

	@Override
	public String toString() {
		return "RegistrationStudentForm [enrollmentCode=" + enrollmentCode + ", getName()=" + getName()
				+ ", getBirthDate()=" + getBirthDate() + ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress()
				+ ", getComplement()=" + getComplement() + ", getPassword()=" + getPassword() + ", getCityId()="
				+ getCityId() + ", getResume()=" + getResume() + "]";
	}
}
