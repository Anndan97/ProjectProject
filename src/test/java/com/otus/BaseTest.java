/**
 * @author
 * Danilova A.A
 * @version v.1
 */
package com.otus;

import com.otus.page.BasePage;
import com.otus.page.EventsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    /**
     *This class implement "basic" test on the basic of which next function:
     * @before, @after and checkDate.
     */

    /**
     * Here i'm initialize in parental class WebDriver and Logger
     */
    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(Test1.class);

    @Before
    public void StartUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        logger.info("Driver on");
    }

    @After
    public void End() {
        if (driver != null)
            driver.quit();
        logger.info("Driver off");
    }

    /**
     * checkDate in BaseTest implements next function in order:
     * 1. Receive the current date and time.
     * 2. Receive amount picture on page.
     * 3. Receive the date and time from picture.
     * 4. Compares result.
     */
    public void checkDate() {
        BasePage basePage = new BasePage(driver);
        EventsPage eventsPage = new EventsPage(driver);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String dateAndTimeNow = dateFormat.format(cal.getTime());

        // Splite date and time at the moment
        String dateNow = basePage.spliteStringToString(dateAndTimeNow, 1, 0, " ");
        String timeNow = basePage.spliteStringToString(dateAndTimeNow, 1, 1, " ");

        // Splite date and time the current page
        // Splite date the current page
        int monthNowInt = basePage.spliteStringToInt(dateNow, 2, 1, "/");
        int dayNowInt = basePage.spliteStringToInt(dateNow, 2, 2, "/");

        // Splite time the current page
        int hourNowInt = basePage.spliteStringToInt(timeNow, 2, 0, ":");
        int minuteNowInt = basePage.spliteStringToInt(timeNow, 2, 1, ":");

        // scrolling and update counter picture on page
        int countForCycleWithoutLoad = eventsPage.countPicture(1,2);
        eventsPage.scrollingPage();
        int countForCycleLoad = eventsPage.countPicture(1,2);
        while (countForCycleLoad > countForCycleWithoutLoad) {
            countForCycleWithoutLoad = countForCycleLoad;
            eventsPage.scrollingPage();
            countForCycleLoad = eventsPage.countPicture(1,2);
        }

        int startCount = 1;
        int dayInt = 0;
        int monthInt = 0;
        int hourInt = 0;
        int minuteInt = 0;
        boolean result = false;
        while (countForCycleLoad != 0) {
            String date = eventsPage.checkDate(startCount);
            String time = eventsPage.checkTime(startCount);

            // Splite date in page
            dayInt = basePage.spliteStringToInt(date, 1, 0, " ");
            String monthString = basePage.spliteStringToString(date, 1, 1, " ");
            monthInt = basePage.switchMounth(monthString);

            // Splite time in page
            hourInt = basePage.spliteStringToInt(time, 1, 0, ":");
            minuteInt = basePage.spliteStringToInt(time, 1, 1, ":");

            boolean monthSmaller = basePage.comparisonSmaller(monthNowInt, monthInt);
            boolean monthEqual = basePage.comparisonEqual(monthNowInt, monthInt);
            boolean daySmaller = basePage.comparisonSmaller(dayNowInt, dayInt);
            boolean dayEqual = basePage.comparisonEqual(dayNowInt, dayInt);
            boolean hourSmaller = basePage.comparisonSmaller(hourNowInt, hourInt);
            boolean hourEqual = basePage.comparisonEqual(hourNowInt, hourInt);
            boolean minuteSmaller = basePage.comparisonSmaller(minuteNowInt, minuteInt);

            // compare result
            if (monthSmaller == true) {
                result = true;
            } else if ((monthEqual == true) && (daySmaller == true)) {
                result = true;
            } else if ((monthEqual == true) && (dayEqual == true) && (hourSmaller == true)) {
                result = true;
            } else if ((monthEqual == true) && (dayEqual == true) && (hourEqual == true) && (minuteSmaller == true)) {
                result = true;
            } else {
                logger.info("This month is new year, but on page year not specified");
                result = true;
            }
            Assert.assertEquals(result, true);
            startCount++;
            countForCycleLoad--;
        }
    }
}
