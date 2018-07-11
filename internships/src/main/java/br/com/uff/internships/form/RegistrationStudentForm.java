package br.com.uff.internships.form;

import java.util.Map;

import javax.validation.constraints.NotNull;

public class RegistrationStudentForm extends RegistrationUserForm {

	@NotNull
	private String enrollmentCode;

	private Map<Integer, Integer> foreignLanguageLevel;

	private Map<Integer, Integer> SkillLevel;

	public RegistrationStudentForm() {
	}

	public String getEnrollmentCode() {
		return enrollmentCode;
	}

	public void setEnrollmentCode(String enrollmentCode) {
		this.enrollmentCode = enrollmentCode;
	}

	public Map<Integer, Integer> getForeignLanguageLevel() {
		return foreignLanguageLevel;
	}

	public void setForeignLanguageLevel(Map<Integer, Integer> foreignLanguageLevel) {
		this.foreignLanguageLevel = foreignLanguageLevel;
	}

	public Map<Integer, Integer> getSkillLevel() {
		return SkillLevel;
	}

	public void setSkillLevel(Map<Integer, Integer> skillLevel) {
		SkillLevel = skillLevel;
	}

	@Override
	public String toString() {
		return "RegistrationStudentForm [enrollmentCode=" + enrollmentCode + ", getName()=" + getName()
				+ ", getBirthDate()=" + getBornDate() + ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress()
				+ ", getComplement()=" + getComplement() + ", getPassword()=" + getPassword() + ", getCityId()="
				+ getCityId() + ", getResume()=" + getResume() + "]";
	}
}
