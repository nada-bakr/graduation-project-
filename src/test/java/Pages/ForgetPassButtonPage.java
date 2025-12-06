package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForgetPassButtonPage {
    WebDriver driver;

    public ForgetPassButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void MyAccount(){
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
    }

    public void LoginButton(){
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
    }

    public void ForgetPassButton(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")).click();
    }

    public void Email(String email){
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void ContinueButton(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
    }

    public void AssertForgetPass(){
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=account/login");
    }
}
