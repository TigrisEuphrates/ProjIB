package autotest.core.base;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.logging.Level;

/* Реализация абстрактного класса BasePage обосновано тем что
в будущем с такой реализацией есть возможность к расширирению данного класса методами,
так чтобы каждый наследуемый дочерний класс от BasePage мог использовать методы данного класса
*/
public abstract class BasePage implements Page{
    @Getter
    private final static WebDriver webDriver = BaseTest.instantiateDriver();
    private WebDriverWait webDriverWait;
    //класс Actions имеет несколько разные способы взаимодействия с вебэлементом, к примеру doubleClick, clickAndHold и тд
    protected Actions make;


    /**
     * Исполняемый драйвер ожидает пока вебэлемент не ситнет кликабелен, часто используется для кнопок(button)
     * @param  webElement   вебэлемент clickable
     */
    @Override
    public void waitForElementToBeClickable(WebElement webElement) {
        webDriverWait = new WebDriverWait(webDriver, 60);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Исполняемый драйвер ожидает пока вебэлемент не появится на странице
     * @param  webElement   вебэлемент который ожидаем
     */
    @Override
    public void waitForElementVisibility(WebElement webElement) {
        webDriverWait = new WebDriverWait(webDriver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Поток выполнения(main) останавливается на указанный период времени
     * Использование данного метода не рекомендуется, дайте предпочтения ожиданиям waitForElementVisibility, waitForElementToBeClickable
     * Если ожидания не дают должного результата используйте этот метод
     * @param  millis   время ожидания в миллисекундах
     */
    @Override
    public void sleep(int millis) {

        int selectDuration = 1000;

        try {
            Thread.sleep(millis + selectDuration);
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Interrupted!", e);
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void sleepLong() {

        int selectDuration = 5_000;//--можно изменить значение для ускорения или замедления выполнения.

        try {
            Thread.sleep(selectDuration);
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Interrupted!", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Скролл до вебэлемента
     * Используйте только в том случае если вебэлемент не виден в текущем окне без помощи скроллинга
     * @param  webElement   скролл до этого вебэлемента
     */
    @Override
    public void scrollToWebElement(WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    /**
     * Проверка вебэлемента на редактирование и на клик
     * @param  webElement   вебэлемент isEnabled?
     * @return true or false
     */
    @Override
    public boolean checkIsElementEditable(WebElement webElement) {
        waitForElementVisibility(webElement);
        return webElement.isEnabled();
    }

    /**
     * Метод проверяет вебэлемент на не доступность
     * @param  webElement   вебэлемент isEnabled?
     */
    @Override
    public void checkIsElementDisabled(WebElement webElement) {
        waitForElementVisibility(webElement);
        if (webElement.isEnabled()) Assert.fail();
    }

    /**
     * Метод проверяет value вебэлемента на пустоту по его атрибуту
     * @param attribute  свойство вебэлемента
     * @param  webElement   вебэлемент isEmpty?
     */
    @Override
    public void checkIsAttributeOfElementNotEmpty(String attribute, WebElement webElement) {
        waitForElementVisibility(webElement);
        if (webElement.getAttribute("value").isEmpty()) Assert.fail();
    }

    /**
     * Метод проверяет value вебэлемента на пустоту по тексту
     * @param  webElement   вебэлемент isEmpty?
     */
    @Override
    public void checkIsTextOfElementNotEmpty(WebElement webElement) {
        waitForElementVisibility(webElement);
        if (webElement.getText().isEmpty()) Assert.fail();
    }

    @Override
    public boolean isElementVisible(String locator, WebDriver driver){
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }
}
