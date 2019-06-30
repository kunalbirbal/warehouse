package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// set file name
		response.setHeader("Content-Disposition", "attachment;filename=UOM.pdf");
		
		// get Data from model class
		List<Uom> list = (List<Uom>) model.get("list");
		
		// #1 Create an element
		Paragraph p = new Paragraph("UOM PDF DOCUMENT");
		// Add element to doc
		document.add(p);
				
		// create table
		PdfPTable table = new PdfPTable(4);
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("MODEL");
		table.addCell("NOTE");
		
		for(Uom u:list) {
			table.addCell(u.getUomId().toString());
			table.addCell(u.getUomType());
			table.addCell(u.getUomModel());
			table.addCell(u.getUomDsc());
		}
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
						
	}

}
