package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {

        this.driver = driver;
    }

    public void AssertSearchDone(){

        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed());
    }

    public void CategoriesField(){

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/select")).click();
    }

    public void DesktopsCategory(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/select/option[2]")).click();
    }

    public void ComponentsCategory(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/select/option[8]")).click();
    }

    public void AssertTheFailed(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).isDisplayed());
    }

    public void SearchButton(){
        driver.findElement(By.id("button-search")).click();
    }


}