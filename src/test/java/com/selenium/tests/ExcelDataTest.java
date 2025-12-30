package com.selenium.tests;

import com.selenium.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Example test demonstrating Excel-based data-driven testing
 * Note: This is a template - you need to create the Excel file with test data
 */
public class ExcelDataTest extends BaseTest {
    
    @Test(dataProvider = "excelData", enabled = false)
    public void testWithExcelData(String url, String title) {
        driver.get(url);
        
        String actualTitle = driver.getTitle();
        System.out.println("URL: " + url);
        System.out.println("Expected Title: " + title);
        System.out.println("Actual Title: " + actualTitle);
        
        // Add your assertions here
    }
    
    /**
     * DataProvider reading from Excel file
     * Create an Excel file at: src/test/resources/testdata/test_data.xlsx
     * with columns: URL, Title
     */
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        String excelPath = "src/test/resources/testdata/test_data.xlsx";
        String sheetName = "TestData";
        
        // Uncomment when you have created the Excel file
        // return ExcelReader.getTestData(excelPath, sheetName);
        
        // Placeholder data for demonstration
        return new Object[][] {
            {"https://www.google.com", "Google"},
            {"https://www.github.com", "GitHub"}
        };
    }
}
