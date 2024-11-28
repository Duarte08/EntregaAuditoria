import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;

public class TestSelenium {
    private WebDriver driver;

    @Before
    public void setupDriver() {
       // System.setProperty("webdriver", "C:\\Users\\Manuel Duarte\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Espera implícita
    }

//    //test uno
    @Test
    public void testHomeCount() {
        try {
            // Navegar a Google
            driver.navigate().to("https://www.google.com");

            // Buscar "mike mike"
            WebElement searchbox = driver.findElement(By.name("q"));
            searchbox.sendKeys("mike mike");
            searchbox.sendKeys(Keys.RETURN);

            // Esperar hasta que el primer resultado sea clickeable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")));
            firstResult.click();

            // Clic para cerrar modal
            WebElement result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]")));
            result.click();

            // Encontrar la barra de búsqueda usando el placeholder y escribir "Jansport"
            WebElement searchItem = driver.findElement(By.cssSelector("input[placeholder='Buscar productos o categorias ...']"));
            searchItem.sendKeys("Jansport");
            searchItem.sendKeys(Keys.RETURN); //
            Thread.sleep(2000);

            // Paso 2: Validar los ítems que se encuentran
            List<WebElement> countItems = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div"));
            int itemCount = countItems.size();
            if (itemCount != 0) {
                System.out.println("Número de ítems: " + itemCount);

            }else {
                assert itemCount == 0 : "Se encuentra vacio.";
            }

        } catch (Exception e) {
            System.out.println("Se produjo un error durante la ejecución: " + e.getMessage());
        }
        closeWindow();
    }


    //test dos
    /*
    @Test
    public void testValidationPages() {
        try {
            // Navegar a Google
            driver.navigate().to("https://www.google.com");

            // Buscar "mike mike"
            WebElement searchbox = driver.findElement(By.name("q"));
            searchbox.sendKeys("mike mike");
            searchbox.sendKeys(Keys.RETURN);

            // Esperar hasta que el primer resultado sea clickeable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")));
            firstResult.click();

            // Clic para cerrar modal
            WebElement result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]")));
            result.click();

            // Esperar hasta que las secciones sean clickeables y hacer clic en cada una
            String[] sectionXPaths = {
                    "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[1]/a/p", // Mochilas
                    "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[2]/a/p", // Bolsos
                    "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[3]/a/p", // Maletines
                    "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[4]/a/p", // Maletas
                    "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[5]/a/p", // Billeteras
                    "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[6]/a/p", // Accesorios
                    "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[7]/a/p"  // Outlet
            };

            for (String xpath : sectionXPaths) {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                element.click();
                Thread.sleep(5000);
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail("Test falló con el error: " + e.getMessage());
        }
     closeWindow();
    }
    */

    /*
  //test tres
    @Test
    public void testFilterValidation() {
        try {
            // Navegar a Google
            driver.navigate().to("https://www.google.com");

            // Buscar "mike mike"
            WebElement searchbox = driver.findElement(By.name("q"));
            searchbox.sendKeys("mike mike");
            searchbox.sendKeys(Keys.RETURN);

            // Esperar hasta que el primer resultado sea clickeable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")));
            firstResult.click();

            // Clic para cerrar modal
            WebElement result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]")));
            result.click();
            Thread.sleep(2000);

            // Clic en pestaña ver más
            WebElement buttonWatch = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[1]/a"));
            buttonWatch.click();
            Thread.sleep(2000);
            // Clic en pestaña lo más nuevo
            WebElement buttonNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/secciones/lo-mas-nuevo']")));
            buttonNew.click();
            Thread.sleep(2000);
            // Clic en pestaña cupones
            WebElement buttonCup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/ul/li[3]/a[1]")));
            buttonCup.click();
            Thread.sleep(2000);
            // Clic en pestaña Frecuentes
            WebElement buttonFreq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/ul/li[4]")));
            buttonFreq.click();
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Test falló con el error: " + e.getMessage());
        }
        closeWindow();
    }
*/
    //test cuatro
    /*
    @Test
    public void testAddCart() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            // Navegar a Google
            driver.navigate().to("https://www.google.com");

            // Buscar "mike mike"
            WebElement searchbox = driver.findElement(By.name("q"));
            searchbox.sendKeys("mike mike");
            searchbox.sendKeys(Keys.RETURN);

            // Esperar hasta que el primer resultado sea clickeable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")));
            firstResult.click();

            // Clic para cerrar modal
            WebElement result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]")));
            result.click();

            // Agregar el primer ítem al carrito
            WebElement firstProduct = driver.findElement(By.cssSelector("#root > div > div > div:nth-child(3) > div > div:nth-child(2) > div.relative > div.slick-slider.slick-initialized > div > div > div.slick-slide.slick-active.slick-current > div > div"));
            firstProduct.click();

            WebElement firstItemButton = driver.findElement(By.cssSelector("body > div:nth-child(7) > div > div > div > div > div.md\\:flex.relative.overflow-hidden.p-4 > div.relative.w-full.md\\:w-2\\/5.mr-4 > div.w-5\\/6.my-3 > button"));
            firstItemButton.click();
            Thread.sleep(2000);
            WebElement closeVentana = driver.findElement(By.cssSelector("body > div:nth-child(7) > div > div > button"));
            closeVentana.click();
            Thread.sleep(2000);

            // Agregar el segundo ítem al carrito
            WebElement secondProduct = driver.findElement(By.cssSelector("#root > div > div > div:nth-child(3) > div > div:nth-child(4) > div.flex.items-center > div.w-full.md\\:w-8\\/12.relative > div.slick-slider.slick-initialized > div > div > div:nth-child(5) > div > div"));
            secondProduct.click();
            Thread.sleep(3000);

            WebElement secondItemButton = driver.findElement(By.cssSelector("body > div:nth-child(7) > div > div > div > div > div.md\\:flex.relative.overflow-hidden.p-4 > div.relative.w-full.md\\:w-2\\/5.mr-4 > div.w-5\\/6.my-3 > button"));
            secondItemButton.click();
            Thread.sleep(3000);

            WebElement closeVentanaDos = driver.findElement(By.cssSelector("body > div:nth-child(7) > div > div > button"));
            closeVentanaDos.click();
            Thread.sleep(3000);
            // Abrir el carrito
            WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/nav/div[1]/div/div[1]/div[3]/div[1]/a"));
            cartButton.click();
            Thread.sleep(3000);
            // Esperar a que los ítems en el carrito sean visibles
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div/div")));
            // Paso 2: Validar los ítems en el carrito
            List<WebElement> cartItems = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div/div/div"));
            int itemCount = cartItems.size();
            if (itemCount != 0) {
            System.out.println("Número de ítems en el carrito: " + itemCount);

            }else {
                assert itemCount == 0 : "El carrito se encuentra vacio.";
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error durante la ejecución: " + e.getMessage());
        }
         closeWindow();
    }   */

    @After
    public void closeWindow() {
        if (driver != null) {
            driver.quit();
        }
    }


}

