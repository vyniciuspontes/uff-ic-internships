package br.com.uff.internships.controller.dashboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.uff.internships.entity.Internship;
import br.com.uff.internships.service.StudentService;

@Controller
@RequestMapping(value = "/dashboard/student")
public class StudentDashboardController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentService studentService;
	 

	@RequestMapping(value = { "/internship/search" }, method = RequestMethod.GET)
	public String searchInternships(Model model, Authentication authentication) {
		
		List<Internship> internships = this.studentService.findAllAppliableInternships(authentication.getName());
		
		model.addAttribute("internships", internships);
		
		return "/dashboard/student-dashboard-search-internships";
	}
	
	@RequestMapping(value = { "/internship" }, method = RequestMethod.GET)
	public String showCurrentProcesses(Model model, Authentication authentication) {
		
		List<Internship> internships = this.studentService.findAllStudentInternships(authentication.getName());
		
		model.addAttribute("internships", internships);
		return "/dashboard/student-dashboard-current-processes";
	}

	@RequestMapping(value = { "/internship/apply" }, method = RequestMethod.POST)
	public String applyForInternship(@RequestParam("internshipId") Integer internshipId,
			Authentication authentication) {

		studentService.applyForInternship(internshipId, authentication.getName());

		return "redirect:/dashboard/student/internship/search";
	}
}
