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

import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.validator.PurchaseOrderValidator;
import com.app.view.PurchaseOrderExcelView;
import com.app.view.PurchaseOrderPdfView;

@Controller
@RequestMapping("/purchase_order")
public class PurchaseOrderController {
	
	@Autowired
	private IPurchaseOrderService service;
	
	@Autowired
	private PurchaseOrderValidator validator;
	
	@Autowired
	private IWhUserTypeService whservice;
	
	@Autowired
	private IShipmentTypeService shipservice;
	
	// 1. Show Register page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		//get WhUser Data
		map.addAttribute("whusers", whservice.getAllWhUser());
		//get Shipment Data
		map.addAttribute("shiptype", shipservice.getAllShipmentTypes());
		return "PurchaseOrderRegister";
	}
	
	// 2. save Prchase Order
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder, Errors errors, ModelMap map) {
		// calling error
		validator.validate(purchaseOrder, errors);
		
		// check for errors
		if(errors.hasErrors()) {
			//map.addAttribute("message", "Please check all errors");
			//get WhUser Data
			map.addAttribute("whusers", whservice.getAllWhUser());
			//get Shipment Data
			map.addAttribute("shiptype", shipservice.getAllShipmentTypes());
		}else {
			// call service
			Integer poid = service.savePurchaseOrder(purchaseOrder);
			map.addAttribute("message", "Purchase Order '"+poid+"' Saved Successfully");
			// clean form
			map.addAttribute("purchaseOrder", new PurchaseOrder());
			//get WhUser Data
			map.addAttribute("whusers", whservice.getAllWhUser());
			//get Shipment Data
			map.addAttribute("shiptype", shipservice.getAllShipmentTypes());
		}
		return "PurchaseOrderRegister";
	}
	
	// 3. Get All Purchase Order
	@RequestMapping("/all")
	public String getAllPurchaseOrder(ModelMap map) {
		// call service
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		map.addAttribute("list", list);
		return "PurchaseOrderData";
	}
	
	// 4. Delete Purchase Order
	@RequestMapping("/delete")
	public String deletePurchaseOrder(@RequestParam Integer poid, ModelMap map) {
		// call service
		service.deletePurchaseOrder(poid);
		// add list
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		map.addAttribute("list", list);
		// send msg
		map.addAttribute("message", "Purchase Order '"+poid+"' Deleted Successfully");
		return "PurchaseOrderData";
	}

	// 5. View One Record
	@RequestMapping("/viewOne")
	public String viewPurchaseOrder(@RequestParam Integer poid, ModelMap map) {
		// call servce
		PurchaseOrder po = service.getPurchaseOrderById(poid);
		map.addAttribute("po", po);
		return "ViewPurchaseOrder";
	}
	
	// 6. Show Purchase Order Edit page
	@RequestMapping("/editOne")
	public String editPurchaseOrder(@RequestParam Integer poid, ModelMap map) {
		map.addAttribute("purchaseOrder", service.getPurchaseOrderById(poid));
		//get WhUser Data
		map.addAttribute("whusers", whservice.getAllWhUser());
		//get Shipment Data
		map.addAttribute("shiptype", shipservice.getAllShipmentTypes());
		return "PurchaseOrderEdit";
	}
	
	// 7. Update Purchase Order
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder, ModelMap map) {
		service.updatePurchaseOrder(purchaseOrder);
		// add list
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		map.addAttribute("list", list);
		// send msg
		map.addAttribute("message", "Purchase order '"+purchaseOrder.getOrderId()+"' updated Successfully");
		return "PurchaseOrderData";
	}
	
	// 8. Export Data to Excel
	@RequestMapping("/excelExp")
	public ModelAndView doExcelExport() {
		return new ModelAndView(new PurchaseOrderExcelView(), "list", service.getAllPurchaseOrder());
	}
	
	// 9. Single Record Excel Export
	@RequestMapping("/exportExcelOne")
	public ModelAndView doOneExcelExp(@RequestParam Integer poid) {
		return new ModelAndView(new PurchaseOrderExcelView(), "list", Arrays.asList(service.getPurchaseOrderById(poid)));
	}
	
	// 10. Export data to pdf
	@RequestMapping("/pdfExp")
	public ModelAndView doPdfExport() {
		return new ModelAndView(new PurchaseOrderPdfView(), "list", service.getAllPurchaseOrder());
	}
	
	@RequestMapping("/exportPdfOne")
	public ModelAndView doSinglePdfExport(@RequestParam Integer poid) {
		return new ModelAndView(new PurchaseOrderPdfView(), "list", Arrays.asList(service.getPurchaseOrderById(poid)));
	}
	
}








