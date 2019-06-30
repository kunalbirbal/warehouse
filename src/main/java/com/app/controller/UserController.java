package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.view.UserExcelView;
import com.app.view.UserPdfView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	// 1. Show Register Page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		
		// Create model class object and add to modelmap
		map.addAttribute("user", new User());
		
		return "UserRegister";
	}
	
	// save User
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, ModelMap map) {
		
		// call service layer Save Method
		Integer usrid = service.saveUser(user);
		
		String msg = "Saved with id"+usrid;
		map.addAttribute("message", msg);
		
		// clean form backing object
		map.addAttribute("user", new User());
		
		return "UserRegister";
	}
	
	// 3. Get all records from Db
	@RequestMapping("/all")
	public String getUser(ModelMap map) {
		
		List<User> ulist = service.getAllUser();
		
		map.addAttribute("list", ulist);
		
		return "UserData";
	}

	// 4. Delete User
	@RequestMapping("/delete")
	public String deleteUser(@RequestParam Integer usrid, ModelMap map) {
		
		// call delete method
		service.deleteUser(usrid);
		
		// message
		map.addAttribute("message", "User Deleted");
		
		// get all user
		List<User> ulist = service.getAllUser();		
		map.addAttribute("list", ulist);
		
		return "UserData";
	}
	
	// 5. View One Record 
	@RequestMapping("/viewOne")
	public String getOne(@RequestParam Integer usrid, ModelMap map) {
		
		User ob = service.getUserById(usrid);
		map.addAttribute("user", ob);
		
		return "UserView";
	}
	
	// 6. Show Edit Page With Data
	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer usrid, ModelMap map) {
		
		// load DB row as object
		User usr = service.getUserById(usrid);
		
		// send to ui
		map.addAttribute("user", usr);
		
		return "UserEdit";
	}
	
	// 7. do Update Data
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute User user, ModelMap map) {
		
		// call service update
		service.updateUser(user);
		
		// success message
		map.addAttribute("message", "USER '"+ user.getUserId() +"' Updated");
		 
		// read new data
		List<User> lobj = service.getAllUser();
		map.addAttribute("list", lobj);
		
		return "UserData";
	}
	
	// 8. Export Data to Excel
	@RequestMapping("/excelExp")
	public ModelAndView doExcelExport() {
		
		// Get All Records from DB
		List<User> list = service.getAllUser();
		
		// adding list to model object in view, key, value format
		return new ModelAndView(new UserExcelView(), "list", list);
	}
	
	// 9. Export Single Data Record
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer usrid) {
		
		// get Single record from DB Using ID
		User us = service.getUserById(usrid);
		
		// adding object to model in array format	
		return new ModelAndView(new UserExcelView(), "list", Arrays.asList(us));
	}
	
	// 10. Export Data to PDF
	@RequestMapping("/pdfExp")
	public ModelAndView doPdfExport() {
		
		// Get All Records from DB
		List<User> list = service.getAllUser();
		
		// adding list to model object in view, key, value format
		return new ModelAndView(new UserPdfView(), "list", list);
	}
	
	// 11. Export Single Data Record
	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer usrid) {
		
		// get Single record from DB Using ID
		User us = service.getUserById(usrid);
		
		// adding object to model in array format	
		return new ModelAndView(new UserPdfView(), "list", Arrays.asList(us));
	}
	
	
}
