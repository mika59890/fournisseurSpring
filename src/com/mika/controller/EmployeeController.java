package com.mika.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mika.bean.EmployeeBean;
import com.mika.model.Employee;
import com.mika.service.EmployeeService;



@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("utilisateur") EmployeeBean employeeBean, 
			BindingResult result) {
		
		if (result.hasErrors()) {
            //Traitement de l'erreur
			return new ModelAndView("redirect:/add.html");
       }
		
		Employee employee = prepareModel(employeeBean);
		employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("utilisateur")  EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("utilisateur")  EmployeeBean employeeBean,
			BindingResult result) {
		employeeService.deleteEmployee(prepareModel(employeeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("employeesList", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("utilisateur")  EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employeeBean.getId())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	
	private Employee prepareModel(EmployeeBean employeeBean){
		Employee employee = new Employee();
		employee.setEmpNom(employeeBean.getNom());
		employee.setEmpEmail(employeeBean.getEmail());
		employee.setEmpPassword(employeeBean.getPassword());
		employee.setEmpId(employeeBean.getId());
		employeeBean.setId(null);
		return employee;
	}
	
	private List<EmployeeBean> prepareListofBean(List<Employee> employees){
		List<EmployeeBean> beans = null;
		if(employees != null && !employees.isEmpty()){
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for(Employee employee : employees){
				bean = new EmployeeBean();
				bean.setNom(employee.getEmpNom());
				bean.setId(employee.getEmpId());
				bean.setEmail(employee.getEmpEmail());
				bean.setPassword(employee.getEmpPassword());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private EmployeeBean prepareEmployeeBean(Employee employee){
		EmployeeBean bean = new EmployeeBean();
		bean.setPassword(employee.getEmpPassword());
		bean.setEmail(employee.getEmpEmail());
		bean.setNom(employee.getEmpNom());
		bean.setId(employee.getEmpId());
		return bean;
	}
}
