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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	
	@Autowired
	private IOrderMethodService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private OrderMethodUtil util;
	
	// 1. Show Register Page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		
		// Create model class object and add to modelmap
		map.addAttribute("orderMethod", new OrderMethod());
		
		return "OrderMethodRegister";
	}
	
	// 2. Insert Data in DB
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String saveShipment(@ModelAttribute OrderMethod orderMethod, ModelMap map) {
		
		// call service layer save method
		int oid = service.saveOrder(orderMethod);
		String msg = "Saved with id"+oid;
		
		map.addAttribute("message", msg);
		
		// clean form backing object
		map.addAttribute("orderMethod", new OrderMethod());
		
		return "OrderMethodRegister";
	}
	
	// 3. Get All Records from DB
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		
		List<OrderMethod> obs = service.getAllOrders();
		map.addAttribute("list", obs);
		
		return "OrderMethodData";
	}
	
	// 4. Delete record for DB
	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam Integer oid, ModelMap map) {
		
		// delete record
		service.deleteOrder(oid);
		
		// read new data
		List<OrderMethod> obs = service.getAllOrders();
		map.addAttribute("list", obs);
		
		// Add message
		map.addAttribute("message", "Record Deleted With id "+oid);	
		
		return "OrderMethodData";
	}
	
	// 5. view one object
	@RequestMapping("/viewOne")
	public String getOne(@RequestParam Integer oid, ModelMap map) {
		
		// call service
		OrderMethod ob = service.getOrderById(oid);
		map.addAttribute("om", ob);
		
		return "OrderMethodView";
	}
	
	// 6. Show Edit page with data
	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer oid, ModelMap map) {
		
		// call service
		OrderMethod obm = service.getOrderById(oid);
		
		// send to ui
		map.addAttribute("orderMethod", obm);
		
		return "OrderMethodEdit";
	}
	
	// 7. DO update Data
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute OrderMethod orderMethod, ModelMap map) {
		
		// call service method update
		service.updateOrder(orderMethod);
		
		// success message
		map.addAttribute("message", "Order '"+ orderMethod.getOid() +"' Updated");
		
		// read new data
		List<OrderMethod> obs = service.getAllOrders();
		map.addAttribute("list", obs);
		
		return "OrderMethodData";
	}
	
	// 8. Export Data to Excel
	@RequestMapping("/excelExp")
	public ModelAndView doExcelExport() {
		
		// Get All Records from DB
		List<OrderMethod> list = service.getAllOrders();
		
		// adding list to model object in view, key, value format
		return new ModelAndView(new OrderMethodExcelView(), "list", list);
	}
	
	// 9. Export Single record to Excel 
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer oid) {
		
		// get Order By Id
		OrderMethod od = service.getOrderById(oid);
		
		// adding object to model in array format
		return new ModelAndView(new OrderMethodExcelView(), "list", Arrays.asList(od));
	}

	// 10. Export Data to pdf
	@RequestMapping("/pdfExp")
	public ModelAndView doPdfExport() {
		
		// get All Records form DB
		List<OrderMethod> list = service.getAllOrders();
		
		// adding list to model object in view, key, value format
		return new ModelAndView(new OrderMethodPdfView(), "list", list);
		
	}
	
	// 11. Export Single record to PDF 
	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer oid) {
		
		// get Order By Id
		OrderMethod od = service.getOrderById(oid);
		
		// adding object to model in array format
		return new ModelAndView(new OrderMethodPdfView(), "list", Arrays.asList(od));
	}
	
	// 12. Generate Charts
	@RequestMapping("/report")
	public String generateChart() {
		
		String path = context.getRealPath("/");
		//System.out.println(path);
		
		// call service
		List<Object[]> data = service.getOrderModeTypeCount();
		
		// call generatePie method  in util
		util.generatePie(path, data);
		util.generateBar(path, data);
		
		return "OrderMethodReport";
	}
	
}
