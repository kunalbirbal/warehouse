package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// set file name
		response.setHeader("Content-Disposition", "attachment;filename=USER.pdf");
		
		// get Data from model class
		List<User> list = (List<User>) model.get("list");
		
		// #1 Create an element
		Paragraph p = new Paragraph("USER PDF DOCUMENT");
		// Add element to doc
		document.add(p);
		
		
		// create table
		PdfPTable table = new PdfPTable(6);
		table.addCell("ID");
		table.addCell("USERNAME");
		table.addCell("EMAIL");
		table.addCell("PASSWORD");
		table.addCell("CONTACT");
		table.addCell("ROLES");
		
		for(User u:list) {
			table.addCell(u.getUserId().toString());
			table.addCell(u.getUserName());
			table.addCell(u.getUserEmail());
			table.addCell(u.getUserPassword());
			table.addCell(u.getUserContact());
			table.addCell(u.getUserRoles().toString());
		}
		
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
		
		
	}

}
