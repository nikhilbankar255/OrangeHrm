package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] getData(String filePath, String sheetName) throws IOException
	{ //"  "login"
		Object [][] data= null;
		try {
		File fs = new File(filePath);
		FileInputStream fis = new FileInputStream(fs);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getPhysicalNumberOfRows();
		short cols = sheet.getRow(0).getLastCellNum();
		
		data=new Object[rows-1][cols];
		
		for(int i=1; i<rows; i++)
		{
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j]=cell.toString();
			}
		}
		workbook.close();
		fis.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
