package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Item;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.validator.ItemValidator;
import com.app.view.ItemExcelView;
import com.app.view.ItemPdfView;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private IItemService service;
	
	@Autowired
	private ItemValidator validator;
	
	@Autowired
	private IUomService uomservice;
	
	@Autowired
	private IOrderMethodService omservice;
	
	// 1. Show Register Page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {		
		map.addAttribute("item", new Item());
		// get uom data
		map.addAttribute("uoms", uomservice.getAllUom());
		// get Order Method data
		map.addAttribute("oms", omservice.getAllOrders());
		return "ItemRegister";
	}
	
	// 2. Insert Data
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String saveItem(@ModelAttribute Item item, Errors errors, ModelMap map) {
		// calling validator
		validator.validate(item, errors);
		// check for errors
		if(errors.hasErrors()) {
			//map.addAttribute("message", "Please check all errors");
			map.addAttribute("uoms", uomservice.getAllUom());
			// get Order Method data
			map.addAttribute("oms", omservice.getAllOrders());
		}else {			
			// call service
			Integer id = service.saveItem(item);
			map.addAttribute("message", "Item '"+id+"' Saved Successfully");			
			// Clean form after submit
			map.addAttribute("item", new Item());
			// get uom data
			map.addAttribute("uoms", uomservice.getAllUom());
			// get Order Method data
			map.addAttribute("oms", omservice.getAllOrders());
		}
		return "ItemRegister";
	}
	
	// 3. Show All Records
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		// call service
		List<Item> list = service.getAllItems();
		map.addAttribute("list", list);
		return "ItemData";
	}
	
	// 4. delete one Record
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam Integer itmid, ModelMap map) {
		// call service
		service.deleteItem(itmid);
		
		// read new data
		List<Item> list = service.getAllItems();
		map.addAttribute("list", list);
		
		map.addAttribute("message", "Item '"+itmid+"' Deleted Successfully");
		return "ItemData";
	}
	
	// 5. View One Record
	@RequestMapping("/viewOne")
	public String viewOneItem(@RequestParam Integer itmid, ModelMap map) {
		// call service
		Item item = service.getItemById(itmid);
		map.addAttribute("item", item);
		return "ItemView";
	}
	
	// 6. Show Edit Page
	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer itmid, ModelMap map) {
		// call service
		Item item = service.getItemById(itmid);		
		map.addAttribute("item", item);	
		// get uom data
		map.addAttribute("uoms", uomservice.getAllUom());
		// get Order Method data
		map.addAttribute("oms", omservice.getAllOrders());
		return "ItemEdit";
	}
	
	// 7. Update Item
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateItem(@ModelAttribute Item item, ModelMap map) {
		// call service
		service.updateItem(item);
		// read new data
		List<Item> list = service.getAllItems();
		map.addAttribute("list", list);
		
		map.addAttribute("message", "Item '"+item.getItemId()+"' Updated Successfully");
		return "ItemData";
	}
	
	// 8. Export Data to Excel
	@RequestMapping("/excelExp")
	public ModelAndView doExcelExport() {
		// call service
		List<Item> list = service.getAllItems();
		return new ModelAndView(new ItemExcelView(), "list", list);
	}
	
	// 9. Export Single record to Excel 
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer itmid) {
		// call service
		Item item = service.getItemById(itmid);
		return new ModelAndView(new ItemExcelView(), "list", Arrays.asList(item));
	}
	
	// 10. Export Data to PDF
	@RequestMapping("/pdfExp")
	public ModelAndView doPdfExport() {
		//call service
		List<Item> list = service.getAllItems();
		return new ModelAndView(new ItemPdfView(), "list", list);
	}
	
	// 11. Export Single record to PDF 
	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer itmid) {
		
		// get Order By Id
		Item item = service.getItemById(itmid);
		
		// adding object to model in array format
		return new ModelAndView(new ItemPdfView(), "list", Arrays.asList(item));
	}
	
}





