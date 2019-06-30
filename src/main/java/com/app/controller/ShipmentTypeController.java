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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.util.ShipmentTypeUtil;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	
	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ShipmentTypeUtil util;
	
	// 1. Show Register Page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		
		// Create model class object and add to modelmap
		map.addAttribute("shipmentType", new ShipmentType());
		
		return "ShipmentTypeRegister";
	}
	
	// 2. Insert Data in DB
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType, ModelMap map) {
		
		// call service layer save method
		int shipid = service.saveShipmentType(shipmentType);
		String msg = "Saved with id"+shipid;
		
		map.addAttribute("message", msg);
		
		// clean form backing object
		map.addAttribute("shipmentType", new ShipmentType());
		
		return "ShipmentTypeRegister";
	}
	
	// 3. Get all records from DB
	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		
		List<ShipmentType> lobj = service.getAllShipmentTypes();
		map.addAttribute("list", lobj);
		
		return "ShipmentTypeData";
	}
	
	
	// 4. Delete Record from DB
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam Integer sid, ModelMap map) {
		
		// call service delete
		service.deleteShipmentType(sid);
		
		// read new data
		List<ShipmentType> lobj = service.getAllShipmentTypes();
		map.addAttribute("list", lobj);
		
		// Add message
		map.addAttribute("message", "Record Deleted With id "+sid);		
		
		return "ShipmentTypeData";
		
	}
	
	// 5. View one row / object
	@RequestMapping("/viewOne")
	public String getOne(@RequestParam Integer sid, ModelMap map) {
		
		ShipmentType ob = service.getShipmentTypeById(sid);
		map.addAttribute("st", ob);
		
		return "ShipmentTypeView";
	}
	
	// 6. Show Edit page with Data
	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer sid, ModelMap map) {
		
		// load DB row as Object
		ShipmentType  st = service.getShipmentTypeById(sid);
		
		// send to ui
		map.addAttribute("shipmentType", st);
		
		return "ShipmentTypeEdit";
	}
	
	// 7. Do Update Data
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute ShipmentType shipmentType, ModelMap map) {
		
		// call service update method
		service.updateShipmentType(shipmentType);
		
		// success message
		map.addAttribute("message", "Shipment '"+ shipmentType.getId() +"' Updated");
		
		// get new data
		List<ShipmentType> lobj = service.getAllShipmentTypes();
		map.addAttribute("list", lobj);
		
		return "ShipmentTypeData";
	}
	
	// 8. Export Data to Excel
	@RequestMapping("/excelExp")
	public ModelAndView doExcelExport() {
		
		// reading data from DB
		List<ShipmentType> list = service.getAllShipmentTypes();
		
		// adding list to model object in view, key, value format
		return new ModelAndView(new ShipmentTypeExcelView(), "list", list);
	}
	
	// 9. Single Record Export Data to Excel
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExport(@RequestParam Integer sid) {
		
		// reading single row from DB
		ShipmentType st = service.getShipmentTypeById(sid);
		
		// adding object to model in array format		
		return new ModelAndView(new ShipmentTypeExcelView(), "list", Arrays.asList(st));
	}
	
	// 10. Export Data to PDF
	@RequestMapping("/pdfExp")
	public ModelAndView doPdfExport() { 
		
		// reading data from DB
		List<ShipmentType> list = service.getAllShipmentTypes();
		
		// adding list to model object in view, key, value format
		return new ModelAndView(new ShipmentTypePdfView(), "list", list);
		
	}
	
	// 11. Export Single record to pdf
	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer sid) {
		//reading data from DB
		ShipmentType st=service.getShipmentTypeById(sid);
		//view, key,val
		return new ModelAndView(
				new ShipmentTypePdfView(), 
				"list", Arrays.asList(st));
	}

	// 12. Charts
	@RequestMapping("/report")
	public String generateChart() {
		
		String path = context.getRealPath("/");
		
		// call service
		List<Object[]> data = service.getShipmentModeTypeCount();
		
		// call generate method of util
		util.generatePie(path, data);	
		util.generateBar(path, data);
		
		return "ShipmentTypeReport";
	}

}
