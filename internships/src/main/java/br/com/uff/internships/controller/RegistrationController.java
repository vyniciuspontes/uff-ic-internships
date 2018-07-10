package br.com.uff.internships.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.uff.internships.entity.City;
import br.com.uff.internships.form.RegistrationStudentForm;
import br.com.uff.internships.repository.CityRepository;

@Controller
public class RegistrationController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CityRepository cityRepository;
	
	@RequestMapping(value = { "/registration-student" }, method = RequestMethod.GET)
	public ModelAndView studentRegistration() {
		ModelAndView modelAndView = new ModelAndView();
		RegistrationStudentForm studentForm = new RegistrationStudentForm();
		List<City> cities = cityRepository.getAll();
		modelAndView.addObject("cities", cities);
		modelAndView.addObject("student", studentForm);
		modelAndView.setViewName("registration-student");
		return modelAndView;
	}

	@RequestMapping(value = { "/registration-company" }, method = RequestMethod.GET)
	public ModelAndView companyRegistration() {
		ModelAndView modelAndView = new ModelAndView();
		RegistrationStudentForm companyForm = new RegistrationStudentForm();
		modelAndView.addObject("company", companyForm);
		modelAndView.setViewName("registration-company");
		return modelAndView;
	}

	@RequestMapping(value = { "/registration-select" }, method = RequestMethod.GET)
	public ModelAndView registrationSelect() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration-select");
		return modelAndView;
	}

	@RequestMapping(value = { "/registration-student" }, method = RequestMethod.POST)
	public ModelAndView registrateStudent(@Valid @ModelAttribute("student") RegistrationStudentForm studentForm,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/registration-student");

			for (ObjectError e : bindingResult.getAllErrors()) {

				log.info(e.toString());

			}
			


			log.info("" + studentForm.toString());
			return modelAndView;
		}

		modelAndView.addObject("student", studentForm);
		modelAndView.setViewName("registration-student");
		return modelAndView;
	}

}
