/**
 * @author
 * Danilova A.A
 * @version v.1
 */
package com.otus;

import com.otus.page.MainPage;
import com.otus.page.RandomPage;
import com.otus.page.TestingPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * This test check heading, description and duration random picture on page Testing.
 */
public class Test2 extends BaseTest{

    @Test
    public void clickPicture(){
        /**
         * On page MainPage we open site on URL, goes to Testing page.
         */
        MainPage mainPage = new MainPage(driver);
        mainPage.openOtus();
        mainPage.goToTesting();

        /**
         * Receive count picture on testing page.
         * Chose random picture and click on.
         */
        TestingPage testingPage = new TestingPage(driver);
        int countPicture = testingPage.countPicture(1,1);
        int randomPageNow = testingPage.generateRandom(countPicture);
        testingPage.clickRandomPicture(randomPageNow);

        /**
         * Receive on random page parameter: heading, description, duration.
         */
        RandomPage randomPage = new RandomPage(driver);
        boolean headle = randomPage.headle(randomPageNow);
        boolean description = randomPage.description(randomPageNow);
        boolean duration = randomPage.duration(randomPageNow);

        /**
         * Block examinations.
         * What expected and actual value is equal.
         * In current case it is just the presence heading, description, duration.
         */
        Assert.assertEquals(true, headle);
        Assert.assertEquals(true, description);
        Assert.assertEquals(true, duration);
    }

}
