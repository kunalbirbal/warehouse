package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// set file name
		response.setHeader("Content-Disposition", "attachment;filename=ITEMS.pdf");
		
		// get list of object
		List<Item> list = (List<Item>) model.get("list");
		
		// #1 Create an element
		Paragraph p = new Paragraph("ITEMS PDF DOCUMENT");
		// Add element to doc
		document.add(p);
		
		
		// create table
		PdfPTable table = new PdfPTable(10);
		table.addCell("ID");
		table.addCell("CODE");
		table.addCell("LENGTH");
		table.addCell("WIDTH");
		table.addCell("HEIGHT");
		table.addCell("COST");
		table.addCell("CURRENCY");
		table.addCell("DESC");
		table.addCell("UOM");
		table.addCell("ORDER METHOD");
		
		for(Item i:list) {
			table.addCell(i.getItemId().toString());
			table.addCell(i.getItemCode());
			table.addCell(String.valueOf(i.getItemLength()));
			table.addCell(String.valueOf(i.getItemWidht()));
			table.addCell(String.valueOf(i.getItemHeight()));
			table.addCell(String.valueOf(i.getBaseCost()));
			table.addCell(i.getBaseCurr());
			table.addCell(i.getItemDsc());
			table.addCell(i.getUom().getUomModel());
			table.addCell(i.getOrderMethod().getOrderMode());
		}
		
		document.add(table);
		
		//Display generated Date
		document.add(new Paragraph(new Date().toString()));
		
	}

}
