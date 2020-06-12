package tareas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SongsSinatraParent {

    public static WebDriver driver;

    public static void navegar(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }


    public static void validarHomePage() {

        //WebElement txtBienvenida = driver.findElement(By.partialLinkText("Welcome to this website"));
        //WebElement txtBienvenida = driver.findElement(By.xpath("//*[text()='Welcome to this website all about the songs of the great Frank Sinatra']"));
       // WebElement txtBienvenida = driver.findElement(By.cssSelector("body>section>p"));
        WebElement txtBienvenida = driver.findElement(By.cssSelector("p"));
        WebElement imgSinatra = driver.findElement(By.cssSelector("[src='/images/sinatra.jpg']"));
        WebElement linkLogin = driver.findElement(By.cssSelector("[href='/login']"));

        if (txtBienvenida.isDisplayed() && imgSinatra.isDisplayed() && linkLogin.isDisplayed())
        {
            System.out.println("Página principal de Songs By Sinatra cargó exitosamente");
        }
        else
        {
            System.out.println("No cargó correctamente la página");
            System.exit(-1); //sale del programa y regrea un -1 para marcar un error.
        }

    }
    public static void realizarLoginCorrecto(String usuario, String password) {
        //Click al link login:
        WebElement linkLogin = driver.findElement(By.cssSelector("[href='/login']"));
        linkLogin.click();

        //Introducir username y password:
        WebElement usernameTxt = driver.findElement(By.cssSelector("#username"));
        WebElement passwordTxt = driver.findElement(By.cssSelector("#password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));

        if(usernameTxt.isDisplayed() && usernameTxt.isEnabled() &&
                passwordTxt.isDisplayed() && passwordTxt.isEnabled()
                && loginBtn.isDisplayed()) {
            usernameTxt.sendKeys(usuario);
            passwordTxt.sendKeys(password);
            loginBtn.click();
        } else {
            System.out.println("La página 'Login' no se cargó correctamente");
            System.exit(-1);
        }

    }



    public static void validateSongsPage() {
        WebElement songsTitle = driver.findElement(By.cssSelector("section h1"));
        String currentUrl = driver.getCurrentUrl();
        WebElement songsLink = driver.findElement(By.cssSelector("[href='/songs']"));
        String currentClass = songsLink.getAttribute("class");
        List<WebElement> listaCanciones = driver.findElements(By.cssSelector("#songs li"));

        if(songsTitle.isDisplayed()  &&
                currentUrl.endsWith("songs") &&
                currentClass.equals("current") &&
                listaCanciones.size() > 0) {
            System.out.println("Si estoy en la pagina de songs");
        }
        else {
            System.out.println("No estoy en la pagina de songs.");
            cerrarBrowser();

            System.exit(-1);
        }
    }

    public static void cerrarBrowser() {
        driver.quit();
    }
}
