package MashreqAssignment.reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getReportObject() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("Reports/ExtentReport.html");
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Test Execution Report");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}