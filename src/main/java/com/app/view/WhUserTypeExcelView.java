package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// set custom name of excel
		response.setHeader("Content-Disposition", "attachment;filename=WHUSER.xlsx");
		
		// get model object
		List<WhUserType> list = (List<WhUserType>) model.get("list");
		
		// create Sheet
		Sheet sheet = workbook.createSheet("Wh User Type");
		
		// set heading in row 1
		setHead(sheet);
		
		// set body from list
		setBody(sheet, list);
		
	}


	// set heading row 1
	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("FOR");
		row.createCell(4).setCellValue("EMAIL");
		row.createCell(5).setCellValue("CONTACT");
		row.createCell(6).setCellValue("IDTYPE");
		row.createCell(7).setCellValue("OTHER");
		row.createCell(8).setCellValue("NUMBER");
	}

	// set body data from list
	private void setBody(Sheet sheet, List<WhUserType> list) {
		int rowNum = 1;
		for(WhUserType w:list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(w.getUserId());
			row.createCell(1).setCellValue(w.getUserType());
			row.createCell(2).setCellValue(w.getUserCode());
			row.createCell(3).setCellValue(w.getUserFor());
			row.createCell(4).setCellValue(w.getUserEmail());
			row.createCell(5).setCellValue(w.getUserContact());
			row.createCell(6).setCellValue(w.getUserIdType());
			row.createCell(7).setCellValue(w.getIfother());
			row.createCell(8).setCellValue(w.getIdnumber());
		}
	}
	
}
