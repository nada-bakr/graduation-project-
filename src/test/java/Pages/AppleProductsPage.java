package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AppleProductsPage {
    WebDriver driver;

    public AppleProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void AppleBrandLink(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/ul[1]/li[1]/a")).click();
    }

    public void AssertAppleProducts(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=product/manufacturer/info&manufacturer_id=8");
    }

    public void FilterThePrice(){
        driver.findElement(By.id("input-sort")).click();
    }

    public void FilterPrice1(){
        driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[4]")).click();
    }

    public void AssertFilter1(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=product/manufacturer/info&manufacturer_id=8&sort=p.price&order=ASC");
    }

    public void FilterPrice2(){
        driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[5]")).click();
    }

    public void AssertFilterPrice2(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=product/manufacturer/info&manufacturer_id=8&sort=p.price&order=DESC");
    }


}
