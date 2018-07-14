package br.com.uff.internships.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CompanyRegistrationForm extends UserRegistrationForm {

	@NotNull
	@Length(min=1,max=14)
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
