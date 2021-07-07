package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static final String TEST_DATA_SHEET = "./src/test/resource/TestData/TestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] getData(String sheetName) {
		Object data[][] = null;// at this point # of rows and columns are not known hence, its defined null;
		FileInputStream fp;
		try {
			fp = new FileInputStream(TEST_DATA_SHEET);
			book = WorkbookFactory.create(fp);
			sheet = book.getSheet(sheetName);
			int rownumber = sheet.getLastRowNum();/// i created instead of writting this in for condition-note for Seema
			int columnumb = sheet.getRow(0).getLastCellNum();

			data = new Object[rownumber][columnumb];
			for (int i = 0; i <rownumber; i++) {
				for (int j = 0; j < columnumb; j++) {
               data[i][j]=sheet.getRow(i+1).getCell(j).toString();//this is coming in form of excel string to convert it in Java string.tostring is used
				}

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (InvalidFormatException | IOException e) {

			e.printStackTrace();
		}
		return data;

	}

}
