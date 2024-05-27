package br.com.sandes.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUtils {

    private WebDriver driver = new ChromeDriver();

    public TestUtils(WebDriver driver){
        this.driver = driver;
    }

    public void searchForProduct(String productName){
        driver.findElement(By.id("searchProduct")).sendKeys(productName);

        driver.findElement(By.xpath("//span[@data-testid='search-product-hyperlink']")).click();

    }

    public void closeCookiesModal(){
        driver.findElement(By.xpath(
                "//aside/button[@data-cy='button-close-modal-cookie']"))
                .click();
    }

    public void addToCart(){
        driver.findElement(By.xpath(
                "//div[@data-cy='box-product-box-buttons']/button[@data-testid='button-cart']"))
                .click();
    }

    public void selectProduct(String productName){
        driver.findElement(By.xpath(
                "//div[@data-cy='product-card-info-container' and contains(., '" + productName + "')]")).click();
    }

    public void goToCart(){

    }
}
