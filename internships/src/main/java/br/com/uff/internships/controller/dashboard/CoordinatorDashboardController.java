package br.com.uff.internships.controller.dashboard;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.uff.internships.entity.InternshipStudentStatus;
import br.com.uff.internships.entity.Student;
import br.com.uff.internships.entity.User;
import br.com.uff.internships.service.CoordinatorService;
import br.com.uff.internships.service.StudentService;

@Controller
@RequestMapping(value="/dashboard/coordinator")
public class CoordinatorDashboardController {
	
	@Autowired
	private CoordinatorService coordinatorService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = {"/user/validate" }, method = RequestMethod.GET)
	public String dashboardHome(Model model) {
		
		List<User> nonValidatedUsers = coordinatorService.findAllNonValidatedUsers();
		
		model.addAttribute("nonValidatedUsers", nonValidatedUsers);
		
		return "/dashboard/coordinator-dashboard-validate-users";
	}
	
	@RequestMapping(value = {"/user/validate" }, method = RequestMethod.POST)
	public String validateUser(@RequestParam(name="selectedUserId") Integer selectedUserId) {
		
		this.coordinatorService.validateUser(selectedUserId);
		
		return "redirect:/dashboard/coordinator/user/validate";
	}
	
	@RequestMapping(value = {"/internship/validate-hiring" }, method = RequestMethod.GET)
	public String showvalidateInternshipHiring(Model model) {
		
		List<InternshipStudentStatus> studentsStatuses = this.studentService.findToBeHiredStudents();

		model.addAttribute("studentsStatuses", studentsStatuses);
		
		return "/dashboard/coordinator-dashboard-validate-hiring";
	}
	
	@RequestMapping(value = {"/internship/validate-hiring" }, method = RequestMethod.POST)
	public String validateInternshipHiring(@RequestParam("internshipId") Integer internshipId,
			@RequestParam("studentId") Integer studentId, @RequestParam("currentStatus") String currentStatus, 
			@RequestParam("commentary") String commentary,@RequestParam(value = "approved", required = false) Boolean approved) {
		
		InternshipStudentStatus.Status newStatus = null;
		
		if(approved == null) {
			newStatus = InternshipStudentStatus.Status.COORDINATOR_REFUSED;
		}else {
			newStatus = InternshipStudentStatus.Status.COORDINATOR_APPROVED;
		}
		
		this.studentService.saveNewStudentInternshipStatus(internshipId, studentId, newStatus, commentary);

		return "redirect:/dashboard/coordinator/internship/validate-hiring";
	}
}
