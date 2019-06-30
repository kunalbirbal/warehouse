package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.User;

public class UserExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// Set custom file name
		response.setHeader("Content-Disposition", "attachment;filename=USER.xlsx");
		
		// get model data
		List<User> list = (List<User>) model.get("list");
		
		// Create Sheet
		Sheet sheet = workbook.createSheet("User");
		
		// set Headlist in row 1
		setHead(sheet);
		
		// set Body Rows from list
		setBody(sheet, list);
		
	}
	
	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("USERNAME");
		row.createCell(2).setCellValue("EMAIL");
		row.createCell(3).setCellValue("PASSWORD");
		row.createCell(4).setCellValue("CONTACT");
		row.createCell(5).setCellValue("ROLES");
	}

	private void setBody(Sheet sheet, List<User> list) {
		int rowNum = 1;
		for(User u:list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(u.getUserId());
			row.createCell(1).setCellValue(u.getUserName());
			row.createCell(2).setCellValue(u.getUserEmail());
			row.createCell(3).setCellValue(u.getUserPassword());
			row.createCell(4).setCellValue(u.getUserContact());
			row.createCell(5).setCellValue(u.getUserRoles()!=null?u.getUserRoles().toString():"[]");
		}
	}

}
