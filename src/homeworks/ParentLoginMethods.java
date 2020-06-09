package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ParentLoginMethods {
    static WebDriver driver;
   // static By searchBoxLocator = By.id("navbar-query");
   // static By searchButtonLocator = By.id("navbar-submit-button");

    public static void navegarSitio(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    public static void verificarLandingPage() {

        WebElement sinatraImage = driver.findElement(By.cssSelector("[alt='Frank Sinatra']"));
        WebElement loginLink = driver.findElement(By.cssSelector("[href='/login']"));

        if(sinatraImage.isDisplayed() &&
                loginLink.isDisplayed() ) {
            System.out.println("La página 'Songs by Sinatra' fue cargada correctamente");
        } else {
            System.out.println("La página 'Songs by Sinatra' no se cargó correctamente");
            System.exit(-1);
        }
    }

    public static void navegarLoginPage() {
        WebElement loginLink = driver.findElement(By.cssSelector("[href='/login']"));
        loginLink.click();

    }

    /*
    public static void verificarLoginPage() {

        WebElement campoUsername = driver.findElement(By.cssSelector("#username"));
        WebElement campoPassword = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));

        if(campoUsername.isDisplayed() && campoUsername.isEnabled() &&
                campoPassword.isDisplayed() && campoPassword.isEnabled()
                && loginButton.isDisplayed()) {
            System.out.println("La página 'Login' fue cargada correctamente");
        } else {
            System.out.println("La página 'Login' no se cargó correctamente");
            System.exit(-1);
        }
    }

     */

    public static void loginUser(String username, String password) {
        WebElement campoUsername = driver.findElement(By.cssSelector("#username"));
        WebElement campoPassword = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));

        if(campoUsername.isDisplayed() && campoUsername.isEnabled() &&
                campoPassword.isDisplayed() && campoPassword.isEnabled()
                && loginButton.isDisplayed()) {
            campoUsername.sendKeys(username);
            campoPassword.sendKeys(password);
            loginButton.click();
        } else {
            System.out.println("La página 'Login' no se cargó correctamente");
            System.exit(-1);
        }
    }

    public static void verificarSongsPage() {
        WebElement loggedinMessage = driver.findElement(By.cssSelector(".flash.notice"));
        WebElement createnewsongLink = driver.findElement(By.cssSelector("[href='/songs/new']"));
        WebElement logoutButton = driver.findElement(By.cssSelector("[href='/logout']"));
        if(loggedinMessage.isDisplayed() && createnewsongLink.isDisplayed() && logoutButton.isDisplayed()) {
            System.out.println("El usuario inició sesión correctamente en la página");
        } else {
            System.out.println("El usuario no inició sesión en la página.");
            System.exit(-1);
        }

    }

}
