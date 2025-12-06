package Pages;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WishListPage {
    WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void AssertProductsExistInWishListPage(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=account/wishlist");
    }

}
