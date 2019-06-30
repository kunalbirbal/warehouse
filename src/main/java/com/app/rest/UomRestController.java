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

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom/")
public class UomRestController {
	
	@Autowired
	private IUomService service;
	
	// Get All Records
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		
		ResponseEntity<?> response = null; // <?> will decide entity type at runtime
		List<Uom> uoms = service.getAllUom();
		
		if(uoms != null && !uoms.isEmpty()) {
			response = new ResponseEntity<List<Uom>>(uoms, HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>("Data Not Available", HttpStatus.OK);
		}
		
		return response;
	}
	
	// Get Single Record
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getSingleUom(@PathVariable Integer id){
		
		ResponseEntity<?> resp = null;
		
		// call service
		Uom uom = service.getUomById(id);
		
		if(uom != null) {
			resp = new ResponseEntity<Uom>(uom, HttpStatus.OK);
		}else {
			resp = new ResponseEntity<String>("Record Not Found", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	
	// Delete Record 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUom(@PathVariable Integer id){
		
		ResponseEntity<?> resp = null;
		
		try {
			service.deleteUom(id);
			resp = new ResponseEntity<String>("UOM '"+id+"' Deleted", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("UOM With Id '"+id+"' Not Found", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	
	// save Uom Record
	@PostMapping("/save")
	public ResponseEntity<?> saveData(@RequestBody Uom uom){		
		Integer uomid = service.saveUom(uom);
		return new ResponseEntity<String>("UOM with id '"+uom.getUomId()+"' Saved Successfully", HttpStatus.OK);
	}
	
	// update uom record 
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody Uom uom){
		
		ResponseEntity<String> resp = null;
		try {
			service.updateUom(uom);
			resp = new ResponseEntity<String>("Uom '"+uom.getUomId()+"' Updated Successfulyy", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Uom '"+uom.getUomId()+"' Not Found", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}

}
