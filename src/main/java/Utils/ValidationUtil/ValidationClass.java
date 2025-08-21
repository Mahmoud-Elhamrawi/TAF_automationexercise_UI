package Utils.ValidationUtil;

import org.testng.Assert;

public class ValidationClass {

    /// hard assertation
    //assert on url
    public static void assertUrl(String actualUrl, String expectedUrl, String message) {
        Assert.assertEquals(actualUrl, expectedUrl, message);
    }

    //assert on text
    public static void assertText(String actualText, String expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }

    //assert on title
    public static void assertTitle(String actualTitle, String expectedTitle, String message) {
        Assert.assertEquals(actualTitle, expectedTitle, message);
    }

    //assert on visibility
    public static void assertVisibility(boolean condition, String message) {
        Assert.assertTrue(condition);
    }


    ///soft assertation


}
