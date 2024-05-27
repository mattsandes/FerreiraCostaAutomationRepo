package br.com.sandes.testcases;

import br.com.sandes.methods.TestUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ferreiraCostaTests {

    private static WebDriver driver;
    private static TestUtils testUtils;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        testUtils = new TestUtils(driver);
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("https://www.ferreiracosta.com/");
        testUtils.closeCookiesModal();
    }

    @AfterAll
    static void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    @DisplayName("Validate that is possible to interact with products")
    void canInteractWithProductTest(){

        testUtils.searchForProduct("Espelho Retangular");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        testUtils.selectProduct(
                "Espelho com Moldura Retangular 44x94cm Preto - Euroquadros");

        assertTrue(driver.findElement(By.xpath("//h1[@data-cy='box-product-title']")).getText().contains("Espelho com Moldura Retangular 44x94cm Preto - Euroquadros"));
    }

    @Test
    @DisplayName("Validate that is possible to add products on cart")
    void canAddProductOnCartTest(){

        testUtils.searchForProduct("Travesseiro");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        testUtils.selectProduct(
                "Travesseiro Antistress 50x70 cm Fios de Carbono - Altenburg");

        testUtils.addToCart();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        assertTrue(driver.findElement(
                By.xpath("//section[@data-cy='box-details-product']"))
                .getText()
                    .contains("Travesseiro Antistress 50x70 cm Fios de Carbono - Altenburg"));

    }

    @Test
    @DisplayName("Validate that is possible to add products on cart")
    void canRemoveProductsOnCartTest(){

        testUtils.searchForProduct("Travesseiro Antistress");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        testUtils.selectProduct("Travesseiro Antistress");

        testUtils.addToCart();

        assertTrue(driver.findElement(
                By.xpath("//section[@data-cy='box-details-product']"))
                .getText()
                    .contains("Travesseiro"));

    }
}
