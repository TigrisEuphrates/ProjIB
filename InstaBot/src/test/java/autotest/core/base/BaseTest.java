package autotest.core.base;

import autotest.core.business.User;
import autotest.core.manager.ChromeWebDriver;
import autotest.pages.actions.LikesAndSubsHelper;
import autotest.pages.actions.SearchingAccHelper;
import autotest.pages.actions.SignInAndSignOutHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/*
* BaseTest - базовый класс для всех Test классов описанных в пакете tests
* BaseTest класс применяет конфигурацию SuiteConfiguration,
* объявляет driver который получает все свои настройки от ChromeDriver класса со static метода getInstance(),
* config описан в папке resources в файле ConfigProperties
* реализованы before/after аннотации тестового фреймворка testng
* */
public class BaseTest {
    private static SuiteConfiguration config;
    private static WebDriver driver;

    // страницы действий
    public LikesAndSubsHelper likesAndSubsHelper;
    public SearchingAccHelper searchingAccHelper;
    public SignInAndSignOutHelper signInAndSignOutHelper;

    public BaseTest(){
        likesAndSubsHelper = PageFactory.initElements(BasePage.getWebDriver(), LikesAndSubsHelper.class);
        searchingAccHelper = PageFactory.initElements(BasePage.getWebDriver(), SearchingAccHelper.class);
        signInAndSignOutHelper = PageFactory.initElements(BasePage.getWebDriver(), SignInAndSignOutHelper.class);
    }

    public static WebDriver instantiateDriver() {
        try{
            if (driver == null) config = new SuiteConfiguration();
            if (config.getProperty("browser").equalsIgnoreCase("chrome")) driver = ChromeWebDriver.getInstance();
        }catch (IOException ex){
            System.out.println(ex);
        }

        return driver;
    }

    @Getter
    private User Bot = new User("dadyabog", "titanofloneliness");//login--dyadya.b0gdan;password--dokidoki;----запасной аккаунт

    @BeforeSuite
    public void setUp(){
        if (driver!=null) driver.get(config.getProperty("url"));
        if (driver!=null) driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitlyWait")), TimeUnit.SECONDS);
    }

    @BeforeClass
    public void setUpClass(){
        String className = this.getClass().getName();
        Page.logger.info("RUN class: "+ className);
    }

    @BeforeMethod
    public static void setUpMethod(Method method){
        String testName = method.getName();
        Page.logger.info("RUN test method: "+ testName);
    }

    @AfterClass
    public void SignOut() {
        signInAndSignOutHelper.SignOut();
    }

    @AfterSuite
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
        Page.logger.info("test execution completed.");
    }


}
