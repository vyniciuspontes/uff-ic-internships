package br.com.uff.internships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uff.internships.entity.City;
import br.com.uff.internships.entity.Company;
import br.com.uff.internships.entity.CoreActivity;
import br.com.uff.internships.form.RegistrationCompanyForm;
import br.com.uff.internships.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private CompanyRepository companyRepository;

	@Transactional
	public void saveNewCompany(RegistrationCompanyForm form) {

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

		companyRepository.create(newCompany);

	}

}
