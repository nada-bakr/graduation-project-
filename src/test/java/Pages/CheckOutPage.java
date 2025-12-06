package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckOutPage{
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement UpdateButton(){
        return driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]"));
    }
    public WebElement QuantityField(){
        return driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input"));
    }

    public void AssertUpdateMessage(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]/i")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=checkout/cart");
    }

    public  WebElement  RemoveButtonInShoppingCart(){
         return driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]"));
    }

    public void GuestCheckoutButton(){
        driver.findElement(By.xpath("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")).click();
    }

    public void CheckoutContinueButton(){
        driver.findElement(By.id("button-account")).click();
    }

    public void GuestFirstName(String GuestFN){
        driver.findElement(By.id("input-payment-firstname")).sendKeys(GuestFN);
    }

    public void GuestLastName(String GuestLn){
        driver.findElement(By.id("input-payment-lastname")).sendKeys(GuestLn);
    }

    public void GuestEmail(String GuestMail){
        driver.findElement(By.id("input-payment-email")).sendKeys(GuestMail);
    }

    public void GuestPhone(String GuestTele){
        driver.findElement(By.id("input-payment-telephone")).sendKeys(GuestTele);
    }

    public void GuestAddress(String GuestAddress1){
        driver.findElement(By.id("input-payment-address-1")).sendKeys(GuestAddress1);
    }

    public void GuestCity(String GuestCity1){
        driver.findElement(By.id("input-payment-city")).sendKeys(GuestCity1);
    }

    public void GuestPostal(String GuestPost){
        driver.findElement(By.id("input-payment-postcode")).sendKeys(GuestPost);
    }

    public void GuestCountry(){
        driver.findElement(By.id("input-payment-country")).click();
        driver.findElement(By.xpath("//*[@id=\"input-payment-country\"]/option[70]")).click();
    }

    public void GuestGovern(){
        driver.findElement(By.id("input-payment-zone")).click();
        driver.findElement(By.xpath("//*[@id=\"input-payment-zone\"]/option[2]")).click();
    }

    public void GuestPayContinueButton(){
        driver.findElement(By.id("button-guest")).click();
    }

    public void TermsCondition(){
        driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")).click();
    }

    public void FinalPayContinueButton(){
        driver.findElement(By.id("button-payment-method")).click();
    }

    public void AssertFailPayment(){
        Assert.assertTrue(driver.findElement(By.className("alert-dismissible")).isDisplayed());
    }
}