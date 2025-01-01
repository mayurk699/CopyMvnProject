package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	//@Author: Mayur Kashikar
	//This method is used to Get TestData from ExcelSheet
	//It need to pass two input: 1.rowIndex 2.colIndex
	public static String getTD(int rowIndex,int colIdex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Book1.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		String value = sh.getRow(rowIndex).getCell(colIdex).getStringCellValue();
		return value;
	}
	
	public  static void captureSS(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//                                  	C:\Users\Dell\eclipse-workspace\Selenium\Screenshot
		File dest=new File(System.getProperty("user.dir")+"\\Screenshot\\TestCaseID"+TCID+".jpg");
		FileHandler.copy(src, dest);
		
	}
	
	public static String getTestDataFromPropertyFiles(String key) throws IOException
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\propertyFiles.properties");
		Properties p=new Properties();
		p.load(file);
		String value = p.getProperty(key);
		
		return value;
		
	}
	

}
