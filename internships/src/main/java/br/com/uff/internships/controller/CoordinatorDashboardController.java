package br.com.uff.internships.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.uff.internships.entity.User;
import br.com.uff.internships.service.CoordinatorDashboardService;

@Controller
@RequestMapping(value="/coordinator-dashboard")
public class CoordinatorDashboardController {
	
	@Autowired
	private CoordinatorDashboardService service;
	
	@RequestMapping(value = {"/home" }, method = RequestMethod.GET)
	public String dashboardHome(Model model) {
		
		List<User> nonValidatedUsers = service.findAllNonValidatedUsers();
		
		model.addAttribute("nonValidatedUsers", nonValidatedUsers);
		
		return "/dashboard/coordinator-dashboard-home";
	}
	
	@RequestMapping(value = {"/home" }, method = RequestMethod.POST)
	public String validateUser(@RequestParam(name="selectedUserId") Integer selectedUserId) {
		
		this.service.validateUser(selectedUserId);
		
		return "redirect:/coordinator-dashboard/home";
	}
}
