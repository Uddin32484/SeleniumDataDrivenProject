package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Sample data-driven test demonstrating Google search
 */
public class GoogleSearchTest extends BaseTest {
    
    @Test(dataProvider = "searchData")
    public void testGoogleSearch(String searchTerm, String expectedResult) {
        // Navigate to Google
        driver.get("https://www.google.com");
        
        try {
            // Accept cookies if present
            WebElement acceptButton = driver.findElement(By.xpath("//button[contains(., 'Accept') or contains(., 'Agree')]"));
            if (acceptButton.isDisplayed()) {
                acceptButton.click();
            }
        } catch (Exception e) {
            // Cookie dialog not found, continue
        }
        
        // Find search box and enter search term
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
        
        // Wait for results
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Verify page title contains search term
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.toLowerCase().contains(searchTerm.toLowerCase()), 
            "Page title should contain search term: " + searchTerm);
        
        System.out.println("Test passed for search term: " + searchTerm);
    }
    
    @DataProvider(name = "searchData")
    public Object[][] getSearchData() {
        return new Object[][] {
            {"Selenium WebDriver", "selenium"},
            {"TestNG Framework", "testng"},
            {"Data Driven Testing", "testing"}
        };
    }
}
