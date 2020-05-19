package support;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utils.TestBase;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author marco.coradini
 *
 * Classe com método para captura de tela em Base64, assim o usuário pode abrir o relatório em qualquer local
 * sem ser necessário levar consigo os arquivos JPG/PNG.
 *
 */
public class ScreenShot extends TestBase {

	private static WebDriver driver = getDriver();

	public static String captureToBase64() {
	    String base64Encoded = "";

	    try {
			base64Encoded = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	    } catch (WebDriverException e) {
			System.out.println("Falha ao gerar screenshot...");
	    	e.getMessage();
		}

	    return "data:image/jpeg;base64," + base64Encoded;
	}

}
