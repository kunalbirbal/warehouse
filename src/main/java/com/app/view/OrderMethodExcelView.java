package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// Set custom file name
		response.setHeader("Content-Disposition", "attachment;filename=ORDERMETHOD.xlsx");
		
		// get model data
		List<OrderMethod> list = (List<OrderMethod>) model.get("list");
		
		// Create Sheet
		Sheet sheet = workbook.createSheet("Order Method");
		
		// set Headlist in row 1
		setHead(sheet);
		
		// set Body Rows from list
		setBody(sheet, list);
		
	}

	// set Heading row 1
	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("DESC");
		row.createCell(5).setCellValue("ACCEPT");
	}
	
	// create Body Data using list
	private void setBody(Sheet sheet, List<OrderMethod> list) {
		int rowNum = 1;
		for(OrderMethod o:list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(o.getOid());
			row.createCell(1).setCellValue(o.getOrderMode());
			row.createCell(2).setCellValue(o.getOrderCode());
			row.createCell(3).setCellValue(o.getExeType());
			row.createCell(4).setCellValue(o.getOrderDsc());
			row.createCell(5).setCellValue(o.getOrderAccept()!=null?o.getOrderAccept().toString():"[]");
		}
	}

}
