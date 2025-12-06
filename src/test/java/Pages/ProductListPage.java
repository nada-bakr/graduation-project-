package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductListPage {
    WebDriver driver;

    public ProductListPage(WebDriver driver) {

        this.driver = driver;
    }

    public void SortButton(){

        driver.findElement(By.id("input-sort")).click();
    }

    public void NameAtoZ(){

        driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[2]")).click();
    }

    public void AssertSorting (){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=product/category&path=20&sort=pd.name&order=ASC");
    }

    public void RatingHigh(){
        driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[6]")).click();
    }

    public void AssertRatingHigh(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=product/category&path=20&sort=rating&order=DESC");
    }

    public void RatingLow(){
        driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[7]")).click();
    }

    public void AssertRatingLow(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=product/category&path=20&sort=rating&order=ASC");
    }

    public void PriceLowHigh(){
        driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[4]")).click();
    }

    public void AssertPriceLowHigh(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=product/category&path=20&sort=p.price&order=ASC");
    }

    public void PriceHighLow(){
        driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[5]")).click();
    }

    public void AssertPriceHighLow(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=product/category&path=20&sort=p.price&order=DESC");
    }

    public void GridToList(){
        driver.findElement(By.xpath("//*[@id=\"list-view\"]/i")).click();
    }

    public void AssertGridToList(){

        Assert.assertTrue(driver.findElement(By.xpath("/html/body")).isDisplayed());
    }

    public void ListToGrid(){

        driver.findElement(By.xpath("//*[@id=\"grid-view\"]")).click();
    }

    public void AssertListToGrid(){

        Assert.assertTrue(driver.findElement(By.xpath("/html/body")).isDisplayed());
    }

    public void AssertProductMatchImage(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/h1")).isDisplayed());
    }

    public void ReviewButton(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[3]/a")).click();
    }

    public void FirstName(String FN){
        driver.findElement(By.id("input-name")).sendKeys(FN);
    }

    public void YourReview(String Reivew){
        driver.findElement(By.id("input-review")).sendKeys(Reivew);
    }

    public void YourRating(){
        driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input[3]")).click();
    }

    public void ReviewContinueButton(){
        driver.findElement(By.id("button-review")).click();
    }

    public void AssertReviewSuccessfully(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[2]")).isDisplayed());
    }

    public void AddToCartButton(){
        driver.findElement(By.id("button-cart")).click();
    }
    public void AssertAddToCartMessage(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).isDisplayed());
    }

    public void ClickImage(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[1]/li[3]/a/img")).click();
    }

    public void ClickLeftArrow(){
        driver.findElement(By.xpath("/html/body/div[2]/div/button[1]")).click();
    }

    public void ClickRightArrow(){
        driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
    }

    public void Click_Imac(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/a/img")).click();
    }



}


