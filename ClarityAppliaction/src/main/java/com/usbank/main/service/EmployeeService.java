package com.usbank.main.service;

import java.util.List;

import com.usbank.main.dto.EmployeeDTO;

public interface EmployeeService {
	
	public List<EmployeeDTO> fetchAllEMployees();
	
	public String addEmployee(EmployeeDTO dto);
	
	public EmployeeDTO getEmployeeById(Long id);
	
	public String deleteEmployee(EmployeeDTO dto);
	

}
