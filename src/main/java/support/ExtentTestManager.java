package support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * Classe com alguns métodos para serem utilizados no relatório. Aqui é possível registrar uma informação no mesmo
 * passando como parâmetros uma mensagem e foto.
 *
 */
public class ExtentTestManager {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();
	private static ExtentTest logger;
	private static final String DEFAULT_DESCRIPTION = "DBSERVER TEST SUITE";

	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		logger = extent.createTest(testName);
		extentTestMap.put((int) (Thread.currentThread().getId()), logger);
		return logger;
	}

    public static void log(Status logStatus, String message) {
        if(logger == null) {
		    startTest(DEFAULT_DESCRIPTION);
		}

		try {
			logger.log(logStatus, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	public static void log(Status logStatus, String message, String imagePath) {
        if(logger == null) {
		    startTest(DEFAULT_DESCRIPTION);
		}

		try {
			logger.log(logStatus, message, MediaEntityBuilder.createScreenCaptureFromBase64String(imagePath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
