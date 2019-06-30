package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {
	
	@Autowired
	private IDocumentService service;

	// 1. show document page
	@RequestMapping("/all")
	public String showDoc(ModelMap map) {
		
		//show all uploaded docs
		List<Object[]> list = service.getDocsIdAndNames();		
		map.addAttribute("list", list);
		
		return "Documents";
	}
	
	// 2. Upload on submit
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadDoc(@RequestParam CommonsMultipartFile fileob, ModelMap map) {
		
		if(fileob!=null) {
			//convert CMF data to Model class obj
			Document doc = new Document();
			
			//doc.setFileId(fileId); auto generated
			doc.setFileName(fileob.getOriginalFilename());
			doc.setFileData(fileob.getBytes());
			
			int id =service.saveDocument(doc);
			
			map.addAttribute("message", "Saved with	Id:"+id);
			
			//show all uploaded docs
			List<Object[]> list = service.getDocsIdAndNames();		
			map.addAttribute("list", list);

		}
		
		return "Documents";
	}
	
	// 3. Download Document on click
	@RequestMapping("/download")
	public void downloadDoc(@RequestParam Integer docid, HttpServletResponse resp) {
		
		// call service to get record from db
		Document doc = service.getDocumentById(docid);
		
		// add Header
		resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		
		// add Body
		try {
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
