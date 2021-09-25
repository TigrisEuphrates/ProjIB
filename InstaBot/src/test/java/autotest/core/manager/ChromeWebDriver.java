package autotest.core.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
* Конфигурационный класс ChromeWebDriver извользуя класс
* ChromeOptions предоставляет базовые настройки для драйвера
* */
public class ChromeWebDriver {
    private static WebDriver driver;
    public static WebDriver getInstance(){
        if (driver==null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--use-fake-ui-for-media-stream");
            options.addArguments("--disable-user-media-security");
            options.addArguments("--disable-web-security");
            options.addArguments("--reduce-security-for-testing");
            options.addArguments("--use-fake-device-for-media-stream");
            options.addArguments("--allow-file-access-from-files");
//            options.addArguments("--use-file-for-fake-video-capture="+System.getProperty("");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

}
