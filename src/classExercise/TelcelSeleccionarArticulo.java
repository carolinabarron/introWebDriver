
package classExercise;
public class TelcelSeleccionarArticulo extends TelcelParent{

    //

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
        cerrarBrowser();
    }


}