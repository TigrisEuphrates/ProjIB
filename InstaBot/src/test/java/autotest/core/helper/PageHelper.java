package autotest.core.helper;

import autotest.core.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static autotest.core.base.BaseTest.instantiateDriver;

/*
* PageHelper необходим когда вы переходите с одной вкладки в другую,
* при тестирования если открывается новая вкладка браузера то нужно вызвать метод anyWindowOtherThan() для проверки вкладок,
* затем используйте переход на другую страницу методом goToTheNewPageBy()
* */
class PageHelper extends BasePage {
    public PageHelper() {
        super();
    }

    private final WebDriverWait wait = new WebDriverWait(instantiateDriver(), 30);


    public ExpectedCondition<String> anyWindowOtherThan(final Set<String> oldWindows){
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size()>0 ? handles.iterator().next():null;

            }
        };
    }

    public void goToTheNewPageBy(String by, WebElement webElement){

        Set<String > oldWindows = instantiateDriver().getWindowHandles();

        if (by.equalsIgnoreCase("click")){
            waitForElementToBeClickable(webElement);
            scrollToWebElement(webElement);
            webElement.click();
        }else if (by.equalsIgnoreCase("doubleClick")){
            make = new Actions(instantiateDriver());
            Action kbEvents = make.doubleClick(webElement).build();
            kbEvents.perform();
            make.doubleClick(webElement);
        }

        //ожидание появление нового окна
        String newWindow = wait.until(anyWindowOtherThan(oldWindows));
        instantiateDriver().switchTo().window(newWindow);

        sleep(1000);

    }

    public void closeNewWindow(){
        instantiateDriver().close();

        String mainWindow = instantiateDriver().getWindowHandle();
        instantiateDriver().switchTo().window(mainWindow);
    }



}
