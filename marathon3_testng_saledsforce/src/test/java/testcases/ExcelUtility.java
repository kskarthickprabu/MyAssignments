package testcases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelUtility {

    

    public static String[][] readData(String fileName) throws IOException {

       XSSFWorkbook wb = new XSSFWorkbook("./data/" + fileName + ".xlsx");
        XSSFSheet sheet = wb.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rowCount][colCount];

       for (int i = 1; i <= rowCount; i++) {

    if (sheet.getRow(i) == null) {
        continue; // skip empty row
    }

    for (int j = 0; j < colCount; j++) {

        Cell cell = sheet.getRow(i).getCell(j);

        if (cell == null) {
            data[i - 1][j] = "";
        } 
        else if (cell.getCellType() == CellType.STRING) {
            data[i - 1][j] = cell.getStringCellValue();
        } 
        else if (cell.getCellType() == CellType.NUMERIC) {
            data[i - 1][j] = String.valueOf((long) cell.getNumericCellValue());
        } 
        else {
            data[i - 1][j] = "";
        }
    }
}

        wb.close();
        return data;
    }
}

