package autotest.core.listener;

import autotest.core.base.Page;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestResultListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        Page.logger.info(" FAILED ");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Page.logger.info(" PASSED ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Page.logger.info(" SKIPPED ");
    }
}
