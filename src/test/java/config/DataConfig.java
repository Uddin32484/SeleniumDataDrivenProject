package config;

import org.testng.annotations.DataProvider;
import util.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class DataConfig {

    @DataProvider(name = "getLoginData")
    public static Object[][] getData() throws IOException {
        // Path to your JSON file
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testData.json";

        // Calling your utility method
        List<HashMap<String, String>> data = JsonUtils.getJsonData(filePath);

        Object[][] testData = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            testData[i][0] = data.get(i);
        }
        return testData;
    }
}