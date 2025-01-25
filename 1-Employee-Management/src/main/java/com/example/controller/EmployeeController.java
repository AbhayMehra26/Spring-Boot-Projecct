package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@Controller
@RequestMapping("Employee-Management") 
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
/*------------------------------------------*/	
	      //handler 
/*------------------------------------------*/
	@GetMapping("")
	public String getHomeView()
	{
		return "home";
	}
	
	@GetMapping("add-employee")
	public String getAdd()
	{
		return "add";
	}
	
	
	
	@PostMapping("save-record")
	public String saveEmployeeRecord(Employee employee)
	{
		employeeService.saveRecord(employee);
		return "save-success";
	}
	
	@GetMapping("employee-list")
	public String saveEmployeelist(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "list";
	}
	
	@GetMapping("search-employee")
	public String getSearchEmployeeView()
	{
		return "search";
	}

	@GetMapping("search-record")
	public String searchEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("eid",eid);
			model.addAttribute("msg","Employee record not found");
			return "search";
		}
		model.addAttribute("emp",employee);
		return "show";
	}	
	
		@GetMapping("delete-employee")
		public String getDeleteEmployeeView()
		{
			return "delete";
		}
	
		@GetMapping("confirm-delete")
		public String getConfirmDeleteView(int eid,Model model)
		{
			Employee employee=employeeService.getRecord(eid);
			if(employee==null)
			{
				model.addAttribute("eid",eid);
				model.addAttribute("msg","Employee record does not exist");
				return "delete";
			}
			model.addAttribute("emp",employee);
			return "confirm-delete";
		}
		
		@GetMapping("delete-record")
		public String deleteEmployeeRecord(int eid)
		{
			employeeService.deleteRecord(eid);
			return "delete-success";
		}
		
		@GetMapping("edit-employee")
		public String getEditEmployeeView()
		{
			return "edit";
		}
		
		
		@GetMapping("show-record")
		public String getUpdateEmployeeView(int eid,Model model)
		{
			Employee employee=employeeService.getRecord(eid);
			if(employee==null)
			{
				model.addAttribute("eid",eid);
				model.addAttribute("msg","Employee record does not exist");
				return "edit";
			}
			model.addAttribute("emp",employee);
			return "update-show";
		}
		
		
		@PostMapping("update-record")
		public String updateEmployeeRecord(Employee nemp)
		{
			employeeService.updateRecord(nemp);
			return "update-success";
		}
	

}



