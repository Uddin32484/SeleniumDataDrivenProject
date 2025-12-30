# Selenium Data Driven Project

[![Selenium Tests](https://github.com/Uddin32484/SeleniumDataDrivenProject/actions/workflows/selenium-tests.yml/badge.svg)](https://github.com/Uddin32484/SeleniumDataDrivenProject/actions/workflows/selenium-tests.yml)

A comprehensive Selenium WebDriver test automation framework demonstrating data-driven testing approach with GitHub Actions CI/CD integration.

## 🚀 Features

- **Data-Driven Testing**: Uses TestNG DataProviders for parameterized tests
- **Excel Data Support**: Read test data from Excel files using Apache POI
- **Automated Driver Management**: WebDriverManager handles browser driver setup
- **Headless Execution**: Configured for CI/CD with headless Chrome
- **GitHub Actions**: Automated test execution on every push/PR
- **Test Reports**: Automatic generation and upload of test results

## 📋 Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Chrome browser (for local execution)

## 🛠️ Project Structure

```
SeleniumDataDrivenProject/
├── .github/
│   └── workflows/
│       └── selenium-tests.yml      # GitHub Actions workflow
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/selenium/
│   │           └── utils/
│   │               └── ExcelReader.java    # Excel data reader utility
│   └── test/
│       ├── java/
│       │   └── com/selenium/tests/
│       │       ├── BaseTest.java          # Base test class
│       │       └── GoogleSearchTest.java  # Sample test
│       └── resources/
│           └── testdata/
│               └── search_data.csv        # Test data
├── pom.xml                         # Maven configuration
├── testng.xml                      # TestNG suite configuration
└── README.md
```

## 🔧 Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Uddin32484/SeleniumDataDrivenProject.git
   cd SeleniumDataDrivenProject
   ```

2. **Install dependencies**
   ```bash
   mvn clean install -DskipTests
   ```

## ▶️ Running Tests

### Run all tests
```bash
mvn test
```

### Run specific test class
```bash
mvn test -Dtest=GoogleSearchTest
```

### Run with custom TestNG suite
```bash
mvn test -DsuiteXmlFile=testng.xml
```

## 🤖 GitHub Actions

The project is configured with GitHub Actions to automatically run tests on:
- Push to main/master/develop branches
- Pull requests to main/master/develop branches
- Manual workflow dispatch

### Workflow Features:
- ✅ Automatic Java and Maven setup
- ✅ Chrome browser installation
- ✅ Test execution with reporting
- ✅ Test report artifacts (retained for 30 days)
- ✅ Test results publishing

### View Test Results:
1. Go to the "Actions" tab in your GitHub repository
2. Click on the latest workflow run
3. Download test reports from the "Artifacts" section

## 📊 Data-Driven Testing

This framework supports multiple approaches for data-driven testing:

### 1. TestNG DataProvider (Code-based)
```java
@DataProvider(name = "searchData")
public Object[][] getSearchData() {
    return new Object[][] {
        {"Selenium WebDriver", "selenium"},
        {"TestNG Framework", "testng"}
    };
}
```

### 2. Excel Files (using Apache POI)
```java
@DataProvider(name = "excelData")
public Object[][] getExcelData() {
    return ExcelReader.getTestData("src/test/resources/testdata/data.xlsx", "Sheet1");
}
```

### 3. CSV Files
Place CSV files in `src/test/resources/testdata/` and read them in your tests.

## 🔍 Adding New Tests

1. Create a new test class extending `BaseTest`
2. Add test methods with `@Test` annotation
3. Use `@DataProvider` for data-driven tests
4. Update `testng.xml` to include the new test class

Example:
```java
public class MyNewTest extends BaseTest {
    @Test(dataProvider = "myData")
    public void testSomething(String param1, String param2) {
        driver.get("https://example.com");
        // Your test logic here
    }
    
    @DataProvider(name = "myData")
    public Object[][] getData() {
        return new Object[][] {
            {"value1", "value2"},
            {"value3", "value4"}
        };
    }
}
```

## 🐛 Troubleshooting

### Tests fail locally but pass in CI
- Ensure Chrome is installed and up to date
- Check if headless mode is causing issues (remove from ChromeOptions)

### WebDriver errors
- WebDriverManager should handle driver downloads automatically
- Check internet connectivity for driver downloads

### Test timeouts
- Increase implicit wait time in `BaseTest.java`
- Check if the target website is accessible

## 📝 Configuration

### Browser Configuration
Edit `BaseTest.java` to change browser settings:
- Remove `--headless` for visible browser execution
- Adjust `--window-size` for different resolutions
- Add more ChromeOptions as needed

### Test Timeout
Modify in `BaseTest.java`:
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is open source and available under the MIT License.

## 👤 Author

**Uddin32484**
- GitHub: [@Uddin32484](https://github.com/Uddin32484)

## ⭐ Show your support

Give a ⭐️ if this project helped you!