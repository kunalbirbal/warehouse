package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.WhUserTypeUtil;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	
	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WhUserTypeUtil util;
	
	// 1. Show Register Page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		
		// create model class and add to model map
		map.addAttribute("whUserType", new WhUserType());
		
		return "WhUserTypeRegister";
	}
	
	// 2. Insert Record in DB
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertData(@ModelAttribute WhUserType whUserType, ModelMap map) {
		
		// call service save method
		int whid = service.saveWhUserType(whUserType);
		
		map.addAttribute("message", "WhUser Saved With ID: "+whid);
		
		// clean form backing object
		map.addAttribute("whUserType", new WhUserType());
		
		return "WhUserTypeRegister";
	}
	
	// 3. Get All Records from DB
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		
		// call service
		List<WhUserType> whlist = service.getAllWhUser();
		
		map.addAttribute("list", whlist);
		
		return "WhUserTypeData";
	}
	
	// 4. Delete Single record from DB
	@RequestMapping("/delete")
	public String deleteData(@RequestParam Integer wid, ModelMap map) {
		
		// call service delete method
		service.deleteWhUserType(wid);
		
		// Read new Data
		List<WhUserType> whlist = service.getAllWhUser();
		map.addAttribute("list", whlist);
		
		map.addAttribute("message", "Record '"+ wid +"' Deleted");
		
		return "WhUserTypeData";
	}
	
	// 5. View One Record
	@RequestMapping("/viewOne")
	public String getOne(@RequestParam Integer wid, ModelMap map) {
		
		// call service get one record by id
		WhUserType whb = service.getWhUserById(wid);
		
		map.addAttribute("wu", whb);
		
		return "WhUserTypeView";
	}
	
	// 6. show edit page with data
	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer wid, ModelMap map) {
		
		// load DB row as object
		WhUserType whb = service.getWhUserById(wid);
		// send to UI
		map.addAttribute("whUserType", whb);
		
		return "WhUserTypeEdit";
	}
	
	// 7. Update Record in DB
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateData(@ModelAttribute WhUserType whUserType, ModelMap map) {
		
		// update record in db call service
		service.updateWhUserType(whUserType);
		
		// success message
		map.addAttribute("message", "Record '"+ whUserType.getUserId() +"' Updated Successfully");
		
		// read new data
		List<WhUserType> whlist = service.getAllWhUser();
		map.addAttribute("list", whlist);
		
		return "WhUserTypeData";
	}
	
	// 8. Export Data to Excel
	@RequestMapping("/excelExp")
	public ModelAndView doExcelExport() {
		
		// Get All Records from DB
		List<WhUserType> list = service.getAllWhUser();
		
		// adding list to model object in view, key, value format
		return new ModelAndView(new WhUserTypeExcelView(), "list", list);
	}
	
	// 9. Export Single Data Record
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer wid) {
		
		// get Single record from DB Using ID
		WhUserType wh = service.getWhUserById(wid);
		
		// adding object to model in array format	
		return new ModelAndView(new WhUserTypeExcelView(), "list", Arrays.asList(wh));
	}
	
	// 10. Export Data to PDF
	@RequestMapping("/pdfExp")
	public ModelAndView doPdfExport() {
		
		// Get All Records from DB
		List<WhUserType> list = service.getAllWhUser();
		
		// adding list to model object in view, key, value format
		return new ModelAndView(new WhUserTypePdfView(), "list", list);
	}
	
	// 11. Export Single Data Record
	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer wid) {
		
		// get Single reocrd from DB Using ID
		WhUserType wh = service.getWhUserById(wid);
		
		// adding object to model in array format	
		return new ModelAndView(new WhUserTypePdfView(), "list", Arrays.asList(wh));
	}
	
	// 12. Chart Reports
	@RequestMapping("/report")
	public String generateChart() {
		
		String path = context.getRealPath("/");
		
		// call service to get data
		List<Object[]> data = service.getWhUserTypeCount();
		
		// call generate chart method from util class
		util.generatePie(path, data);
		util.generateBar(path, data);
		
		return "WhUserTypeReport";
	}
	
}
