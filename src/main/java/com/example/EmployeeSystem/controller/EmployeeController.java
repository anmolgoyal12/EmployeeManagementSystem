package com.example.EmployeeSystem.controller;

import java.util.List;

//import java.util.Collection;
//import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.EmployeeSystem.entity.Employee;
import com.example.EmployeeSystem.repository.EmpRepo;
import com.example.EmployeeSystem.service.EmpService;

@Controller
@ComponentScan("com.example.EmployeeSystem.service")
//@ComponentScan("com.example.EmployeeSystem.repository")
public class EmployeeController {

	//private String Email="";
	@Autowired 
	private EmpService service;
	
	@GetMapping("/")
	public String mainq() {
		return "login";
	}
	
	
	@PostMapping("/login")
	public String login1(ModelMap model, @RequestParam String email, @RequestParam String password) {
	if (email.equals("admin@gmail.com") && password.equals("Admin123")) {
		return "index";
	}
	else {
		
		return "login";
		
	}
	}
	
//	@GetMapping("/ind")
//	public String ind() {
//		return "index";
//	}
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		return "AddEmp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg", "Emplyoee Added Sucessfully..");
		//System.out.println(e);
		return "successfulmsg";
	}
	
	@GetMapping("/homepage")
	public String home(Model m) {
		m.addAttribute("emp", service.getAllEmp());
		return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = service.getEMpById(id);
		m.addAttribute("emp", e);
		return "editemp";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg1", "Emp Data Update Sucessfully..");
		return "updatesuccess";
	}
	
	@GetMapping("/homepage1")
	public String home1(Model m) {
		m.addAttribute("emp", service.getAllEmp());
		return "index";
	}

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {
        
		service.deleteEMp(id);
		session.setAttribute("msg2", "Emp Data Delete Sucessfully..");
		return "index";
	}
	
	
	
	
	
//	@GetMapping("/homepage2")
//	public String home2(Model m) {
//		m.addAttribute("emp", service.getAllEmp());
//		return "index";
//	}
	
//	@GetMapping("/page/{pageno}")
//	public String findPaginated(@PathVariable int pageno, Model m) {
//
//		Page<Employee> emplist = service.getEMpByPaginate(pageno, 2);
//		m.addAttribute("emp", emplist);
//		m.addAttribute("currentPage", pageno);
//		m.addAttribute("totalPages", emplist.getTotalPages());
//		m.addAttribute("totalItem", emplist.getTotalElements());
//		return "index";
//	}
}
