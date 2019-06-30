package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		// set file name
		response.setHeader("Content-Disposition", "attachment;filename=SHIPMENTS.pdf");
		
		// get Data from model class
		List<ShipmentType> list = (List<ShipmentType>) model.get("list");
		
		// #1 Create an element
		Paragraph p = new Paragraph("SHIPMENT PDF DOCUMENT");
		// Add element to doc
		document.add(p);
		
		
		// create table
		PdfPTable table = new PdfPTable(6);
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("ENABLED");
		table.addCell("GRADE");
		table.addCell("NOTE");
		
		for(ShipmentType s:list) {
			table.addCell(s.getId().toString());
			table.addCell(s.getShipmentMode());
			table.addCell(s.getShipmentCode());
			table.addCell(s.getEnableShipment());
			table.addCell(s.getShipmentGrade());
			table.addCell(s.getShipDesc());
		}
		
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
		
			
	}

}
