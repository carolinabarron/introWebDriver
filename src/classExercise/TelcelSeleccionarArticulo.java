package classExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TelcelSeleccionarArticulo {

    static WebDriver driver;

    public static void main(String[] args) {
        navegarSitio("https://www.telcel.com");
        verificarLandingPage();
        listarTelefonos();
        seleccionarEstado("Jalisco");
        verificarPaginaResultados();
        Celular primerCelular;
        primerCelular = capturarDatosCelular(1);
        seleccionarCelular(1);
        validarDatosCelular(primerCelular);
    }



    private static void navegarSitio(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
      //  driver = new ChromeDriver();
        //Para maximizar pantalla y en modo incógnito
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    private static void verificarLandingPage() {
        //verificar que existen estos elementos
//        logoTelcel:  css="[src='/content/dam/htmls/img/icons/logo-telcel.svg']"

        WebElement logoTelcel = driver.findElement(By.cssSelector("[src='/content/dam/htmls/img/icons/logo-telcel.svg']"));
        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        WebElement campoBusqueda = driver.findElement(By.cssSelector("#buscador-menu-input"));
        if(logoTelcel.isDisplayed() &&
                tiendaEnLinea.isDisplayed() &&
                campoBusqueda.isDisplayed() && campoBusqueda.isEnabled()) {
            System.out.println("Sí cargó la página principal de telcel");
        } else {
            System.out.println("No cargó la página");
            System.exit(-1);
        }
    }

    private static void listarTelefonos() {
        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        tiendaEnLinea.click();
        WebElement linkTelefonosCelulares = driver.findElement(By.cssSelector(".shortcut-container [data-nombreboton='Telefonos y smartphones']"));
        linkTelefonosCelulares.click();
    }

    private static void seleccionarEstado(String nombreEstado) {

        System.out.println("breakpoint instruction.");
        WebElement seleccionaEstadoDropdown = driver.findElement(By.cssSelector(".modal .chosen-single"));
        if(seleccionaEstadoDropdown.isDisplayed()) {
            seleccionaEstadoDropdown.click();
            WebElement estado = driver.findElement(By.cssSelector(".chosen-search input"));
            estado.sendKeys(nombreEstado);
            estado.sendKeys(Keys.ENTER);
            WebElement entrar = driver.findElement(By.cssSelector("#entrarPerfilador"));
            entrar.click();

        } else {
            System.out.println("Falló el modal");
            System.exit(-1);
        }
/*Del programa compartido




            WebElement inputEstado = driver.findElement(By.cssSelector(".chosen-search input"));
            inputEstado.sendKeys(nombreEstado);
            WebElement opcionEstado = driver.findElement(By.cssSelector(".chosen-results li"));
            opcionEstado.click();
            WebElement botonEntrar = driver.findElement(By.id("entrarPerfilador"));
            botonEntrar.click();
 */




        }


/*

    private static void verificarPaginaResultados(String nombreEstado) {


        WebElement listaResultados = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-comparador-contenedor"));
        WebElement estadoActual = driver.findElement(By.cssSelector(".estado-Gluo.text-option"));


        //Assert.assertEquals(expected, actual);

        if ((listaResultados.isDisplayed() ) && (estadoActual.getText() == nombreEstado)){
            System.out.println("Página de resultados verificada y con el Estado seleccionado");
        }
        else {
            System.out.println("Página de resultados incorrecta");
        }
    }



*/

    private static void verificarPaginaResultados() {
        List<WebElement> celulares = driver.findElements(By.cssSelector(".comp-telcel-mosaico-equipos li"));
        System.out.println(celulares.size());
        if(celulares.size() > 1) {
            System.out.println("La lista se desplego correctamente.");
        }
    }

    private static Celular capturarDatosCelular(int i) {
        WebElement textoMarcaModelo = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-marca"));
        String mm = textoMarcaModelo.getText();

        WebElement textoNombre = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-nombre-equipo"));
        String nombreEquipo = textoNombre.getText();


        WebElement textoPrecio = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-precio"));
        String precioEquipo = textoPrecio.getText();
        precioEquipo = precioEquipo.replace(",", "");
        precioEquipo = precioEquipo.replace("$", "");
        double pe = Double.parseDouble(precioEquipo);


        WebElement textoCapacidad = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-capacidad-numero"));
        String capacidadEquipo = textoCapacidad.getText();
        String[] datos = capacidadEquipo.split(" ");
        String capacidadString = datos[0];
        int numGigas = Integer.parseInt(capacidadString);


        return new Celular(mm, nombreEquipo, pe, numGigas);
    }

    private static void seleccionarCelular(int numCelular) {
        List<WebElement> celulares = driver.findElements(By.cssSelector(".comp-telcel-mosaico-equipos li"));
        System.out.println(celulares.size());
        WebElement celular = celulares.get(numCelular - 1);
        celular.click();
    }

    private static void validarDatosCelular(Celular primerCelular) {
    }


}
    