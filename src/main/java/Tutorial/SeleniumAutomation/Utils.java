package Tutorial.SeleniumAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(Utils.class.getName());

	// Reading configuration property
	public static String readConfigFile(String parameter) {
		String value = null;
		try {
			File file = new File("E:\\Maven\\SeleniumAutomation\\Resource\\config.property");
			FileInputStream fileInputStream = new FileInputStream(file);
			Properties property = new Properties();
			property.load(fileInputStream);
			value = property.getProperty(parameter);
		} catch (Exception e) {
			log.error("Issue in reading propery file");
		}
		return value;
	}

	// Reading file from excel
	public void readExcel() {
		File excelFile = new File("E:\\Maven\\SeleniumAutomation\\Resource\\Documents\\ExcelSheets\\LoginData.xlsx");
		try {
			FileInputStream fileInputStream = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// reading cell colum and rows

			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				int columnCount = row.getLastCellNum() - row.getFirstCellNum();
				for (int j = 0; j < columnCount; j++) {
					System.out.println(row.getCell(j).getStringCellValue());

				}

			}
		workbook.close();
		} catch (Exception e) {
			log.error("Issue in reading excel file");
		}

	
		
	}

}
