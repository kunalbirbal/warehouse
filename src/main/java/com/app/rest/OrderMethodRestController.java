package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/rest/order/")
public class OrderMethodRestController {
	
	@Autowired
	private IOrderMethodService service;
	
	// Get All Records
	@GetMapping("/all")
	public ResponseEntity<?> getAllOrders(){
		
		ResponseEntity<?> response = null;
		List<OrderMethod> ord = service.getAllOrders();	
		
		if(ord != null && !ord.isEmpty()) {
			response = new ResponseEntity<List<OrderMethod>>(ord, HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>("Data Not Available", HttpStatus.OK);
		}
		
		return response;
	}
	
	// Get Single Record
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getSingleOrder(@PathVariable Integer id){
		
		ResponseEntity<?> resp = null;
		
		OrderMethod om = service.getOrderById(id);	
		if(om != null) {
			resp = new ResponseEntity<OrderMethod>(om, HttpStatus.OK);
		}else {
			resp = new ResponseEntity<String>("No Record Found", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	
	// Delete Order
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Integer id){
		
		ResponseEntity<String> resp = null;
		
		try {
			service.deleteOrder(id);
			resp = new ResponseEntity<String>("Order '"+id+"' Deleted", HttpStatus.OK);			
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Order with Id '"+id+"' Not Found", HttpStatus.BAD_REQUEST);
		}
				
		return resp;
	}
	
	// save OrderMehod
	@PostMapping("/save")
	public ResponseEntity<?> saveOrder(@RequestBody OrderMethod orderMethod){
		Integer oid = service.saveOrder(orderMethod);
		return new ResponseEntity<String>("OrderMethod '"+oid+"' Saved Successfully", HttpStatus.OK);
	}

	// update Method
	@PutMapping("/update")
	public ResponseEntity<String> updateOrder(@RequestBody OrderMethod orderMethod){
		
		ResponseEntity<String> resp = null;
		try {
			service.updateOrder(orderMethod);
			resp = new ResponseEntity<String>("OrderMethod '"+orderMethod.getOid()+"' Updated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("OrderMethod '"+orderMethod.getOid()+"' Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
}
