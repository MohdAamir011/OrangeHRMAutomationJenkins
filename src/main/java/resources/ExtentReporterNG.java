package resources;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
public class ExtentReporterNG {
    public static ExtentReports getReportObject(){
        String path =System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter reporter =new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Mohd amir");

        return extent;
    }
}

