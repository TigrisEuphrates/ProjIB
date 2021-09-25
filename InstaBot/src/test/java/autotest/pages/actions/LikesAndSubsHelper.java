package autotest.pages.actions;


import autotest.core.base.BasePage;
import autotest.core.base.Page;
import autotest.pages.elements.LikesAndSubs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LikesAndSubsHelper extends BasePage {
    private final LikesAndSubs likesAndSubs = new LikesAndSubs();
    public LikesAndSubsHelper() {
        super();
    }
    /*данный метод проверяет количество публикаций на странице.
    если количество публикаций не равно нулю то открывает первую публикацию, ставит лайк, переходит к следующей
    публикации. это происходит столько раз сколько необходимо по условию, либо если публикаций меньше 10 то столько,
    сколько на странице есть публикаций.
    после операции над последней публикацией подписывается на аккаунт.
    (если публикаций нет то сразу переходит к этому пункту)*/
    public void likesAndSubsBot(WebDriver driver){
        String textOfElement = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/ul/li[1]/span/span")).getText();
        int amountOfPublications = Integer.parseInt(textOfElement.replaceAll("\\s",""));
        int x;//--переменная в дальнейшем указывающая на количество итераций для перехода на
              //--следующую публикацию и нажатие на кнопку лайка.
        if (amountOfPublications<10) {
           x = amountOfPublications;
        }
        else {
            x = 10;
        }
        if (amountOfPublications == 1) {
            waitForElementToBeClickable(likesAndSubs.getPublication(driver));
            likesAndSubs.getPublication(driver).click();
            sleep(250);

            waitForElementToBeClickable(likesAndSubs.getLikeButton());
            likesAndSubs.getLikeButton().click();
            sleep(225);

            waitForElementToBeClickable(likesAndSubs.getClosePbButton());
            likesAndSubs.getClosePbButton().click();
            sleep(300);
        }
        /*не ищет публикации и не ставит лайки если кол-во публикаций равно нулю.
        переходит к следующим действиям, а именно подписка на аккаунт.*/
        else if (amountOfPublications == 0) { }
        else {
            waitForElementToBeClickable(likesAndSubs.getPublication(driver));
            likesAndSubs.getPublication(driver).click();
            sleep(250);

            waitForElementToBeClickable(likesAndSubs.getLikeButton());
            likesAndSubs.getLikeButton().click();
            sleepLong();

            waitForElementToBeClickable(likesAndSubs.getNextPubButton1());
            likesAndSubs.getNextPubButton1().click();
            sleep(250);

            waitForElementToBeClickable(likesAndSubs.getLikeButton());
            likesAndSubs.getLikeButton().click();
            sleepLong();
            for (int iterX = 0; iterX < x - 2; iterX++) {
                waitForElementToBeClickable(likesAndSubs.getNextPubButton2());
                likesAndSubs.getNextPubButton2().click();
                sleep(250);

                waitForElementToBeClickable(likesAndSubs.getLikeButton());
                likesAndSubs.getLikeButton().click();
                sleepLong();
            }
            waitForElementToBeClickable(likesAndSubs.getClosePbButton());
            likesAndSubs.getClosePbButton().click();
            sleep(300);
        }
        sleep(325);
        scrollToWebElement(driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/nav")));
        waitForElementToBeClickable(likesAndSubs.getSubsButton(driver));
        likesAndSubs.getSubsButton(driver).click();

        Page.logger.info("Opened publications, liked it, closed it and subscribed successfully");
        sleep(515);
    }
}
