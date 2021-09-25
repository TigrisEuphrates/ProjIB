package autotest.pages.actions;

import autotest.core.base.BasePage;
import autotest.core.base.Page;
import autotest.core.helper.Randomizer;
import autotest.pages.elements.SearchingAcc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SearchingAccHelper extends BasePage {
    private final SearchingAcc searchingAcc = new SearchingAcc();
    public SearchingAccHelper() {
        super();
    }

    /*данный метод осуществляет ввод случайной буквы в поисковую строку,
    а затем нажатие на случайный аккаунт из раскрывшегося списка аккаунтов.*/
    public void searchAcc(WebDriver driver){
        waitForElementVisibility(searchingAcc.getSearchInput());
        searchingAcc.getSearchInput().sendKeys(Randomizer.randChar());
        sleep(100);

        Page.logger.info("searching for accounts completed successfully.");

        waitForElementToBeClickable(searchingAcc.getRandomAccountClick(driver));
        searchingAcc.getRandomAccountClick(driver).click();
        sleep(100);

        Page.logger.info("opening random account completed successfully.");
        
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        if(driver.findElements(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/article/div[1]/div/h2")).size() != 0) {
            Assert.assertEquals(2,1);//--необходим для того чтобы при выполнении условия в конструкции if провалить тест для его перезапуска.
        }//--проверяет не находимся ли мы на странице закрытого аккаунта. если да то выходит из вашего аккаунта и начинает тест заново.

        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        if(driver.findElements(By.xpath("//*[@id=\"react-root\"]/section/main/header/div[2]/div/div[1]/h1")).size() != 0) {
            searchAcc(driver);
        }//--проверяет не находимся ли мы на странице #хештега. если да то выполняет поиск заново.

        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        if(driver.findElements(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/div[1]/div[2]/div/div[2]/div/span/span[1]/button/div/span")).size() != 0
                || driver.findElements(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/div[1]/div[1]/div/div[2]/div/span/span[1]/button/div/span")).size() != 0) {
            searchAcc(driver);
        }//--проверяет не были ли мы уже на странице этого аккаунта. если да то выполняет поиск заново.
    }
}
