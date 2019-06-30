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
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/shipment/")
public class ShipmentTypeRestController {
	
	@Autowired
	private IShipmentTypeService service;
	
	// Get All Records
	@GetMapping("/all")
	public ResponseEntity<?> getAllShipments(){
		
		ResponseEntity<?> response = null;
		List<ShipmentType> ship = service.getAllShipmentTypes();
		
		if(ship != null && !ship.isEmpty()) {
			response = new ResponseEntity<List<ShipmentType>>(ship, HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>("Data Not Available", HttpStatus.OK);
		}
		return response;
	}
	
	// Get Single Shipment
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getSingleShipment(@PathVariable Integer id){
		
		ResponseEntity<?> resp = null;
		
		ShipmentType sh = service.getShipmentTypeById(id);
		if(sh != null) {
			resp = new ResponseEntity<ShipmentType>(sh, HttpStatus.OK);
		}else {
			resp = new ResponseEntity<String>("No Record Found", HttpStatus.BAD_REQUEST);
		}
		
		return resp;		
	}
	
	// Delete Record
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteShipment(@PathVariable Integer id){
		
		ResponseEntity<?> resp = null;
		
		try {
			service.deleteShipmentType(id);
			resp = new ResponseEntity<String>("Redord ID '"+id+"' Deleted", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Record With ID '"+id+"' Not Found", HttpStatus.BAD_REQUEST);
		}		
		
		return resp;
	}
	
	// Save Shipment
	@PostMapping("/save")
	public ResponseEntity<?> saveData(@RequestBody ShipmentType shipmentType){
		Integer sid = service.saveShipmentType(shipmentType);
		return new ResponseEntity<String>("Shipment '"+sid+"' Saved Successfully", HttpStatus.OK);
	}
	
	// Update Shipment
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody ShipmentType shipmentType){
		ResponseEntity<String> resp = null;
		try {
			service.updateShipmentType(shipmentType);
			resp = new ResponseEntity<String>("Shipment '"+shipmentType.getId()+"' Updated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Shipment '"+shipmentType.getId()+"' Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
}
