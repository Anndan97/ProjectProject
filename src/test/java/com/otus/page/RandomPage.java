/**
 * @author
 * Danilova A.A
 * @version v.1
 */
package com.otus.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class work in random page which was chosen later in TestingPage in Test2
 */
public class RandomPage extends BasePage{
    /**
     * Inheritance driver from parent class.
     * @param driver
     */
    public RandomPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Raise wait and var locator for heading - headle, description - descriptionLocatorVar,
     * duration - durationLocation because on otus this position has different locator!
     * This is terribly... No automation...
     */
    WebDriverWait wait = new WebDriverWait(driver,3);
    // because title about course have different locator
    String haedleCourse = "//h1[@class='course-header2__title']";
    String headleCourseDiv = "//div[@class='course-header2__title']";
    String headleCourseImg = "//img[@class='tn-atom__img']";
    String headleCourseDivFinal = "//div[@class='preparatory-intro__title']";

    String descriptionLocatorVar1 = "//h1[@class='course-header2__subtitle']";
    String descriptionLocatorVar2 = "//div[@class='course-header2__admin-text']";
    String descriptionLocatorVar3 = "//div[@field='tn_text_1613568032880']";
    String descriptionLocatorVar4 = "div.preparatory-intro__list";

    String durationLocator = "div.container__col_12>div:nth-child(1)>div:nth-child(1)" +
            ">div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>p";
    String durationLocalorCourse6 = "body.t-body>div:nth-child(1)>div:nth-child(4)>div:nth-child(2)>" +
            "div:nth-child(1)>div:nth-child(9)>div:nth-child(1)";


    /**
     * This method wait loader page and find heading and result his text.
     * @param randomPageNow
     * @return
     */
    public boolean headle(int randomPageNow) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(haedleCourse)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(headleCourseDiv)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(headleCourseDivFinal)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(headleCourseImg)));

        boolean finalHeadle = false;
        switch (randomPageNow) {
            case (1):
            case (2):
            case (7):
            case (10):
                String headle = driver.findElement(By.xpath(haedleCourse)).getText();
                logger.info(headle + " headle");
                finalHeadle = value(headle);
                break;
            case (3):
            case (4):
            case (6):
            case (8):
            case (9):
                String headle_2 = driver.findElement(By.xpath(headleCourseDiv)).getText();
                logger.info(headle_2 + " headle");
                finalHeadle = value(headle_2);
                break;
            case (5):
                String headle_3 = driver.findElement(By.xpath(headleCourseImg)).getText();
                logger.info(headle_3 + " headle");
                finalHeadle = value(headle_3);
                break;
            case (11):
                String headle_4 = driver.findElement(By.xpath(headleCourseDivFinal)).getText();
                logger.info(headle_4 + " headle");
                finalHeadle = value(headle_4);
                break;
        }
        return finalHeadle;
    }

    /**
     * This method find description and result his text.
     * @param randomPageNow
     * @return
     */
    public boolean description(int randomPageNow){
        boolean finalDecrtiption = false;
        switch (randomPageNow) {
            case (1):
            case (2):
            case (3):
            case (7):
            case (8):
            case (10):
                String description = driver.findElement(By.xpath(descriptionLocatorVar2)).getText();
                logger.info(description + " description");
                finalDecrtiption = value(description);
                break;
            case (11):
                String description2 = driver.findElement(By.cssSelector(descriptionLocatorVar4)).getText();
                logger.info(description2 + " description");
                finalDecrtiption = value(description2);
                break;
            case (4):
            case (6):
                String description3 = driver.findElement
                        (By.xpath(descriptionLocatorVar2)).getText();
                String description3_1 = driver.findElement(By.xpath(descriptionLocatorVar1)).getText();
                logger.info(description3 + description3_1 + " description");
                finalDecrtiption = value(description3)||value(description3_1);
                break;
            case (5):
                String description_6 = driver.findElement(By.xpath(descriptionLocatorVar3)).getText();
                logger.info(description_6 + " description");
                finalDecrtiption = value(description_6);
                break;
            case (9):
                String description_79 = driver.findElement(By.xpath(descriptionLocatorVar1)).getText();
                logger.info(description_79 + " description");
                finalDecrtiption = value(description_79);
                break;

        }
        return finalDecrtiption;
    }

    /**
     * This method find duration and result his amount.
     * @param randomPageNow
     * @return
     */
    public boolean duration(int randomPageNow) {
        boolean finalDuration = false;
        switch (randomPageNow) {
            case (1):
            case (6):
            case (7):
            case (8):
            case (9):
            case (10):
                String description = driver.findElement(By.cssSelector(durationLocator)).getText();
                logger.info(description + " duration");
                finalDuration = value(description);
                break;
            case (2):
                String description_2 = driver.findElement(By.cssSelector(durationLocator)).getText();
                logger.info(description_2 + " duration");
                finalDuration = value(description_2);
                break;
            case (3):
            case (4):
                String description3And4 = driver.findElement(By.cssSelector(durationLocator)).getText();
                logger.info(description3And4 + " duration");
                finalDuration = value(description3And4);
                break;
            case (5):
                String description_6 = driver.findElement(By.cssSelector(durationLocalorCourse6)).getText();
                logger.info(description_6 + " duration");
                finalDuration = value(description_6);
                break;
            case (11): //not time in page
                finalDuration = true;
                logger.info("not time in page");
                break;
        }
        return finalDuration;
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean value(String value) {
        if (value != null){
            return true;}
        return false;
    }
}
