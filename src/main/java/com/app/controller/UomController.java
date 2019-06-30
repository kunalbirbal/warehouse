package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	
	@Autowired
	private IUomService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private UomUtil util;
	
	@Autowired
	private UomValidator validator;
	
	// 1. Show Register Page
	@RequestMapping("/register")
	public String showUom(ModelMap map) {
		
		// Create model class object and add to modelmap
		map.addAttribute("uom", new Uom());
		
		return "UomRegister";
	}
	
	// 2. Insert Uom Data
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertUom(@ModelAttribute Uom uom, Errors errors, ModelMap map) {
		
		// calling Validator
		validator.validate(uom, errors);
		
		if(!errors.hasErrors()) {
			// call sevice save method
			int uomid = service.saveUom(uom);
			String msg = "Data saved with id "+uomid;
			
			map.addAttribute("message", msg);
			
			// clean form backing object
			map.addAttribute("uom", new Uom());
		}
		
		return "UomRegister";
	}
	
	// 3. Get all records from Db
	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		
		// call Service get all method
		List<Uom> lobj = service.getAllUom();
		map.addAttribute("list", lobj);
		
		return "UomData";
	}
	
	// 4. Delete Record from DB
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam Integer uid, ModelMap map) {
		
		// call service for delete
		service.deleteUom(uid);
		
		// read new data
		List<Uom> lobj = service.getAllUom();
		map.addAttribute("list", lobj);
		
		// Add message
		map.addAttribute("message", "Record Deleted With id "+uid);	
		
		return "UomData"; 
	}
	
	// 5. View One Record 
	@RequestMapping("/viewOne")
	public String getOne(@RequestParam Integer uid, ModelMap map) {
		
		Uom ob = service.getUomById(uid);
		map.addAttribute("uom", ob);
		
		return "UomView";
	}
	
	// 6. Show Edit Page With Data
	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer uid, ModelMap map) {
		
		// load DB row as object
		Uom um = service.getUomById(uid);
		
		// send to ui
		map.addAttribute("uom", um);
		
		return "UomEdit";
	}
	
	// 7. do Update Data
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute Uom uom, Errors errors, ModelMap map) {
		
		// validator
		validator.validate(uom, errors);
		
		if(!errors.hasErrors()) {
			// call service update
			service.updateUom(uom);		
			// success message
			map.addAttribute("message", "UOM '"+ uom.getUomId() +"' Updated");
			// read new data
			List<Uom> lobj = service.getAllUom();
			map.addAttribute("list", lobj);
			return "UomData";
		}else {
			return "UomEdit";
		}		
		
	}
	
	// 8. Export Data to excel
	@RequestMapping("/excelExp")
	public ModelAndView doExcelExport() {
		
		// get all UOM Data from DB
		List<Uom> list = service.getAllUom();
		
		// adding list to model object in view, key, value format
		return new ModelAndView(new UomExcelView(), "list", list);
	}
	
	// 9. Export Single Record Data using ID 
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer uid) {
		
		// get single record from DB
		Uom um = service.getUomById(uid);
		
		return new ModelAndView(new UomExcelView(), "list", Arrays.asList(um));
	}
	
	// 10. Export Data to PDF
	@RequestMapping("/pdfExp")
	public ModelAndView doPdfExport() { 
		
		// reading data from DB
		List<Uom> list = service.getAllUom();
		
		// adding list to model object in view, key, value format
		return new ModelAndView(new UomPdfView(), "list", list);
		
	}
	
	// 11. Export Single record to pdf
	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer uid) {
		//reading data from DB
		Uom st=service.getUomById(uid);
		//view, key,val
		return new ModelAndView(
				new UomPdfView(), 
				"list", Arrays.asList(st));
	}
	
	// 12. Charts
	@RequestMapping("/report")
	public String generateCharts() {
		
		String path = context.getRealPath("/");
		
		// call service
		List<Object[]> data = service.getUomTypeCount();
		
		// call generatePie method from util
		util.generatePie(path, data);
		util.generateBar(path, data);
		
		return "UomReport";
	}

}
