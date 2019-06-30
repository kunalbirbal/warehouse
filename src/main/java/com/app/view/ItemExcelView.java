package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Item;

public class ItemExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// Set custom file name
		response.setHeader("Content-Disposition", "attachment;filename=ITEM.xlsx");
		
		// get model data list
		List<Item> list = (List<Item>) model.get("list");
		
		// Create Sheet
		Sheet sheet = workbook.createSheet("Item");
		
		// set Headlist in row 1
		setHead(sheet);
				
		// set Body Rows from list
		setBody(sheet, list);
		
	}
	
	private void setHead(Sheet sheet) {
		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("LENGTH");
		row.createCell(3).setCellValue("WIDTH");
		row.createCell(4).setCellValue("HEIGHT");
		row.createCell(5).setCellValue("COST");
		row.createCell(6).setCellValue("CURRENCY");
		row.createCell(7).setCellValue("DESC");
		row.createCell(8).setCellValue("UOM");
		row.createCell(9).setCellValue("ORDER METHOD");
	}

	private void setBody(Sheet sheet, List<Item> list) {
		int rowNum = 1;
		for(Item i:list) {
			Row row =sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(i.getItemId());
			row.createCell(1).setCellValue(i.getItemCode());
			row.createCell(2).setCellValue(i.getItemLength());
			row.createCell(3).setCellValue(i.getItemWidht());
			row.createCell(4).setCellValue(i.getItemHeight());
			row.createCell(5).setCellValue(i.getBaseCost());
			row.createCell(6).setCellValue(i.getBaseCurr());
			row.createCell(7).setCellValue(i.getItemDsc());
			row.createCell(8).setCellValue(i.getUom().getUomModel());
			row.createCell(9).setCellValue(i.getOrderMethod().getOrderMode());
		}
	}


}
