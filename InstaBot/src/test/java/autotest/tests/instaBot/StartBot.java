package autotest.tests.instaBot;

import autotest.core.base.BasePage;
import autotest.core.base.BaseTest;
import autotest.core.listener.Retry;
import autotest.pages.actions.LikesAndSubsHelper;
import autotest.pages.actions.SearchingAccHelper;
import autotest.pages.actions.SignInAndSignOutHelper;
import autotest.pages.elements.SignInAndSignOut;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

//Переработано и реализовано 5 тестов соответствующих 5 аккаунтам и 1 тест соответствующий входу в аккаунт
public class StartBot extends BaseTest{
    public StartBot(){ super(); }
    WebDriver driver = BasePage.getWebDriver();
    SignInAndSignOutHelper signin = new SignInAndSignOutHelper();
    SearchingAccHelper search = new SearchingAccHelper();
    LikesAndSubsHelper lAndS = new LikesAndSubsHelper();
    @Test(retryAnalyzer = Retry.class)
    public void StartBot() {
        signin.loginBot(getBot().getLogin(), getBot().getPassword());
    }
    @Test(retryAnalyzer = Retry.class)
    public void firstStep() {
        search.searchAcc(driver);
        lAndS.likesAndSubsBot(driver);
    }
    @Test(retryAnalyzer = Retry.class)
    public void secondStep() {
        search.searchAcc(driver);
        lAndS.likesAndSubsBot(driver);
    }
    @Test(retryAnalyzer = Retry.class)
    public void thirdStep() {
        search.searchAcc(driver);
        lAndS.likesAndSubsBot(driver);
    }
    @Test(retryAnalyzer = Retry.class)
    public void fourthStep() {
        search.searchAcc(driver);
        lAndS.likesAndSubsBot(driver);
    }
    @Test(retryAnalyzer = Retry.class)
    public void fifthStep() {
        search.searchAcc(driver);
        lAndS.likesAndSubsBot(driver);
    }
}
