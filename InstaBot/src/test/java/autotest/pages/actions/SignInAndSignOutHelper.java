package autotest.pages.actions;

import autotest.core.base.BasePage;
import autotest.core.base.Page;
import autotest.pages.elements.SignInAndSignOut;

public class SignInAndSignOutHelper extends BasePage {
    private final SignInAndSignOut signInAndSignOut = new SignInAndSignOut();
    public SignInAndSignOutHelper() {
        super();
    }

    /*данный метод осуществляет авторизацию на сайте.*/
    public void loginBot(String login, String password){
        waitForElementVisibility(signInAndSignOut.getLoginInput());
        signInAndSignOut.getLoginInput().sendKeys(login);
        sleep(500);
        waitForElementVisibility(signInAndSignOut.getPasswordInput());
        signInAndSignOut.getPasswordInput().sendKeys(password);
        sleep(500);
        waitForElementToBeClickable(signInAndSignOut.getLoginButton());
        signInAndSignOut.getLoginButton().click();
        sleep(500);

        Page.logger.info("signing into your account completed successfully.");
    }

    /*данный метод осуществляет выход из вашего аккаунта.*/
    public void SignOut() {
        waitForElementToBeClickable(signInAndSignOut.getProfMenuBtn());
        signInAndSignOut.getProfMenuBtn().click();
        sleep(1000);

        waitForElementToBeClickable(signInAndSignOut.getLogOutBtn());
        signInAndSignOut.getLogOutBtn().click();
        sleep(1500);

        Page.logger.info("Logging out from your account completed successfully.");
    }
}
