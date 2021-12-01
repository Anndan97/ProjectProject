/**
 * @author
 * Danilova A.A
 * @version v.1
 */
package com.otus.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *  This class work in Main Page - https://otus.ru/
 */
public class MainPage extends BasePage{
    /**
     * Inheritance driver from parent class.
     * @param driver
     */
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Raise actions and announce locator.
     */
    private final String URL = "https://otus.ru";
    private String buttonCourse = "//div[2]/div[1]/div[1]/p";
    private String buttonTesting = "//div[1]/div[2]/div[6]/a";
    private String buttonDevelopments = "//header[2]/div/div[2]/div[2]/div[1]/p";
    private String buttonCalenadOfEvents = "//header[2]/div/div[2]/div[2]/div[2]/a[2]";
    Actions actions = new Actions(driver);

    /**
     * This method open page on URL
     */
    public void openOtus(){
        driver.get(URL);
        driver.manage().window().maximize();
    }

    /**
     * This method work on footer.
     * Find "Testing" and click on.
     */
    public void goToTesting(){
        WebElement footerCourse = driver.findElement(By.xpath(buttonCourse));
        actions.moveToElement(footerCourse).build().perform();
        WebElement testing = driver.findElement(By.xpath(buttonTesting));
        actions.moveToElement(testing).click().build().perform();
        logger.info("Input on page Testing");
    }

    /**
     * This method work on footer.
     * Find "Calendar Events" and click on.
     */
    public void goToCalendarEvents(){
        WebElement footerDevelopment = driver.findElement(By.xpath(buttonDevelopments));
        actions.moveToElement(footerDevelopment).build().perform();
        WebElement events = driver.findElement(By.xpath(buttonCalenadOfEvents));
        actions.moveToElement(events).click().build().perform();
        logger.info("Input on page Calendar of Events");
    }

}
