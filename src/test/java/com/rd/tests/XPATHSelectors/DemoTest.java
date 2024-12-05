package com.rd.tests.XPATHSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DemoTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/rd/drivers/chromedriver");

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
    public void dynamicElementTest(){
        List<WebElement> elementList = driver.findElements(By.xpath("//form[@id='userForm']//label"));

        for (WebElement element : elementList) {
            String elementId = element.getAttribute("id");
            WebElement dynamicElement = driver.findElement(By.xpath("//*[@id='" + elementId + "']"));
            WebElement dynamicCSSElement = driver.findElement(By.cssSelector("#"+elementId));
            System.out.println(dynamicElement.getText());
            System.out.println(dynamicCSSElement.getText());
        }

    }
}
