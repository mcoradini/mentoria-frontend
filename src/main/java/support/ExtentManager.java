package support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 *
 * Classe para setup do relatório com os resultados da execução dos testes. Definições de encoding, nome, uso de CSS, etc..
 *
 * O relatório resultante é salvo no diretório TestReport.
 *
 */
public class ExtentManager {
    private static ExtentReports extent;
    private static String reportFileName = "Mentoria_"+ DateTimeUtils.getDateTimeFormatReport() +".html";
    private static String fileSeparator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeparator+ "TestReport";
    private static String reportFileLocation =  reportFilepath + fileSeparator + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		htmlReporter.config().setCSS(".nav-wrapper { background-color: #1E317A !important; } .brand-logo { background-color: #1E317A !important; padding: 0 10px 0 0 !important; margin: 0 !important; position: absolute !important } .report-name { margin-left: 80px !important } .blue.darken-3 { background-color: #1E317A !important; color: #FFF !important;  }");
		htmlReporter.config().setJS("$('.brand-logo').html('<img src=\"https://i.imgur.com/qDYwkD2.png\" class=\"db-logo\"/>');");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //Set environment details
        try {
			String pcName = InetAddress.getLocalHost().getHostName();
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("AUT", pcName);
			extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

        return extent;
    }

    //Create the report path
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Diretório: " + path + " foi criado!" );
                return reportFileLocation;
            } else {
                System.out.println("Falha ao criar diretório: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("O diretório já existe: " + path);
        }
		return reportFileLocation;
    }

}
