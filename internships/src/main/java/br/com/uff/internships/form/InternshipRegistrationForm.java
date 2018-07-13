package br.com.uff.internships.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class InternshipRegistrationForm {

	private String title;

	private String description;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;

	private Double allowance;

	private List<Integer> selectedSkills = new ArrayList<>();

	public InternshipRegistrationForm() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Double getAllowance() {
		return allowance;
	}

	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}

	public List<Integer> getSelectedSkills() {
		return selectedSkills;
	}

	public void setSelectedSkills(List<Integer> selectedSkills) {
		this.selectedSkills = selectedSkills;
	}

}
