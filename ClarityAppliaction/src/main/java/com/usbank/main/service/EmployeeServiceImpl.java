package com.usbank.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usbank.main.dto.EmployeeDTO;
import com.usbank.main.entity.Employee;
import com.usbank.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<EmployeeDTO> fetchAllEMployees() {
		
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		List<Employee> employees = (List<Employee>) repository.findAll();
		for (Employee emp : employees) {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(emp, dto);
			list.add(dto);
		}

		return list;
	}
	
	@Override
	public String addEmployee(EmployeeDTO dto) {

		Employee emp = new Employee();
		BeanUtils.copyProperties(dto, emp);
		Employee saved = repository.save(emp);
		if (saved != null)
			return "Record Inserted Successfully";
		else
			return "Record Insertion Failed";
	}
	
	@Override
	public EmployeeDTO getEmployeeById(Long id) {
		
		Optional<Employee> optional = repository.findById(id);
		Employee employee = optional.get();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employee, employeeDTO);

		return employeeDTO;
	}
	
	@Override
	public String deleteEmployee(EmployeeDTO dto) {

		Employee employee = new Employee();

		BeanUtils.copyProperties(dto, employee);

		repository.delete(employee);

		return "Record Deleted Successfully";
	}

}
