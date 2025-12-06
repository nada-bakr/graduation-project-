package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoryPage {
    WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void AssertRandomCategory(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-category\"]/ul/li[3]/a")).isDisplayed());
    }


}