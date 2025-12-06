package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
    }

    public void MyAccount(){

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
    }

    public void RegisterButton(){

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
    }

    public void FirstName(String First){

        driver.findElement(By.id("input-firstname")).sendKeys(First);
    }

    public void LastName(String Last){

        driver.findElement(By.id("input-lastname")).sendKeys(Last);
    }

    public void Email(String email){

        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void Mobile(String mobile){

        driver.findElement(By.id("input-telephone")).sendKeys("11111");
    }

    public void Password(String Pass){

        driver.findElement(By.id("input-password")).sendKeys(Pass);
    }

    public void ConfirmPassword(String Pass){

        driver.findElement(By.id("input-confirm")).sendKeys(Pass);
    }

    public void PrivacyPolicy(){

        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
    }

    public void ContinueButton(){

        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
    }

    public void ReturnHomePage(){

        driver.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]/a")).click();
    }

    public void AssertValidRegister(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=account/success");
    }

    public void AssertInvalidRegister(){
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }



}
