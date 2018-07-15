package br.com.uff.internships.controller.dashboard;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.uff.internships.entity.Internship;
import br.com.uff.internships.entity.InternshipStudentStatus;
import br.com.uff.internships.entity.Skill;
import br.com.uff.internships.entity.StudentSkill;
import br.com.uff.internships.form.InternshipRegistrationForm;
import br.com.uff.internships.repository.SkillRepository;
import br.com.uff.internships.repository.StudentSkillRepository;
import br.com.uff.internships.service.CompanyService;
import br.com.uff.internships.service.StudentService;

@Controller
@RequestMapping(value = "/dashboard/company")
public class CompanyDashboardController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private SkillRepository skillrepository;
	
	@Autowired
	private StudentSkillRepository studentSkillRepository;

	@RequestMapping(value = { "/internship/new" }, method = RequestMethod.GET)
	public String dashboardHome(Model model) {

		InternshipRegistrationForm form = new InternshipRegistrationForm();
		List<Skill> skills = skillrepository.getAll();

		model.addAttribute("internship", form);
		model.addAttribute("skills", skills);

		return "/dashboard/company-dashboard-create-internship";
	}

	@RequestMapping(value = { "/internship/new" }, method = RequestMethod.POST)
	public String registrateInternship(@Valid @ModelAttribute("internship") InternshipRegistrationForm internshipForm,
			BindingResult bindingResult, Authentication authentication) {

		if (bindingResult.hasErrors()) {

			return "/dashboard/company-dashboard-create-internship";
		}

		companyService.saveNewInternship(internshipForm, authentication.getName());

		return "redirect:/dashboard/company/internship";
	}

	@RequestMapping(value = { "/internship" }, method = RequestMethod.GET)
	public String showCurrentProcesses(Model model, Authentication authentication) {

		List<Internship> internships = this.companyService.findCompanyInternships(authentication.getName());

		model.addAttribute("internships", internships);

		return "/dashboard/company-dashboard-current-processes";
	}

	@RequestMapping(value = { "/internship/{internshipId}/candidate" }, method = RequestMethod.GET)
	public String showProcessCandidates(@PathVariable("internshipId") Integer internshipId, Model model,
			Authentication authentication) {

		List<InternshipStudentStatus> studentsStatuses = this.studentService.findLastStatusByInternship(internshipId);
		
		model.addAttribute("studentsStatuses", studentsStatuses);
		
		return "/dashboard/company-dashboard-current-processes-candidates";
	}
	
	@RequestMapping(value = { "/internship/candidate/update-status" }, method = RequestMethod.POST)
	public String updateCantidateStatus(@RequestParam("internshipId") Integer internshipId,
			@RequestParam("studentId") Integer studentId, @RequestParam("currentStatus") String currentStatus, 
			@RequestParam("commentary") String commentary,@RequestParam(value = "approved", required = false) Boolean approved) {
		
		InternshipStudentStatus.Status newStatus = null;
		
		if(approved == null) {
			newStatus = InternshipStudentStatus.Status.COMPANY_REFUSED;
		}else if (currentStatus.equals(InternshipStudentStatus.Status.PROFILE_ANALYSIS.name())) {
			newStatus = InternshipStudentStatus.Status.INTERVIEW_ANALYSIS;
		}else if (currentStatus.equals(InternshipStudentStatus.Status.INTERVIEW_ANALYSIS.name())) {
			newStatus = InternshipStudentStatus.Status.COMPANY_APPROVED;
		}	
		
		this.studentService.saveNewStudentInternshipStatus(internshipId, studentId, newStatus, commentary);

		return String.format("redirect:/dashboard/company/internship/%s/candidate", internshipId);
	}
}
