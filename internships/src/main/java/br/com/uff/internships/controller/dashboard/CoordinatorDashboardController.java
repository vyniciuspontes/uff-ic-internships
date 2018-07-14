package br.com.uff.internships.controller.dashboard;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.uff.internships.entity.User;
import br.com.uff.internships.service.CoordinatorService;

@Controller
@RequestMapping(value="/dashboard/coordinator")
public class CoordinatorDashboardController {
	
	@Autowired
	private CoordinatorService service;
	
	@RequestMapping(value = {"/validate-users" }, method = RequestMethod.GET)
	public String dashboardHome(Model model) {
		
		List<User> nonValidatedUsers = service.findAllNonValidatedUsers();
		
		model.addAttribute("nonValidatedUsers", nonValidatedUsers);
		
		return "/dashboard/coordinator-dashboard-validate-users";
	}
	
	@RequestMapping(value = {"/validate-users" }, method = RequestMethod.POST)
	public String validateUser(@RequestParam(name="selectedUserId") Integer selectedUserId) {
		
		this.service.validateUser(selectedUserId);
		
		return "redirect:/dashboard/coordinator/validate-users";
	}
}
