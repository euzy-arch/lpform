package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Переход на страницу с формой
            driver.get("https://www.testograf.ru/auth/login");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("https://www.testograf.ru/auth/login"));

            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//input[@name='email']")));
            emailField.sendKeys("ivan.ivanov@ivan.com");

            WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//input[@name='password']")));
            passField.sendKeys("123123");

            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable
                    (By.xpath("//div[@class='btnWrap___DLyoik1']")));
            submitButton.click();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();

        }
    }
}
