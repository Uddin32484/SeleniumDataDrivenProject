package util;

import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import java.io.IOException;

public class ExcelUtils {

    public Object[][] getTableArray(String filePath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new RuntimeException("Could not find sheet named: " + sheetName +
                    ". Available sheets: " + workbook.getSheetAt(0).getSheetName());
        }
        int lastRowIndex = sheet.getLastRowNum();
        int totalCols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new String[lastRowIndex][totalCols];
        for (int i = 0; i <lastRowIndex; i++) {
            XSSFRow row = sheet.getRow(i + 1);
            if (row == null) continue;
            for (int j = 0; j < totalCols; j++) {
                XSSFCell cell = row.getCell(j);

                // Logic to identify cell type
                if (cell == null) {
                    data[i][j] = "";
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    // Store as Integer (cast from double)
                    data[i][j] = String.valueOf((int) cell.getNumericCellValue());
                } else {
                    // Store as String
                    data[i][j] = cell.getStringCellValue();
                }
            }
        }
        workbook.close();
        return data;
    }

//    /// write data to excel //
//
//    public void setCellData(String filePath, String sheetName, int rowNum, int colNum, String data) throws IOException {
//        FileInputStream fis = new FileInputStream(filePath);
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.getSheet(sheetName);
//
//        // Get the row (create it if it doesn't exist)
//        XSSFRow row = sheet.getRow(rowNum);
//        if (row == null) row = sheet.createRow(rowNum);
//
//        // Get the cell (create it if it doesn't exist)
//        XSSFCell cell = row.getCell(colNum);
//        if (cell == null) cell = row.createCell(colNum);
//
//        // Set the value
//        cell.setCellValue(data);
//
//        // Write the changes back to the file
//        FileOutputStream fos = new FileOutputStream(filePath);
//        workbook.write(fos);
//
//        fos.close();
//        workbook.close();
//        fis.close();
//    }
}

