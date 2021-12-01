/**
 * @author
 * Danilova A.A
 * @version v.1
 */
package com.otus.page;

import com.otus.Test1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * This class realized base page which function are the same regardless of page.
 * Count Picture, ScrollingPage, Comparison values, splite string.
 */
public class BasePage {
    protected WebDriver driver;

    /**
     * Announce driver and logger in parent class for pages.
     * @param driver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected Logger logger = LogManager.getLogger(Test1.class);

    /**
     * This method count picture on different pages.
     * First case count picture on page testing.
     * Second case count picture on Calendar Events page.
     * Return count.
     * @param startCount
     * @param numberlocator
     * @return
     */
    public int countPicture(int startCount, int numberlocator) {
        int countPicture = 0;
        String pictureLocator = null;
        switch (numberlocator) {
            case (1):
                logger.info(numberlocator + " switch BasePage");
                try {
                    while (true) {
                        pictureLocator = "div.container-lessons:nth-child(3)>div:nth-child(1)>div:nth-child(1)>" +
                                "a:nth-child(" + startCount + ")";
                        driver.findElement(By.cssSelector(pictureLocator));
                        countPicture++;
                        startCount++;
                    }
                } catch (RuntimeException e) {
                    logger.info("EXIT TO EXCEPTION");
                }
            break;
            case (2):
                logger.info(numberlocator + " switch BasePage");
                try {
                    while (true) {
                        pictureLocator = "div.dod_new-events__list>a:nth-child(" + startCount + ")";
                        driver.findElement(By.cssSelector(pictureLocator));
                        countPicture++;
                        startCount++;
                    }
                } catch (RuntimeException e) {
                    logger.info("EXIT TO EXCEPTION");
                }
            break;
            default:
                logger.info("NOT LOCATOR");
                break;
        }
        return countPicture;
    }

    /**
     * This method scroll page on 4000 pixel.
     */
    public void scrollingPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(4000,4000)");
    }

    /**
     * This method compare two value on Smaller.
     * @param valueNow
     * @param valuePage
     * @return
     */
    public boolean comparisonSmaller (int valueNow, int valuePage){
        boolean result = false;
        if (valueNow < valuePage){
            result = true;
        }
        return result;
    }

    /**
     * This method compare two value on equal.
     * @param valueNow
     * @param valuePage
     * @return
     */
    public boolean comparisonEqual (int valueNow, int valuePage){
        boolean result = false;
        if (valueNow == valuePage){
            result = true;
        }
        return result;
    }

    /**
     * This method receive parameter for split string.
     * Split string and parse to Integer result.
     * @param stringSplite
     * @param lengthSplite
     * @param numberWordsInString
     * @param delimetr
     * @return
     */
    public int spliteStringToInt (String stringSplite, int lengthSplite, int numberWordsInString, String delimetr){
        String[] words = stringSplite.split(delimetr);
        String valueSplite = null;
        int valueInt = 0;
        for(int j=0; j<words.length-lengthSplite; j++){
            valueSplite = words[numberWordsInString];
            valueInt = Integer.parseInt(valueSplite);
        }
        return valueInt;
    }

    /**
     * This method receive parameter for split string.
     * Split string and return result.
     * @param stringSplite
     * @param lengthSplite
     * @param numberWordsInString
     * @param delimetr
     * @return
     */
    public String spliteStringToString (String stringSplite, int lengthSplite, int numberWordsInString, String delimetr){
        String[] words = stringSplite.split(delimetr);
        String valueSplite = null;
        for(int j=0; j<words.length-lengthSplite; j++){
            valueSplite = words[numberWordsInString];
        }
        return valueSplite;
    }

    /**
     * This method translate month letters to number value.
     * @param monthString
     * @return
     */
    public int switchMounth(String monthString){
        switch (monthString){
            case "января":
                monthString = "1";
                break;
            case "февраля":
                monthString = "2";
                break;
            case "марта":
                monthString = "3";
                break;
            case "апреля":
                monthString = "4";
                break;
            case "мая":
                monthString = "5";
                break;
            case "июня":
                monthString = "6";
                break;
            case "июля":
                monthString = "7";
                break;
            case "августа":
                monthString = "8";
                break;
            case "сентября":
                monthString = "9";
                break;
            case "октября":
                monthString = "10";
                break;
            case "ноября":
                monthString = "11";
                break;
            case "декабря":
                monthString = "12";
                break;
        }
        int monthInt = Integer.parseInt(monthString);
        return monthInt;
    }
}
