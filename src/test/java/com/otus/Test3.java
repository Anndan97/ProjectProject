/**
 * @author
 * Danilova A.A
 * @version v.1
 */
package com.otus;

import com.otus.page.EventsPage;
import com.otus.page.MainPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * This test checking work date of correct in page -
 * And check what all picture have status "DOD".
 */
public class Test3 extends BaseTest {

    @Test
    public void validateDod(){
        /**
         * On page MainPage we open site on URL, goes to Calendar Events page.
         */
        MainPage mainPage = new MainPage(driver);
        mainPage.openOtus();
        mainPage.goToCalendarEvents();
        /**
         * Find footer and chose "DOD".
         */
        EventsPage eventsPage = new EventsPage(driver);
        eventsPage.clickEventList();

        /**
         * Check date and time about all picture on page.
         */
        checkDate();

        /**
         * Check what all picture in page - DOD.
         */
        int count = eventsPage.countPicture(1,2);
        while (count != 0){
            String text = eventsPage.checkDOD(1);
            Assert.assertEquals("День открытых дверей", text);
            count--;
        }
        logger.info("Comparison DOD in page");
    }
}
