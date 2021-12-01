/**
 * @author
 * Danilova A.A
 * @version v.1
 */
package com.otus;

import com.otus.page.MainPage;
import org.junit.Test;

/**
 * This test checking work date of correct in page -
 */
public class Test4 extends BaseTest {

    @Test
    public void validateDate() {
        /**
         * On page MainPage we open site on URL, goes to Calendar Events page.
         */
        MainPage mainPage = new MainPage(driver);
        mainPage.openOtus();
        mainPage.goToCalendarEvents();

        /**
         * Check date and time about all picture on page.
         */
        checkDate();

    }
}
