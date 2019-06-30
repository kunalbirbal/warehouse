package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.PurchaseOrder;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PurchaseOrderPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// set file name
		response.setHeader("Content-Disposition", "attachment;filename=PURCHASEORDER.pdf");
		
		// get Data from model class
		List<PurchaseOrder> list = (List<PurchaseOrder>) model.get("list");
		
		// #1 Create an element
		Paragraph p = new Paragraph("PURCHASE ORDER PDF DOCUMENT");
		// Add element to doc
		document.add(p);		
		
		// create table
		PdfPTable table = new PdfPTable(8);
		table.addCell("ID");
		table.addCell("CODE");
		table.addCell("REF_NO.");
		table.addCell("QUALITY");
		table.addCell("STATUS");
		table.addCell("DESC");
		table.addCell("WH USER");
		table.addCell("SHIPMENT");
		
		for(PurchaseOrder po:list) {
			table.addCell(po.getOrderId().toString());
			table.addCell(po.getOrderCode());
			table.addCell(po.getRefNum());
			table.addCell(po.getQualityCheck());
			table.addCell(po.getOrderStatus());
			table.addCell(po.getOrderDesc());
			table.addCell(po.getWhUserType().getUserCode());
			table.addCell(po.getShipmentType().getShipmentMode());
			
		}
		
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
		
	}

}
