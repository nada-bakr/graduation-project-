package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    WebDriver driver ;
    WebDriverWait Wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void Wait(){
        Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'product/compare')]")));
    }

    public void Comparebutton(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[3]")).click();

    }

    public void Comparebutton2(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[3]")).click();
    }

    public void Comparebutton3(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[3]/button[3]")).click();
    }

    public void ComparisonPage(){

        driver.findElement(By.xpath("//a[contains(@href,'product/compare')]")).click();
    }

    public void AddtoWishListButton(){

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[2]")).click();
    }

    public void AddtoWishListButton2(){

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[2]")).click();
    }

    public void AddtoWishListButton3(){

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[3]/button[2]")).click();
    }

    public void WishListPage(){

        driver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]/a[2]")).click();
    }

    public void ProductListButton(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")).click();
    }

    public void ShowAllDesktopsButton(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")).click();
    }

    public void CurrencyButton(){

        driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/span")).click();
    }

    public void EuroButton(){

        driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button")).click();
    }

    public void AssertSwitchToEuro(){

        Assert.assertTrue(driver.findElement(By.className("price-new")).isDisplayed());
    }

    public void SearchField(String product){
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(product);
    }
    public void SearchIcon(){
        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
    }

    public void ProductApple(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a/img")).click();
    }

    public void AddtoCartButton(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]/span")).click();
    }

    public void ImageProduct(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a/img")).click();
    }

    public void MainCategory(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click();
    }

    public void SubCategory(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a")).click();
    }


    public void CheckoutButton(){

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a/span")).click();
    }

    public void DropdownListCategory(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).isDisplayed();
    }

    public void DeskTopButton(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")).click();
    }

    public void AllDeskTops(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")).click();
    }

    public void ComponentsButton(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click();
    }

    public void AllComponents(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/a")).click();
    }

    public void TabletsButton(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[4]/a")).click();
    }

    public void SoftwareButton(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[5]/a")).click();
    }

    public void PhonesPDAsButton(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[6]/a")).click();
    }

    public void CamerasButton(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[7]/a")).click();
    }

    public void MP3PlayersButton(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[8]/a")).click();
    }

    public void AllMP3Players(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[8]/div/a")).click();
    }

    public void ClickMacOnDesktopsCategory(){
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).click();
    }
}

