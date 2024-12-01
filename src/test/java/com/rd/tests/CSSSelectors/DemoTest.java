package com.rd.tests.CSSSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DemoTest {
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
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    public void PageTitleTest() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "DEMOQA");
    }

    @Test
    public void FormSubmit() {
        WebElement txtUsername = driver.findElement(By.cssSelector("input[id='userName'][type='text']"));
        txtUsername.sendKeys("serkancura");

    /*    List<WebElement> liList = driver.findElements(By.cssSelector("li[id^='item']"));

        for (WebElement element : liList ){
            System.out.println(element.getText());
        }
*/
        List<WebElement> divList = driver.findElements(By.cssSelector("div[class$='group']"));

        for (WebElement element : divList ){
            System.out.println(element.getText());
        }


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
