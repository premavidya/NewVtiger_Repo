package test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Sample {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheetname = wb.getSheet("Org");
		int lastRow = sheetname.getLastRowNum();
			
		for(int i=0;i<lastRow;i++)
		{
			Row row=sheetname.getRow(i);
			Cell cell=	row.createCell(2);
			cell.setCellValue("Brand");
			
		}
		

	}

}
