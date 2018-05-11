package com.vaishnavi.database.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.vaishnavi.database.dao.DatabaseDAO;
import com.vaishnavi.database.model.Template;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "lst" })
public class HomeController {

	@Autowired
	DatabaseDAO databaseDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("lst", databaseDAO.getAll());
		return "home";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestParam("uploadFile") MultipartFile file, Model model) {

		if (file.getOriginalFilename().endsWith(".xlsx")) {
			try {
				List<Template> lst = new ArrayList<Template>();
				int i = 0;

				XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet worksheet = workbook.getSheetAt(0);
				while (i <= worksheet.getLastRowNum()) {

					XSSFRow row = worksheet.getRow(i++);

					Template template = new Template();

					template.setFirstname(row.getCell(0).getStringCellValue());
					template.setLastname(row.getCell(1).getStringCellValue());
					template.setEmail(row.getCell(2).getStringCellValue());
					template.setPassword(row.getCell(3).getStringCellValue());
					template.setState(row.getCell(4).getStringCellValue());
					template.setCountry(row.getCell(4).getStringCellValue());
					template.setAge((int) row.getCell(6).getNumericCellValue());
					
					lst.add(template);
				}
				workbook.close();
				databaseDAO.addDataToDatabase(lst);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		model.addAttribute("lst", databaseDAO.getAll());
		return "home";
	}

	@RequestMapping(value = "/removeSelected", method = RequestMethod.POST)
	public String removeRowsHandler(@RequestParam("rows") String[] rows, Model model) {
		databaseDAO.removeSelectedRows(rows);
		model.addAttribute("lst", databaseDAO.getAll());
		return "home";
	}
}
