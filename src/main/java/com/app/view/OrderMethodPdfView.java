package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// set file name
		response.setHeader("Content-Disposition", "attachment;filename=ORDERMETHOD.pdf");
		
		// get Data from model class
		List<OrderMethod> list = (List<OrderMethod>) model.get("list");
		
		// #1 Create an element
		Paragraph p = new Paragraph("ORDER METHOD PDF DOCUMENT");
		// Add element to doc
		document.add(p);
		
		
		// create table
		PdfPTable table = new PdfPTable(6);
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("TYPE");
		table.addCell("DESC");
		table.addCell("ACCEPT");
		
		for(OrderMethod o:list) {
			table.addCell(o.getOid().toString());
			table.addCell(o.getOrderMode());
			table.addCell(o.getOrderCode());
			table.addCell(o.getExeType());
			table.addCell(o.getOrderDsc());
			table.addCell(o.getOrderAccept().toString());
		}
		
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
		
		
	}

}
