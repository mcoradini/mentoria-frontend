package support;

import org.apache.commons.codec.binary.Base64;

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
public class ScreenShot {

	public static String captureToBase64() throws IOException {
	    Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenCapture = null;
	    String base64Encoded = "";

	    try {
	        screenCapture = new Robot().createScreenCapture(screenSize);
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(screenCapture, "jpg", baos);
	        baos.flush();
	        byte[] encodeBase64 = Base64.encodeBase64(baos.toByteArray());
	        base64Encoded = new String(encodeBase64);
	        baos.close();
	    } catch (AWTException e) {
	        e.getMessage();
	    }

	    return "data:image/jpeg;base64," + base64Encoded;
	}

}
