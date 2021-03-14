package com.application1.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class dataProviderTest {

	@Test(dataProvider="getName",dataProviderClass = dataProviderTest.class)
	public void test(Object[] data){

		System.out.println(data);
		System.out.println(data);

	}
	@DataProvider (name="getName",parallel = true)
	public Object[][] getData() throws IOException {
		
		//String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\testdata.xlsx";
		//Object[][] data = ExcelOperations.readExcelSheettoHashMap(path, "RunManager");
		
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\testdata.xlsx");
		XSSFWorkbook  workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("RunManager");
		int rownum = sheet.getLastRowNum();
		System.out.println(rownum);
		int colnum = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rownum][colnum];

		for(int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colnum;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data[i-1][j]);
			}
		}
		workbook.close();
		System.out.println(data);
		return data;

	}

}
