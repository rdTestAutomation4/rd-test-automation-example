package com.rd.tests.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "src/main/java/com/rd/drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--ignore-certificate-errors");
        // options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
    }

    @Test
    public void PageTitleTest() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Google");
    }

    @Test
    public void SearchTest(){
        WebElement txaSearch = driver.findElement(By.name("q"));
        txaSearch.sendKeys("robotdreams");
        txaSearch.submit();
        WebElement divSearchResult = driver.findElement(By.cssSelector("div[data-async-context=\"query:robotdreams\"]"));
        Assert.assertTrue(divSearchResult.isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
