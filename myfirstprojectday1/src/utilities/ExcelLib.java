package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib 
{
	public String readStringData(String sheetName,int row,int column) throws Exception
	{
		File f=new File(Constants.FILEPATH);
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	public double readNumericData(String sheetName,int row,int column) throws Exception
	{
		File f=new File(Constants.FILEPATH);
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		double data=wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		
		return data;
	}

}
