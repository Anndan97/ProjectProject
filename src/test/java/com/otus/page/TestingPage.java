/**
 * @author
 * Danilova A.A
 * @version v.1
 */
package com.otus.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is testing Page - https://otus.ru/categories/testing/
 */
public class TestingPage extends BasePage {
    /**
     * Inheritance driver from parent class.
     * @param driver
     */
    public TestingPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Raise wait, JS and action.
     */
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 6);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    /**
     * This method receive locator "amount course" on page and return text in locator.
     * @return
     */
    public String getActualCountCourse() {
        String actuialCountCourse = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div";
        String actualCountCourseGet = driver.findElement(By.xpath(actuialCountCourse)).getText();
        return actualCountCourseGet;
    }

    /**
     * This method generate random number from 1 to countPicture on Page.
     * @return
     */
    public int generateRandom(int count) {
        int a = 0; // Начальное значение диапазона - "от"
        int random_number = a + (int) (Math.random() * count);
        return random_number;
    }

    /**
     * This method clicks on picture course with chose Random method.
     * If picture not visible then wait.
     * Because 1-3 picture appear on border then click not stable, therefore i'm scroll page.
     * @param countPicrure
     */
    public void clickRandomPicture(int countPicrure){

        String pictureCount = "div.container-lessons:nth-child(3)>div:nth-child(1)>div:nth-child(1)>a:nth-child("
                + countPicrure + ")";

        if (countPicrure == 1||countPicrure == 2|| countPicrure == 3){
            js.executeScript("javascript:window.scrollBy(200,200)");
            WebElement select = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(pictureCount)));
            actions.moveToElement(select).click().build().perform();}
        else{
            WebElement select = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(pictureCount)));
            actions.moveToElement(select).click().build().perform();}
            logger.info("Find picture Course");
    }
}
