package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Sample data-driven test demonstrating Google search
 */
public class GoogleSearchTest extends BaseTest {
    
    @Test(dataProvider = "searchData")
    public void testGoogleSearch(String searchTerm, String expectedResult) {
        // Navigate to Google
        driver.get("https://www.google.com");
        
        // Handle cookie consent if present
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'accept') or contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'agree')]")
            ));
            acceptButton.click();
        } catch (Exception e) {
            // Cookie dialog not found or already accepted, continue
        }
        
        // Find search box and enter search term
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
        
        // Wait for page title to update
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Google")));
        
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
