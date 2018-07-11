package br.com.uff.internships.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.uff.internships.entity.ForeignLanguage;
import br.com.uff.internships.entity.Skill;

public class RegistrationStudentForm extends RegistrationUserForm {

	@NotNull
	private String enrollmentCode;

	private List<ForeignLanguage> foreignLanguages;

	private List<Skill> skills;

	public RegistrationStudentForm() {
	}

	public String getEnrollmentCode() {
		return enrollmentCode;
	}

	public void setEnrollmentCode(String enrollmentCode) {
		this.enrollmentCode = enrollmentCode;
	}

	public List<ForeignLanguage> getForeignLanguages() {
		return foreignLanguages;
	}

	public void setForeignLanguages(List<ForeignLanguage> foreignLanguages) {
		this.foreignLanguages = foreignLanguages;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "RegistrationStudentForm [enrollmentCode=" + enrollmentCode + ", getName()=" + getName()
				+ ", getBirthDate()=" + getBornDate() + ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress()
				+ ", getComplement()=" + getComplement() + ", getPassword()=" + getPassword() + ", getCityId()="
				+ getCityId() + ", getResume()=" + getResume() + "]";
	}
}
