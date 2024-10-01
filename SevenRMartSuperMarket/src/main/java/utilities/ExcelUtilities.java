package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtilities {
	
		static FileInputStream f;//This is used to obtain input bytes from the file. 
		//It represents the file input stream for reading data from the Excel file.
		static XSSFWorkbook w;//This represents the workbook instance, which refers to the entire Excel file.
		static XSSFSheet sh;//class representing the sheet in an XLSX file.
		public static String readStringData(int row, int col) throws IOException 
		{
		f=new FileInputStream("C:\\Users\\ANUPAMA VISHNU\\git\\TestApp\\projects12\\src\\main\\resources\\Book 1.xlsx");//obtaining input bytes from a file
		w=new XSSFWorkbook(f);//creating workbook instance that refers to the xlsx file
		sh=w.getSheet("Sheet1");//Retrieves the specified sheet named "Sheet1"
		XSSFRow r=sh.getRow(row);//retrieves specified row 
		XSSFCell c=r.getCell(col);//retrieves specified column
		return c.getStringCellValue();//retrieves cell string value
		}
		public static String readIntegerData(int row, int col) throws IOException
		{
	f=new FileInputStream("C:\\Users\\ANUPAMA VISHNU\\git\\TestApp\\projects12\\src\\main\\resources\\Book 1.xlsx");
		w=new XSSFWorkbook(f);
			sh=w.getSheet("Sheet1");
			XSSFRow r=sh.getRow(row);
			XSSFCell c=r.getCell(col);
			int val=(int) c.getNumericCellValue(); // Retrieves and casts the numeric cell value to an integer
			return String.valueOf(val); // Converts the integer value to a string and returns it
			
		}
	}


