package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void MyAccount(){

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
    }

    public void LoginButton(){

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
    }

    public void Username(String User){

        driver.findElement(By.id("input-email")).sendKeys(User);
    }

    public void Password(String Password){
        driver.findElement(By.id("input-password")).sendKeys(Password);
    }

    public void SubmitButton(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
    }

    public void AssertValidLogin(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=common/home");
    }

    public void AssertInvalidLogin(){
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }


    public void ReturnHomePage(){
        driver.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]/a")).click();
    }
}