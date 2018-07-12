package br.com.uff.internships.form;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class RegistrationStudentForm extends RegistrationUserForm {

	@NotNull
	private String enrollmentCode;

	private Map<Integer, Integer> foreignLanguageLevel;
	private Map<Integer, Integer> SkillLevel;
	private String experienceTitle;
	private String experienceDescription;
	
	@DateTimeFormat (pattern="yyyy-MM-dd") 
	private Date experienceStartDate;
	@DateTimeFormat (pattern="yyyy-MM-dd") 
	private Date experienceEndDate;

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

	public String getExperienceTitle() {
		return experienceTitle;
	}

	public void setExperienceTitle(String experienceTitle) {
		this.experienceTitle = experienceTitle;
	}

	public String getExperienceDescription() {
		return experienceDescription;
	}

	public void setExperienceDescription(String experienceDescription) {
		this.experienceDescription = experienceDescription;
	}

	public Date getExperienceStartDate() {
		return experienceStartDate;
	}

	public void setExperienceStartDate(Date experienceStartDate) {
		this.experienceStartDate = experienceStartDate;
	}

	public Date getExperienceEndDate() {
		return experienceEndDate;
	}

	public void setExperienceEndDate(Date experienceEndDate) {
		this.experienceEndDate = experienceEndDate;
	}

	@Override
	public String toString() {
		return "RegistrationStudentForm [enrollmentCode=" + enrollmentCode + ", getName()=" + getName()
				+ ", getBirthDate()=" + getBornDate() + ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress()
				+ ", getComplement()=" + getComplement() + ", getPassword()=" + getPassword() + ", getCityId()="
				+ getCityId() + ", getResume()=" + getResume() + "]";
	}
}
