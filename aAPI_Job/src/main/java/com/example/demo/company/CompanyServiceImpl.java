package com.example.demo.company;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	private CompanyRepository companyRepository;
	
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
	public boolean updateCompany(Company company, Long id) {
		Optional<Company>companyOptional = companyRepository.findById(id);
		
		if (companyOptional.isPresent()) {
			Company companyToUpdate = companyOptional.get(); 
			companyToUpdate.setDescription(company.getDescription());
			companyToUpdate.setJobs(company.getJobs());
			companyToUpdate.setName(company.getName());
			//Don't forget to save the updated!!
			companyRepository.save(companyToUpdate);
			return true;
		} else {
	
			return false;
		}
	}
	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);
	}
	public boolean deleteCompanyById(Long id) {
		if(companyRepository.existsById(id)){
				companyRepository.deleteById(id);
				return true;
		}
		else {
		return false;
		}
	}
	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}
}
