package br.com.uff.internships.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/company-dashboard")
public class CompanyDashboardController {
	
	@RequestMapping(value = {"/home" }, method = RequestMethod.GET)
	public String dashboardHome() {
		
		return "/dashboard/company-dashboard-home";
	}
}
