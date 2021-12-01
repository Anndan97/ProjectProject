/**
 * @author
 * Danilova A.A
 * @version v.1
 */
package com.otus.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

/**
 * This class work in Calendar Events - https://otus.ru/events/near/
 */
public class EventsPage extends BasePage {
    /**
     * Inheritance driver from parent class.
     * @param driver
     */
    public EventsPage(WebDriver driver) {
        super(driver);
    }
    String eventList = "div.container.container-padding-top>section>header>div>div:nth-child(2)>div:nth-child(1)";
    String dod = "div.container.container-padding-top>section>header>div>div:nth-child(2)>div:nth-child(2)>a:nth-child(3)";
    Actions actions = new Actions(driver);

    /**
     * This method find on pade List and chose "DOD".
     */
    public void clickEventList(){
        WebElement buttonEvent = driver.findElement(By.cssSelector(eventList));
        actions.moveToElement(buttonEvent).click().build().perform();
        WebElement dodElement = driver.findElement(By.cssSelector(dod));
        actions.moveToElement(dodElement).click().build().perform();
        logger.info("DOD");
    }

    /**
     * This method goes over locator and get text, whatever to compare with sample.
     * @param startCount
     * @return
     */
    public String checkDOD(int startCount) {
        String locatorDOD = "div.js-dod-new-events-root>div:nth-child(3)>section>div:nth-child(2)>" +
                "a:nth-child(" + startCount + ")>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)";
        String text = driver.findElement(By.cssSelector(locatorDOD)).getText();
        return text;
    }

    /**
     * This method goes over locator and get date, whatever to compare with sample.
     * @param startCount
     * @return
     */
    public String checkDate(int startCount) {
        String locatorDate = "div.js-dod-new-events-root>div:nth-child(3)>section>div:nth-child(2)>" +
                "a:nth-child(" + startCount + ")>div:nth-child(1)>div:nth-child(5)>div:nth-child(1)>" +
                "span:nth-child(1)>span:nth-child(2)";
        String date = driver.findElement(By.cssSelector(locatorDate)).getText();
        return date;
    }

    /**
     * This method goes over locator and get time, whatever to compare with sample.
     * @param startCount
     * @return
     */
    public String checkTime(int startCount) {
        String locatorTime = "div.js-dod-new-events-root>div:nth-child(3)>section>div:nth-child(2)>" +
                "a:nth-child(" + startCount + ")>div:nth-child(1)>div:nth-child(5)>div:nth-child(1)>" +
                "span:nth-child(2)>span:nth-child(2)";
        String time = driver.findElement(By.cssSelector(locatorTime)).getText();
        return time;
    }
}
