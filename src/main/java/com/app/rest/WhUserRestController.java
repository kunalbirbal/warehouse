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

import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@RestController
@RequestMapping("/rest/whuser/")
public class WhUserRestController {
	
	@Autowired
	private IWhUserTypeService service;
	
	// get All Records
	@GetMapping("/all")
	public ResponseEntity<?> getAllWHUser(){
		
		ResponseEntity<?> response = null;
		List<WhUserType> whuser = service.getAllWhUser();
		
		if(whuser != null && !whuser.isEmpty()) {
			response = new ResponseEntity<List<WhUserType>>(whuser, HttpStatus.OK);
		}else {
			response = new ResponseEntity<List<WhUserType>>(whuser, HttpStatus.OK);
		}
		
		return response;
	}
	
	// Get Single Record
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getSingleWhUser(@PathVariable Integer id){
		
		ResponseEntity<?> resp = null;
		
		WhUserType wh = service.getWhUserById(id);		
		
		if(wh != null) {
			resp = new ResponseEntity<WhUserType>(wh, HttpStatus.OK);
		}else {
			resp = new ResponseEntity<String>("No Record Found", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	
	// Delete Record
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteWhUser(@PathVariable Integer id){
		
		ResponseEntity<String> resp = null;
		
		try {
			service.deleteWhUserType(id);
			resp = new ResponseEntity<String>("Record ID '"+id+"' Deleted", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Record With ID '"+id+"' Not Foud", HttpStatus.BAD_REQUEST);
		}
				
		return resp;
	}
	
	// Save WhUser
	@PostMapping("/save")
	public ResponseEntity<?> saveData(@RequestBody WhUserType whUserType){
		Integer wid = service.saveWhUserType(whUserType);
		return new ResponseEntity<String>("WhUser '"+wid+"' Saved Successfully", HttpStatus.OK);
	}
	
	// Update Shipment
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody WhUserType whUserType){
		ResponseEntity<String> resp = null;
		try {
			service.updateWhUserType(whUserType);
			resp = new ResponseEntity<String>("WhUser '"+whUserType.getUserId()+"' Updated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("WhUser '"+whUserType.getUserId()+"' Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
}
