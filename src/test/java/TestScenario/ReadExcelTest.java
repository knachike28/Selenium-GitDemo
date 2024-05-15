package TestScenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelTest {
	public static String readExcelTest(int row, int cell, int index) throws IOException {
//Path of the excel file
		FileInputStream fs = new FileInputStream("/Users/kumarnachiketa/Codes/TestData/DemoData.xlsx");
//Creating a workbook
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(index);
		XSSFRow row1 = sheet.getRow(row);
		//XSSFCell cell1 = row.getCell(cell);
		XSSFCell data=sheet.getRow(row).getCell(cell);
		return data.toString();
	}
	
	public static void main(String[] args) {
        String value = null;
        try {
            value = readExcelTest(1, 1, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("the output of the excel: " +value);
        //System.out.println("the output of the excel: " + (value != null ? value.toString() : "null"));
    }
}
