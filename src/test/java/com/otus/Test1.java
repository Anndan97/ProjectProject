/**
 * @author
 * Danilova A.A
 * @version v.1
 */
package com.otus;

import com.otus.page.MainPage;
import com.otus.page.TestingPage;
import org.junit.Assert;
import org.junit.Test;

public class Test1 extends BaseTest{

    @Test
    public void iconTest(){
        /**
         * On page MainPage we open site on URL, goes to Testing page.
         */
        MainPage mainPage = new MainPage(driver);
        mainPage.openOtus();
        mainPage.goToTesting();

        /**
         * Receive on testing page count amount course and count course on page.
         */
        TestingPage testingPage = new TestingPage(driver);
        int actualText = testingPage.spliteStringToInt(testingPage.getActualCountCourse(), 1,1," ");
        logger.info(actualText + " actual count course in page");
        int actualCountPicture = testingPage.countPicture(1,1);
        logger.info(actualCountPicture + " countPicture on BasePage");

        /**
         * Block examinations.
         * What expected and actual value is equal.
         */
        Assert.assertEquals("Picture on page Testing", actualText, actualCountPicture);
    }

}
