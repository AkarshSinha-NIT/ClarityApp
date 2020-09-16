package com.usbank.main.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.usbank.main.command.EmployeeCommand;

@Component
@PropertySource("classpath:com/usbank/commons/errors.properties")
public class EmployeeValidator implements Validator {

	@Value("${employee.id.required}")
	private String empidRequired;

	@Value("${employee.name.required}")
	private String empNameRequired;

	@Value("${employee.clarity.hour}")
	private String clarityHoursRequired;

	@Value("${employee.leave.count}")
	private String leaveCountRequired;

	@Value("${employee.holiday.count}")
	private String holidayCountRequired;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(EmployeeCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		EmployeeCommand cmd = null;
		String vflag = null;

		// get command class object
		cmd = (EmployeeCommand) target;

		if (cmd.getEmpid() == null) {
			errors.rejectValue("empid", "", empidRequired);
		} 

		if (cmd.getEmpName().equals("") || cmd.getEmpName() == null || cmd.getEmpName().length() == 0) {
			errors.rejectValue("empName", "", empNameRequired);
		}

		if (cmd.getClarityHours() == null) {
			errors.rejectValue("clarityHours", "", clarityHoursRequired);
		} 

		if (cmd.getLeaveCount() == null) {
			errors.rejectValue("leaveCount", "", leaveCountRequired);
		} 

		if (cmd.getHolidayCount() == null) {
			errors.rejectValue("holidayCount", "", holidayCountRequired);
		} 
	}

}
