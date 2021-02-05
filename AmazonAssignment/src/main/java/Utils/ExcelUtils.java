package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class ExcelUtils {
	public static File file;
	   public static Sheet sheet ;
	   public static FileInputStream fis;
	   public static Row row;
	   public static HSSFWorkbook wb;
	   
	   
	   
	public static HashMap<String,HashMap<String,String>> getUserData(String excelPath,String sheetName,String userType) throws IOException
	{
		String sheetUserType, sheetColumnName, sheetColumnValue  = null;
		file = new File(excelPath);
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new HSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		sheet =  wb.getSheet(sheetName);	
		//Hashmap needed to input row with usertype as the key
		HashMap<String,HashMap<String,String>> hm = new HashMap<String,HashMap<String,String>>();
		//Hashmap needed to input keys as column name and column values as the values
		HashMap<String,String> hc = new HashMap<String,String>();
		
		//Get the row count
		int rowCount = sheet.getLastRowNum()+1;
		
		//Get the column count
		int colCount = sheet.getRow(0).getLastCellNum();
		
		for(int i=1;i<rowCount;i++)
		{
			sheetUserType = sheet.getRow(i).getCell(0).getStringCellValue();
			
			//Get the sheetUserType from excel one by one and compare it with user type passed in script
			if(sheetUserType.equalsIgnoreCase(userType))
			{
				for(int j=1;j<colCount;j++)
				{   
					//Get the column name and corresponding column value
					sheetColumnName = sheet.getRow(0).getCell(j).getStringCellValue();
					sheetColumnValue = sheet.getRow(i).getCell(j).getStringCellValue();

					//log.info(sheetColumnName+" : "+sheetColumnValue);
					hc.put(sheetColumnName, sheetColumnValue);
				}
			}
		}
		//return the hashmap
		hm.put(userType, hc);
		return hm;
		
	}
	
	
	public static String getExcelValue(String sheetName,String userType,String columnName) throws IOException
	{
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\AmazonTestData\\TestData.xls";
		HashMap<String,HashMap<String,String>> hm = getUserData(excelPath,sheetName,userType);
		String mapValue = hm.get(userType).get(columnName);
		return mapValue;
	}
}
