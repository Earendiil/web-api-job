package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.company.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

	public Company getCompanyById(Long companyId);

}
