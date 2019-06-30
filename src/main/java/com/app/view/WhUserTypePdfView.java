package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// set file name
		response.setHeader("Content-Disposition", "attachment;filename=WHUSER.pdf");
		
		// get Data from model class
		List<WhUserType> list = (List<WhUserType>) model.get("list");
		
		// #1 Create an element
		Paragraph p = new Paragraph("WH USER PDF DOCUMENT");
		// Add element to doc
		document.add(p);
				
		// create table
		PdfPTable table = new PdfPTable(9);
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("CODE");
		table.addCell("USERFOR");
		table.addCell("EMAIL");
		table.addCell("CONTACT");
		table.addCell("IDTYPE");
		table.addCell("OTHER");
		table.addCell("IDNUMBER");
		
		for(WhUserType w:list) {
			table.addCell(w.getUserId().toString());
			table.addCell(w.getUserType());
			table.addCell(w.getUserCode());
			table.addCell(w.getUserFor());
			table.addCell(w.getUserEmail());
			table.addCell(w.getUserContact());
			table.addCell(w.getUserIdType());
			table.addCell(w.getIfother());
			table.addCell(w.getIdnumber());
		}
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
				
		
	}

}
