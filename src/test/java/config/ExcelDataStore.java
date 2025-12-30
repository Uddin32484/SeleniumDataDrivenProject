package config;

import org.testng.annotations.DataProvider;
import util.ExcelUtils;

import java.io.IOException;

public class ExcelDataStore {
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() throws IOException {
        ExcelUtils excel = new ExcelUtils();
        String path = System.getProperty("user.dir") + "/src/test/resources/testData.xlsx";


        return excel.getTableArray(path, "login");
    };
}
