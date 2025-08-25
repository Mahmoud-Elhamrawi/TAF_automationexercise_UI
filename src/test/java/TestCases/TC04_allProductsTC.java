package TestCases;

import Pages.P01_LandingPage;
import Pages.P06_AllProductsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Utils.DataUtil.ReadPropertiesFiles.getProperty;

@Listeners(TestNGListener.TestNGListen.class)
public class TC04_allProductsTC extends TestBase {


    @Test
    public void verifyAllProductPage() {
        new P01_LandingPage(driver)
                .validateHomePage(getProperty("HomeItem"));
        new P06_AllProductsPage(driver)
                .clickOnProductButton()
                .validateAllProductsPage(getProperty("AllProductsItem"))
                .selectFirstProduct()
                .validateItemDetails(getProperty("ItemPrice"), getProperty("ItemName"), getProperty("ItemCategory"), getProperty("ItemAvailability"), getProperty("ItemCondition"), getProperty("ItemBrand"));


    }


}
