package com.rd.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // ChromeDriver yolunu ayarlayın
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/rd/drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--ignore-certificate-errors");
        // options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        // Page Load Timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/buttons");
    }

    @Test(priority = 0)
    public void testPageTitleShown(){
        WebElement pageTitle = driver.findElement(By.tagName("h1"));

        Assert.assertTrue(pageTitle.isDisplayed());
        Assert.assertEquals(pageTitle.getText(), "Buttons");
    }

    @Test(priority = 1)
    public void demoButtonClickTest() {

        WebElement btnClick = driver.findElement(By.xpath("//button[text()=\"Click Me\"]"));
        btnClick.click();

        // WebElement btnDoubleClick =  driver.findElement(By.className("btn-primary"));
//        new Actions(driver)
//                .doubleClick(btnDoubleClick)
//                .perform();

        WebElement result = driver.findElement(By.id("dynamicClickMessage"));

//                wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.id("dynamicClickMessage")));
        Assert.assertTrue(result.isDisplayed());
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
