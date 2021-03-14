package com.application1.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.application1.constants.FrameworkConstants;

public class ExcelOperations {
	private ExcelOperations() {

	}
	public static List<Map<String,String>> readExcelSheettoHashMap(String path,String sheetname) throws IOException {
		FileInputStream fs = new FileInputStream(path);
		XSSFWorkbook  workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rownum = sheet.getLastRowNum();
		int colnum = sheet.getRow(0).getLastCellNum();
		Map<String,String> data = new HashMap<String, String>();
		List<Map<String,String>> list = new ArrayList<>();

		for(int i=1;i<=rownum;i++)
		{
			data =new HashMap<>();
			for (int j=0;j<colnum;j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				data.put(key,value);	
			}
			list.add(data);
		}
		if(Objects.nonNull(fs)) {
			fs.close();
		}

		return list;
	}

	public static List<Map<String,String>> getTestcase(String sheetname) throws IOException{
		return readExcelSheettoHashMap(FrameworkConstants.getResources()+"\\TestData\\testdata.xlsx",sheetname);

	}


}

