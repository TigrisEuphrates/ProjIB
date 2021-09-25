package autotest.core.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

/*Разделение реализации от интерфейса,
интрефейс Page предоставляется методы для работы с веб элементами,
все методы данного класса реализует абстрактный класс BasePage
*/
public interface Page {
     Logger logger = Logger.getLogger("logging");

     //webElement waiting methods
     void waitForElementToBeClickable(WebElement webElement);
     void waitForElementVisibility(WebElement webElement);
     void sleep(int millis);
     void sleepLong();

     //webElement manipulation
     void scrollToWebElement(WebElement webElement);

     //webElement checking
     boolean checkIsElementEditable(WebElement webElement);
     void checkIsElementDisabled(WebElement webElement);
     void checkIsAttributeOfElementNotEmpty(String attribute, WebElement webElement);
     void checkIsTextOfElementNotEmpty(WebElement webElement);
     public boolean isElementVisible(String cssLocator, WebDriver driver);

}
