package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ComparePage {
    WebDriver driver;

    public ComparePage(WebDriver driver) {
        this.driver = driver;
    }

    public void AssertProductExist(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=product/compare");
    }

    public void AddtoCartbutton(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody[4]/tr/td[2]/input")).click();
    }

    public void ShoppingCart(){
        driver.findElement(By.xpath("//*[@id=\"product-compare\"]/div[1]/a[2]")).click();
    }

}