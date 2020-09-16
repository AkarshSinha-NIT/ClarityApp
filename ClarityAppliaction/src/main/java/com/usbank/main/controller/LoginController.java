package com.usbank.main.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.usbank.main.command.EmployeeCommand;
import com.usbank.main.dto.EmployeeDTO;
import com.usbank.main.service.EmployeeService;
import com.usbank.main.validator.EmployeeValidator;

@Controller
@PropertySource("classpath:com/usbank/commons/credentials.properties")
public class LoginController {
	
	private static final String SUCCESS="success";
	private static final String STATUS="status";
	private static final String EMP_CMD="empCmd";
	private static final String LOGIN="login";
	private static final String LOGOUT="/logout";
	private static final String LOGIN_URL="/login";
	private static final String ADD_EMPLOYEE="/add_employee";
	private static final String UPDATE_EMPLOYEE="/update_employee";
	private static final String DELETE_EMPLOYEE="/delete_employee";
	private static final String SHOW_EMPLOYEE_SUCCESS="show_employees";
	private static final String ADD_EMPLOYEE_SUCCESS="add_employee";
	private static final String UPDATE_EMPLOYEE_SUCCESS="update_employee";
	
	
	@Value("${admin.userid}")
	private String adminId;
	@Value("${admin.password}")
	private String adminPassword;
	@Value("${root.password}")
	private String rootPassword;
	
	private HttpSession session;
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeValidator validator;
	
	/**
	 * This method traps the initial request and
	 * redirects to login page.
	 * 
	 * @return login page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage() {
		return LOGIN;
	}

	/**
	 * This method traps verifies the credentials and
	 * redirects to details page if user is admin or to 
	 * addClarity form for other user
	 * 
	 * @return details page or form page
	 */
	@RequestMapping(value = LOGIN_URL, method = RequestMethod.POST)
	public String showHomePage(HttpServletRequest request, Map<String, Object> map) {
		List<EmployeeDTO> listdto = null;
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		if (uname.equalsIgnoreCase(adminId) && pwd.equalsIgnoreCase(adminPassword)) {
			session = request.getSession(true);
			session.setAttribute(STATUS, SUCCESS);
			listdto = employeeService.fetchAllEMployees();
			map.put("listDTO", listdto);

			return SHOW_EMPLOYEE_SUCCESS;
		} else if (uname.equalsIgnoreCase(adminId) && pwd.equalsIgnoreCase(rootPassword)) {
			session = request.getSession(true);
			session.setAttribute(STATUS, SUCCESS);
			EmployeeCommand cmd = new EmployeeCommand();
			map.put(EMP_CMD, cmd);
			return ADD_EMPLOYEE_SUCCESS;
		} else {

			map.put("errorMessage", "Invalid Credentials");
			return LOGIN;

		}
	}
	
	/**
	 * This method traps add clarity details request
	 * redirects to clarity form
	 * 
	 * @return Clarity form page
	 */
	@RequestMapping(value = ADD_EMPLOYEE, method = RequestMethod.GET)
	public String showAddEmployeePage(HttpServletRequest request, Map<String, Object> map,
			@ModelAttribute(EMP_CMD) EmployeeCommand command, BindingResult errors) {
		
		String status = null;
		HttpSession ses = request.getSession(false);
		if (ses != null) {
			status = (String) ses.getAttribute(STATUS);
		}
		if (ses == null || status == null || !SUCCESS.equalsIgnoreCase(status)) {
			return LOGIN;
		}

		return ADD_EMPLOYEE_SUCCESS;
	}
	
