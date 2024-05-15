// Import statements 
package TestScenario;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

// Main class 
public class readExcelData { 

	// Main driver method 
	public static void main(String[] args) { 
		// Try block to check for exceptions 
		try { 
			// Reading file from local directory 
			FileInputStream file = new FileInputStream( 
				new File("/Users/kumarnachiketa/Codes/TestData/DemoData.xlsx")); 

			// Create Workbook instance holding reference to 
			// .xlsx file 
			Workbook workbook = new XSSFWorkbook(file); 

			// Get first/desired sheet from the workbook 
			Sheet sheet = workbook.getSheetAt(0); 

			// Iterate through each rows one by one 
			Iterator<Row> rowIterator = sheet.iterator(); 

			// Till there is an element condition holds true 
			while (rowIterator.hasNext()) { 

				Row row = rowIterator.next(); 

				// For each row, iterate through all the 
				// columns 
				Iterator<Cell> cellIterator = row.cellIterator(); 

				while (cellIterator.hasNext()) { 

					Cell cell = cellIterator.next(); 

					// Checking the cell type and format 
					// accordingly 
					switch (cell.getCellType()) { 

					// Case 1 
					case NUMERIC:
					    System.out.print(cell.getNumericCellValue() + "\t");
					    break;

					// Case 2 
					case STRING:
					    System.out.print(cell.getStringCellValue() + "\t");
					    break;
					} 
				} 

				System.out.println(""); 
			} 

			// Closing file input stream 
			file.close(); 
		} 

		// Catch block to handle exceptions 
		catch (IOException e) { 

			// Display the exception along with line number 
			// using printStackTrace() method 
			e.printStackTrace(); 
		} 
	} 
}
