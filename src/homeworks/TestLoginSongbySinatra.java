package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestLoginSongbySinatra extends ParentLoginMethods {
    static WebDriver driver;

    public static void main(String[] args) {

        navegarSitio("http://evening-bastion-49392.herokuapp.com/");
        verificarLandingPage();
        navegarLoginPage();
      //  verificarLoginPage();
        loginUser("frank", "sinatra");
        verificarSongsPage();

    }


/*
    private static void navegarSitio(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    private static void verificarLandingPage() {

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

    private static void navegarLoginPage() {
        WebElement loginLink = driver.findElement(By.cssSelector("[href='/login']"));
        loginLink.click();

    }

    private static void verificarLoginPage() {

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

    private static void loginUser(String username, String password) {
    }

    private static void verificarSongsPage() {
    }

*/

}
