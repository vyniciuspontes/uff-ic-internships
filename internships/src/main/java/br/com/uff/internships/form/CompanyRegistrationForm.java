package br.com.uff.internships.form;

import javax.validation.constraints.NotNull;

public class CompanyRegistrationForm extends UserRegistrationForm {

	@NotNull
	private String cnpj;

	@NotNull
	private Integer coreActivityId;

	public CompanyRegistrationForm() {
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getCoreActivityId() {
		return coreActivityId;
	}

	public void setCoreActivityId(Integer coreActivityId) {
		this.coreActivityId = coreActivityId;
	}
}
