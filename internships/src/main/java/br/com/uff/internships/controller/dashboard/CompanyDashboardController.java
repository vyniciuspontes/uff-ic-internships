package br.com.uff.internships.controller.dashboard;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.uff.internships.entity.Skill;
import br.com.uff.internships.form.InternshipRegistrationForm;
import br.com.uff.internships.repository.SkillRepository;
import br.com.uff.internships.service.CompanyService;

@Controller
@RequestMapping(value="/dashboard/company")
public class CompanyDashboardController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private SkillRepository skillrepository;
	
	@RequestMapping(value = {"/create-internship"}, method = RequestMethod.GET)
	public String dashboardHome(Model model) {
		
		InternshipRegistrationForm form = new InternshipRegistrationForm();
		List<Skill> skills = skillrepository.getAll();
		
		model.addAttribute("internship", form);
		model.addAttribute("skills", skills);
		
		return "/dashboard/company-dashboard-create-internship";
	}
	
	@RequestMapping(value = {"/create-internship" }, method = RequestMethod.POST)
	public String registrateInternship(@Valid @ModelAttribute("internship") InternshipRegistrationForm internshipForm,
			BindingResult bindingResult, Authentication authentication) {
		
		if(bindingResult.hasErrors()) {
			
			return "/dashboard/company-dashboard-home";
		}
		
		companyService.saveNewInternship(internshipForm, authentication.getName());
		
		return "/dashboard/company-dashboard-home";
	}
}
