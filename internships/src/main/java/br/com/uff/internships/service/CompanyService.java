package br.com.uff.internships.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uff.internships.entity.City;
import br.com.uff.internships.entity.Company;
import br.com.uff.internships.entity.CoreActivity;
import br.com.uff.internships.entity.Internship;
import br.com.uff.internships.entity.Skill;
import br.com.uff.internships.form.CompanyRegistrationForm;
import br.com.uff.internships.form.InternshipRegistrationForm;
import br.com.uff.internships.repository.CompanyRepository;
import br.com.uff.internships.repository.InternshipRepository;
import br.com.uff.internships.repository.UserRepository;

@Service
public class CompanyService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private InternshipRepository internshipRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void saveNewCompany(CompanyRegistrationForm form) {

		Company newCompany = new Company();

		String encryptedPassword = bCryptPasswordEncoder.encode(form.getPassword());

		newCompany.setName(form.getName());
		newCompany.setBornDate(form.getBornDate());
		newCompany.setComplement(form.getComplement());
		newCompany.setEmail(form.getEmail());
		newCompany.setCnpj(form.getCnpj());
		newCompany.setCity(new City(form.getCityId()));
		newCompany.setAddress(form.getAddress());
		newCompany.setPassword(encryptedPassword);
		newCompany.setCoreActivity(new CoreActivity(form.getCoreActivityId()));
		newCompany.setResume(form.getResume());
		newCompany.setValidated(false);

		companyRepository.create(newCompany);

	}

	@Transactional
	public void saveNewInternship(InternshipRegistrationForm form, String companyEmail) {

		Internship newInternship = new Internship();

		Company company = (Company) userRepository.findByEmail(companyEmail);

		newInternship.setAllowance(new BigDecimal(form.getAllowance()));
		newInternship.setCompany(company);
		newInternship.setDescription(form.getDescription());
		newInternship.setTitle(form.getTitle());
		newInternship.setDeadline(form.getDeadline());

		for (Integer id : form.getSelectedSkills()) {
			newInternship.addSkill(new Skill(id));
		}

		internshipRepository.create(newInternship);
	}
	
	public List<Internship> findCompanyInternships(String companyEmail) {
		
		Company company = (Company) this.userRepository.findByEmail(companyEmail);
		
		return this.internshipRepository.findByCompany(company.getId());
	}
	

}
