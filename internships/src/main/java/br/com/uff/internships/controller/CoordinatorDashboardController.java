package br.com.uff.internships.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/coordinator-dashboard")
public class CoordinatorDashboardController {
	
	@RequestMapping(value = {"/home" }, method = RequestMethod.GET)
	public String dashboardHome() {
		
		return "/dashboard/coordinator-dashboard-home";
	}
}
