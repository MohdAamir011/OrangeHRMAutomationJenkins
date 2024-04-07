package listeners;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG;
import com.aventstack.extentreports.*;
import java.io.IOException;
import base.Base;
public class Listeners extends Base implements ITestListener {
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    //    to get rid of concurrency problem (test value can be changed or override due to parallel test)
    ThreadLocal <ExtentTest> extenttest = new ThreadLocal <ExtentTest> ();
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extenttest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extenttest.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extenttest.get().log(Status.FAIL,"Test Failed");
// making it synchronize
        //        test.fail(result.getThrowable());
        extenttest.get().fail(result.getThrowable());
//        screenshot
// driver is not having life in base test so we get the life to driver with the help
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String path = null;
        try {
            path = getScreenShot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extenttest.get().addScreenCaptureFromPath(path,result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
