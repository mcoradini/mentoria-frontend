package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameOperationsTestCase {

	public WebDriver driver;

	@BeforeTest
	public void setup() {
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.addArguments("--start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(optionsChrome);
	}

	/**
	 * Esta página possui um único frame, com o nome "mce_0_ifr".
	 * No caso, basta acessar este frame e retornar o texto contido dentro dele.
	 */
	@Test
	public void testIframe1() {
		driver.navigate().to("http://the-internet.herokuapp.com/iframe");

		//Acessa o iframe através do id
		driver.switchTo().frame("mce_0_ifr");
		System.out.println(driver.findElement(By.id("tinymce")).getText());
	}

	/**
	 * Esta página possui 2 frames principais, "frame-top" e "frame-bottom".
	 * No caso, ambas informações a serem buscadas neste teste estão dentro de um frameset de "frame-top".
	 */
	@Test
	public void testIframe2() {
		driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");

		//Busca informação LEFT
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		System.out.println(driver.findElement(By.cssSelector("body")).getText());

		//Busca informação MIDDLE, necessário retornar o driver a posição inicial
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.cssSelector("body")).getText());
	}

	@AfterTest
	public void finish() {
		driver.quit();
	}

}
