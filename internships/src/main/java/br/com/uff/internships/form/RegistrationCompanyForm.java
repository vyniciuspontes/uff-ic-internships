package br.com.uff.internships.form;

import javax.validation.constraints.NotNull;

public class RegistrationCompanyForm extends RegistrationUserForm{
	
	@NotNull
	private String cnpj;

	public RegistrationCompanyForm() {}
	
	public String getEnrollmentCode() {
		return cnpj;
	}

	public void setCnjpCode(String cnpj) {
		this.cnpj = cnpj;
	}
}
