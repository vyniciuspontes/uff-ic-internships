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
	 

	@RequestMapping(value = { "/search-internships" }, method = RequestMethod.GET)
	public String dashboardHome(Model model, Authentication authentication, HttpServletRequest httpServletRequest) {
		
		List<Internship> internships = this.studentService.findAllAppliableInternships(authentication.getName());
		
		model.addAttribute("internships", internships);
		
		log.info(String.format("URI -> %s", httpServletRequest.getRequestURI()));
		
		return "/dashboard/student-dashboard-search-internships";
	}

	@RequestMapping(value = { "/apply-internship" }, method = RequestMethod.POST)
	public String applyForInternship(@RequestParam("internshipId") Integer internshipId,
			Authentication authentication) {

		studentService.applyForInternship(internshipId, authentication.getName());

		return "redirect:/dashboard/student/search-internships";
	}
}
