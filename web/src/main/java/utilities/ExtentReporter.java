package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
    static ExtentReports extentReport;

    public static ExtentReports getExtentReport() {
        String extentReportPath = System.getProperty("user.dir") + "/src/test/resources/reports/extentreport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
        reporter.config().setReportName("My monuro automation results");
        reporter.config().setDocumentTitle("Test results Monura");

        extentReport = new ExtentReports();
        extentReport.attachReporter(reporter);
        extentReport.setSystemInfo("Operating System", "Windows 11");
        extentReport.setSystemInfo("Test by", "David y Daniela");

        return extentReport;
    }
}
