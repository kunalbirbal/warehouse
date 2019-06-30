package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.PurchaseOrder;

public class PurchaseOrderExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// Set custom file name
		response.setHeader("Content-Disposition", "attachment;filename=PURCHASEORDER.xlsx");
		
		// get model data
		List<PurchaseOrder> list = (List<PurchaseOrder>) model.get("list");

		// Create Sheet
		Sheet sheet = workbook.createSheet("Purchase Order");
		
		// set Headlist in row 1
		setHead(sheet);
		
		// set Body Rows from list
		setBody(sheet, list);
			
	}

	// set Heading row 1
	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("REF_NO.");
		row.createCell(3).setCellValue("QUALITY");
		row.createCell(4).setCellValue("STATUS");
		row.createCell(5).setCellValue("DESC");
		row.createCell(6).setCellValue("WHUER");
		row.createCell(7).setCellValue("SHIPMENT");
	}
	
	// create Body Data using list
	private void setBody(Sheet sheet, List<PurchaseOrder> list) {
		int rowNum = 1;
		for(PurchaseOrder po:list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(po.getOrderId());
			row.createCell(1).setCellValue(po.getOrderCode());
			row.createCell(2).setCellValue(po.getRefNum());
			row.createCell(3).setCellValue(po.getQualityCheck());
			row.createCell(4).setCellValue(po.getOrderStatus());
			row.createCell(5).setCellValue(po.getOrderDesc());
			row.createCell(6).setCellValue(po.getWhUserType().getUserCode());
			row.createCell(7).setCellValue(po.getShipmentType().getShipmentMode());
			
		}
	}
}
