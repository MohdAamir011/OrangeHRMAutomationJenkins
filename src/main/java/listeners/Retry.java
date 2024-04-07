package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    //    To rerun the test you need to give parameter to @test at method level
//    @Test(retryAnalyzer=Retry.class)
//    we add this attribute to some flaky test cases that some times fails
//    you have add this attribute to each method level to rerun the test case on failure
    int count =0;
    int maxTry =1;
    @Override
    public boolean retry(ITestResult result) {
        if(count<maxTry){
            count++;
            return true;
        }
        return false;
    }
}

