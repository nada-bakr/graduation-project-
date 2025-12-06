package Tests;
import Pages.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import static Tests.Utils.takeScreenshot;


public class HomeTest{
    WebDriver driver;
    HomePage homePage_Obj;
    ComparePage comparePage_Obj;
    CheckOutPage checkOutPage_Obj;
    LoginPage loginPage_Obj;
    WishListPage wishListPage_Obj;
    RegisterPage registerPage_Obj;
    ForgetPassButtonPage forgetPassButtonPage_Obj;
    ProductListPage productListPage_Obj;
    SearchPage searchPage_Obj;
    AppleProductsPage appleProductsPage_Obj;
    CategoryPage categoryPage_Obj;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeMethod
    public void OpenBrowser(Method method){
        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());
        driver = new ChromeDriver();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
        homePage_Obj = new HomePage(driver);
        comparePage_Obj = new ComparePage(driver);
        checkOutPage_Obj = new CheckOutPage(driver);
        loginPage_Obj = new LoginPage(driver);
        wishListPage_Obj=new WishListPage(driver);
        registerPage_Obj = new RegisterPage(driver);
        forgetPassButtonPage_Obj = new ForgetPassButtonPage(driver);
        productListPage_Obj = new ProductListPage(driver);
        searchPage_Obj = new SearchPage(driver);
        appleProductsPage_Obj = new AppleProductsPage(driver);
        categoryPage_Obj = new CategoryPage(driver);
        driver.manage().window().maximize();
    }

    @Test (priority = 1)
    public void CompareButton() throws InterruptedException {
        test.info("Adding the product to comparison Page");
        homePage_Obj.Comparebutton();
        Thread.sleep(1000);
        homePage_Obj.ComparisonPage();
        comparePage_Obj.AssertProductExist();
        test.pass("The product was added");
    }

    @Test (priority = 2)
    public void AddMoreProductInComparison() throws InterruptedException {
        test.info("Adding more than one product to comparison Page");
        homePage_Obj.Comparebutton();
        homePage_Obj.Comparebutton2();
        homePage_Obj.Comparebutton3();
        Thread.sleep(1000);
        homePage_Obj.ComparisonPage();
        comparePage_Obj.AssertProductExist();
        test.pass("The products were added");
    }

    @Test (priority = 3)
    public void UpdateButton() throws InterruptedException {
        test.info("Price of product update");
        homePage_Obj.Comparebutton();
        Thread.sleep(1000);
        homePage_Obj.ComparisonPage();
        comparePage_Obj.AddtoCartbutton();
        Thread.sleep(1000);
        comparePage_Obj.ShoppingCart();
        checkOutPage_Obj.QuantityField().clear();
        checkOutPage_Obj.QuantityField().sendKeys("3");
        checkOutPage_Obj.UpdateButton().click();
        checkOutPage_Obj.AssertUpdateMessage();
        test.pass("Done");

    }

    @Test (priority = 4)
    public void AddtoWishListButton() throws InterruptedException {
        test.info("Adding the product to wishlist Page");
        loginPage_Obj.MyAccount();
        loginPage_Obj.LoginButton();
        loginPage_Obj.Username("abdulrhmanabdelhameed@gmail.com");
        loginPage_Obj.Password("Body54321@#");
        loginPage_Obj.SubmitButton();
        loginPage_Obj.ReturnHomePage();
        homePage_Obj.AddtoWishListButton();
        Thread.sleep(1000);
        homePage_Obj.WishListPage();
        wishListPage_Obj.AssertProductsExistInWishListPage();
        test.pass("Done");
    }

    @Test (priority = 5)
    public void AddMoreProductInWishList() throws InterruptedException {
        test.info("Adding more than one product to wishlist Page");
        loginPage_Obj.MyAccount();
        loginPage_Obj.LoginButton();
        loginPage_Obj.Username("abdulrhmanabdelhameed@gmail.com");
        loginPage_Obj.Password("Body54321@#");
        loginPage_Obj.SubmitButton();
        loginPage_Obj.ReturnHomePage();
        homePage_Obj.AddtoWishListButton();
        homePage_Obj.AddtoWishListButton2();
        homePage_Obj.AddtoWishListButton3();
        Thread.sleep(1000);
        homePage_Obj.WishListPage();
        wishListPage_Obj.AssertProductsExistInWishListPage();
        test.pass("Done");

    }

    @Test (priority = 6)
    public void ValidLogin(){
        test.info("Valid login");
        loginPage_Obj.MyAccount();
        loginPage_Obj.LoginButton();
        loginPage_Obj.Username("abdulrhmanabdelhameed@gmail.com");
        loginPage_Obj.Password("Body54321@#");
        loginPage_Obj.SubmitButton();
        loginPage_Obj.ReturnHomePage();
        loginPage_Obj.AssertValidLogin();
        test.pass("Done");

    }

    @Test (priority = 7)
    public void InvalidLogin()  {
        test.info("Invalid login");
        loginPage_Obj.MyAccount();
        loginPage_Obj.LoginButton();
        loginPage_Obj.Username("Invalid");
        loginPage_Obj.Password("Invalid");
        loginPage_Obj.SubmitButton();
        loginPage_Obj.AssertInvalidLogin();
        test.pass("Done");
    }

    @Test (priority = 8)
    public void ValidRegister(){
        test.info("Valid Register");
        registerPage_Obj.MyAccount();
        registerPage_Obj.RegisterButton();
        registerPage_Obj.FirstName("Mohammed");
        registerPage_Obj.LastName("Elsharkawy");
        registerPage_Obj.Email("me272220549445@gmail.com");
        registerPage_Obj.Mobile("01094037023");
        registerPage_Obj.Password("Mm2072005*#*");
        registerPage_Obj.ConfirmPassword("Mm2072005*#*");
        registerPage_Obj.PrivacyPolicy();
        registerPage_Obj.ContinueButton();
        registerPage_Obj.AssertValidRegister();
        test.pass("Done");
    }

    @Test (priority = 9)
    public void InValidRegister(){
        test.info("InValid Register");
        registerPage_Obj.MyAccount();
        registerPage_Obj.RegisterButton();
        registerPage_Obj.FirstName("Mohammed");
        registerPage_Obj.LastName("Elsharkawy");
        registerPage_Obj.Email("me2722205@gmail.com");
        registerPage_Obj.Mobile("01094037023");
        registerPage_Obj.Password("invalid");
        registerPage_Obj.ConfirmPassword("invalid");
        registerPage_Obj.PrivacyPolicy();
        registerPage_Obj.ContinueButton();
        registerPage_Obj.AssertInvalidRegister();
        test.pass("Done");
    }

    @Test (priority = 10)
    public void ForgetPass() {
        test.info("Forget pass button is valid");
        forgetPassButtonPage_Obj.MyAccount();
        forgetPassButtonPage_Obj.LoginButton();
        forgetPassButtonPage_Obj.ForgetPassButton();
        forgetPassButtonPage_Obj.Email("me27222055@gmail.com");
        forgetPassButtonPage_Obj.ContinueButton();
        forgetPassButtonPage_Obj.AssertForgetPass();
        test.pass("Done");
    }

    @Test(priority = 11)
    public void SortingByName(){
        test.info("The products is sorting by name");
        homePage_Obj.ProductListButton();
        homePage_Obj.ShowAllDesktopsButton();
        productListPage_Obj.SortButton();
        productListPage_Obj.NameAtoZ();
        productListPage_Obj.AssertSorting();
        test.pass("Done");
    }

    @Test(priority = 12)
    public void RatingHigh_Low(){
        test.info("The products is sorting by rating");
        homePage_Obj.ProductListButton();
        homePage_Obj.ShowAllDesktopsButton();
        productListPage_Obj.SortButton();
        productListPage_Obj.RatingHigh();
        productListPage_Obj.AssertRatingHigh();
        productListPage_Obj.SortButton();
        productListPage_Obj.RatingLow();
        productListPage_Obj.AssertRatingLow();
        test.pass("Done");

    }

    @Test(priority = 13)
    public void SortingPrice(){
        test.info("The products is sorting by price");
        homePage_Obj.ProductListButton();
        homePage_Obj.ShowAllDesktopsButton();
        productListPage_Obj.SortButton();
        productListPage_Obj.PriceLowHigh();
        productListPage_Obj.AssertPriceLowHigh();
        productListPage_Obj.SortButton();
        productListPage_Obj.PriceHighLow();
        productListPage_Obj.AssertPriceHighLow();
        test.pass("Done");
    }

    @Test(priority = 14)
    public void GridToList_ListToGrid(){
        test.info("Switching between grid and list");
        homePage_Obj.ProductListButton();
        homePage_Obj.ShowAllDesktopsButton();
        productListPage_Obj.GridToList();
        productListPage_Obj.AssertGridToList();
        productListPage_Obj.ListToGrid();
        productListPage_Obj.AssertListToGrid();
        test.pass("Done");
    }

    @Test(priority = 15)
    public void SwitchToEuro() {
        test.info("Switching from USD to Euro");
        homePage_Obj.CurrencyButton();
        homePage_Obj.EuroButton();
        homePage_Obj.AssertSwitchToEuro();
        test.pass("Done");
    }

    @Test(priority = 16)
    public void SearchField(){
        test.info("The search field is active");
        homePage_Obj.SearchField("macbook");
        homePage_Obj.SearchIcon();
        searchPage_Obj.AssertSearchDone();
        test.pass("Done");
    }

    @Test(priority = 17)
    public void CategoriesSection(){
        test.info("Selecting and applying different category is clickable");
        homePage_Obj.SearchField("macbook");
        homePage_Obj.SearchIcon();
        searchPage_Obj.CategoriesField();
        searchPage_Obj.DesktopsCategory();
        searchPage_Obj.SearchButton();
        test.pass("Done");
    }

    @Test(priority = 18)
    public void ComponentFailed(){
        test.info("Search results is matching the search inputs");
        homePage_Obj.SearchField("monitors");
        homePage_Obj.SearchIcon();
        searchPage_Obj.CategoriesField();
        searchPage_Obj.ComponentsCategory();
        searchPage_Obj.SearchButton();
        searchPage_Obj.AssertTheFailed();
        test.pass("Done");
    }

    @Test(priority = 19)
    public void Manufacturer(){
        test.info("The products filtering by manufacturer is working correctly");
        homePage_Obj.ProductApple();
        appleProductsPage_Obj.AppleBrandLink();
        appleProductsPage_Obj.AssertAppleProducts();
        test.pass("Done");
    }

    @Test(priority = 20)
    public void PriceFilter() throws InterruptedException {
        test.info("The products filtering by price is working correctly");
        homePage_Obj.ProductApple();
        appleProductsPage_Obj.AppleBrandLink();
        appleProductsPage_Obj.FilterThePrice();
        appleProductsPage_Obj.FilterPrice1();
        appleProductsPage_Obj.AssertFilter1();
        Thread.sleep(1000);
        appleProductsPage_Obj.FilterThePrice();
        appleProductsPage_Obj.FilterPrice2();
        appleProductsPage_Obj.AssertFilterPrice2();
        test.pass("Done");
    }



    @Test(priority = 21)
    public void AddtoCartButton(){
        test.info("Add to cart button is clickable");
        homePage_Obj.AddtoCartButton();
        test.pass("Done");
    }

    @Test(priority = 22)
    public void ProductMatched(){
        test.info("The product page match the chosen product");
        homePage_Obj.ImageProduct();
        productListPage_Obj.AssertProductMatchImage();
        test.pass("Done");
    }

    @Test(priority = 23)
    public void ReviewSuccessFully() {
        test.info("Adding new review");
        homePage_Obj.ImageProduct();
        productListPage_Obj.ReviewButton();
        productListPage_Obj.FirstName("Ganna");
        productListPage_Obj.YourReview("Your Product is very good and wow");
        productListPage_Obj.YourRating();
        productListPage_Obj.ReviewContinueButton();
        productListPage_Obj.AssertReviewSuccessfully();
        test.pass("Done");
    }

    @Test(priority = 24)
    public void RandomCategory() {
        test.info("Select name and subcategory");
        homePage_Obj.MainCategory();
        homePage_Obj.SubCategory();
        categoryPage_Obj.AssertRandomCategory();
        test.pass("Done");
    }

    @Test(priority = 25)
    public void FailOrderPayment() throws InterruptedException {
        test.info("Create order with payment");
        homePage_Obj.AddtoCartButton();
        homePage_Obj.CheckoutButton();
        Thread.sleep(1000);
        checkOutPage_Obj.GuestCheckoutButton();
        checkOutPage_Obj.CheckoutContinueButton();
        Thread.sleep(1000);
        checkOutPage_Obj.GuestFirstName("Abdulrhman");
        checkOutPage_Obj.GuestLastName("Abdelhameed");
        checkOutPage_Obj.GuestEmail("Abdoo@gmail.com");
        checkOutPage_Obj.GuestPhone("123456789");
        checkOutPage_Obj.GuestAddress("Mansoura");
        checkOutPage_Obj.GuestCity("Aga");
        checkOutPage_Obj.GuestPostal("12345");
        checkOutPage_Obj.GuestCountry();
        Thread.sleep(1000);
        checkOutPage_Obj.GuestGovern();
        checkOutPage_Obj.GuestPayContinueButton();
        Thread.sleep(2000);
        checkOutPage_Obj.TermsCondition();
        checkOutPage_Obj.FinalPayContinueButton();
        checkOutPage_Obj.AssertFailPayment();
        test.pass("Done");
    }

    @Test(priority = 26)
    public void HoverCategory(){
        test.info("Shows the correct subcategory a drop down list");
        homePage_Obj.MainCategory();
        homePage_Obj.DropdownListCategory();
        test.pass("Done");
    }

    @Test(priority = 27)
    public void AddToCartButton(){
        test.info("Adding product to cart");
        homePage_Obj.ImageProduct();
        productListPage_Obj.AddToCartButton();
        productListPage_Obj.AssertAddToCartMessage();
        test.pass("Done");
    }

    @Test(priority = 28)
    public void DetailsProduct(){
        test.info("Checking the correct product details");
        homePage_Obj.DeskTopButton();
        homePage_Obj.ClickMacOnDesktopsCategory();
        productListPage_Obj.Click_Imac();
        test.pass("Done");
    }

    @Test(priority = 29)
    public void SwitchImage() {
        test.info("Switching the product images");
        homePage_Obj.ImageProduct();
        productListPage_Obj.ClickImage();
        productListPage_Obj.ClickLeftArrow();
        productListPage_Obj.ClickRightArrow();
        test.pass("Done");
    }

    @Test(priority = 30)
    public void CategoriesPages() {
        test.info("Checking the correct category page");
        homePage_Obj.DeskTopButton();
        homePage_Obj.AllDeskTops();
        homePage_Obj.ComponentsButton();
        homePage_Obj.AllComponents();
        homePage_Obj.TabletsButton();
        homePage_Obj.SoftwareButton();
        homePage_Obj.PhonesPDAsButton();
        homePage_Obj.CamerasButton();
        homePage_Obj.MP3PlayersButton();
        homePage_Obj.AllMP3Players();
        test.pass("Done");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {


        String screenshotPath = takeScreenshot(result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed Successfully", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        extent.flush();

        Thread.sleep(2000);
        driver.quit();
    }

    public String takeScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String relativePath = "Screenshots/" + testName + ".png";
        String absolutePath = System.getProperty("user.dir") + "/" + relativePath;

        File destination = new File(absolutePath);
        destination.getParentFile().mkdirs();

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return relativePath;
    }
}