	/**
	 * This method traps add clarity details request
	 * once user submits the clarity form and stores details
	 * into database
	 * 
	 * @return Clarity details page
	 */
	@RequestMapping(value = ADD_EMPLOYEE, method = RequestMethod.POST)
	public String AddEmployeePage(HttpServletRequest request, Map<String, Object> map,
			@ModelAttribute(EMP_CMD) EmployeeCommand command, BindingResult errors) {

		if (errors.hasErrors()) {
			return ADD_EMPLOYEE_SUCCESS;
		}

		if (validator.supports(EmployeeCommand.class)) {

			validator.validate(command, errors);

			if (errors.hasErrors()) {
				return ADD_EMPLOYEE_SUCCESS;
			}
		}

		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(command, dto);
		String resMsg = employeeService.addEmployee(dto);
		
		EmployeeCommand cmd=new EmployeeCommand();
		map.put(EMP_CMD,cmd);
		map.put("resMsg", resMsg);
		

		return ADD_EMPLOYEE_SUCCESS;

	}
	/**
	 * This method traps update clarity details request
	 * redirects to clarity form with existing details
	 * 
	 * @return Clarity form page
	 */
	@RequestMapping(value = UPDATE_EMPLOYEE, method = RequestMethod.GET)
	public String updateEmployeeStart(HttpServletRequest request, Map<String, Object> map, @RequestParam("id") Long id,
			@ModelAttribute(EMP_CMD) EmployeeCommand command, BindingResult errors) {
		
		String status = null;
		HttpSession ses = request.getSession(false);
		if (ses != null) {
			status = (String) ses.getAttribute(STATUS);
		}
		if (ses == null || status == null || !SUCCESS.equalsIgnoreCase(status)) {
			return LOGIN;
		}

		EmployeeDTO dto = null;

		dto = employeeService.getEmployeeById(id);

		BeanUtils.copyProperties(dto, command);

		map.put(EMP_CMD, command);

		return UPDATE_EMPLOYEE_SUCCESS;
	}
	
	/**
	 * This method traps update clarity details request
	 * once user submits the clarity form and stores details
	 * into database
	 * 
	 * @return Clarity details page
	 */
	@RequestMapping(value = UPDATE_EMPLOYEE, method = RequestMethod.POST)
	public String updateEmployeeSubmit(Map<String, Object> map, @ModelAttribute(EMP_CMD) EmployeeCommand command,
			BindingResult errors) {

		if (errors.hasErrors()) {
			return UPDATE_EMPLOYEE_SUCCESS;
		}

		if (validator.supports(EmployeeCommand.class)) {

			validator.validate(command, errors);

			if (errors.hasErrors()) {
				return UPDATE_EMPLOYEE_SUCCESS;
			}
		}

		EmployeeDTO dto = new EmployeeDTO();

		BeanUtils.copyProperties(command, dto);

		String resMsg = employeeService.addEmployee(dto);

		List<EmployeeDTO> listdto = null;
		listdto = employeeService.fetchAllEMployees();
		map.put("listDTO", listdto);
		map.put("resMsg", resMsg);

		return SHOW_EMPLOYEE_SUCCESS;

	}
	/**
	 * This method traps delete clarity details request
	 * once user clicks delete button on clarity details
	 * page and deletes records from the database
	 * 
	 * @return Clarity details page
	 */
	@RequestMapping(value = DELETE_EMPLOYEE, method = RequestMethod.GET)
	public String deleteEmployeeStart(HttpServletRequest request, Map<String, Object> map, @RequestParam("id") Long id,
			@ModelAttribute(EMP_CMD) EmployeeCommand command, BindingResult errors) {

		String status = null;
		HttpSession ses = request.getSession(false);
		if (ses != null) {
			status = (String) ses.getAttribute(STATUS);
		}
		if (ses == null || status == null || !SUCCESS.equalsIgnoreCase(status)) {
			return LOGIN;
		}

		EmployeeDTO employeeDTO = null;

		employeeDTO = employeeService.getEmployeeById(id);

		String resMsg = employeeService.deleteEmployee(employeeDTO);

		List<EmployeeDTO> listdto = null;
		listdto = employeeService.fetchAllEMployees();
		map.put("listDTO", listdto);
		map.put("resMsg", resMsg);

		return SHOW_EMPLOYEE_SUCCESS;
	}
	
	/**
	 * This method logout the user from current '
	 * session and returns to login page
	 * 
	 * @return Login page
	 */
	@RequestMapping(value = LOGOUT, method = RequestMethod.GET)
	public String logout() {
		if (session != null) {
			session.invalidate();
		}
		return LOGIN;
	}
}
