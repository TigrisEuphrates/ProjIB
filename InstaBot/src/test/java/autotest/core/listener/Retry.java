package autotest.core.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*данный класс необходим для того чтобы при провале теста начать его заново*/
public class Retry implements IRetryAnalyzer {
    @Override
    public boolean retry(ITestResult result)
    {
        if(result.isSuccess()) {
            return false;
        }
        else {
            return true;
        }
    }
}
