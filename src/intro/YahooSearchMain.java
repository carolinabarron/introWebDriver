package intro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooSearchMain {
	
	

	public static void main(String[] args) {
		//INICIALIZACION DE SYSTEM.SETPROPERTY()
		System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
	    WebDriver driver; //Arranca el navegador (Chrome)
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS); //Espera
		driver.get("http://www.yahoo.com"); //Navega a la URL
		WebElement searchBox = driver.findElement(By.id("uh-search-box")); //Variable searchbox y la asigna o apunta a un web element
		WebElement searchButton = driver.findElement(By.id("uh-search-button"));
		
		searchBox.clear();
		searchBox.sendKeys("Selenium");
		searchButton.click();
		
		WebElement seleniumLink = driver.findElement(By.linkText("Selenium - Web Browser Automation"));
		seleniumLink.click();
		
		ArrayList<String> windowIds = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Number of windows: " + windowIds.size());
		
		for(String windowId: driver.getWindowHandles()) {
			driver.switchTo().window(windowId);
		}
		
		WebElement downloadLink = driver.findElement(By.linkText("Download"));
		downloadLink.click();
		
		driver.close();

	}

}
