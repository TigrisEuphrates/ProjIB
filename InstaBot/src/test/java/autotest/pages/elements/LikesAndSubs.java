package autotest.pages.elements;

import autotest.core.annotations.DescriptionOfElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static autotest.core.base.BaseTest.instantiateDriver;

public class LikesAndSubs {

    public LikesAndSubs() {
        PageFactory.initElements(instantiateDriver(), this);
    }

    /*возвращает элемент указывающий на первую публикацию.*/
    public WebElement getPublication(WebDriver driver) {
        WebElement element;
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        if(driver.findElements(By.xpath("//*[@id=\"react-root\"]/section/main/div/div[2]/article/div[1]/div/div[1]/div[1]")).size() != 0){
            element = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/div[2]/article/div[1]/div/div[1]/div[1]"));
            return element;
        }
        element = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/div[3]/article/div[1]/div/div[1]/div[1]"));
        return element;
    }

    /*возвращает элемент указывающий на кнопку лайка.*/
    @Getter
    @DescriptionOfElement("like button")
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/article/div[3]/section[1]/span[1]/button")
    private WebElement likeButton;

    /*возвращает элемент указывающий на кнопку закрытия публикации.*/
    @Getter
    @DescriptionOfElement("close publication button")
    @FindBy(xpath = "/html/body/div[5]/div[3]/button")
    private WebElement closePbButton;

    /*возвращает элемент указывающий на кнопку подписки на аккаунт.
    * в зависимости от того, верифицированный аккаунт или нет, локатор кнопки отличается.
    * конструкция if позволяет вычислить необходимый локатор.*/
    public WebElement getSubsButton(WebDriver driver) {
        WebElement element;
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        if (driver.findElements(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/div[1]/div[2]/div/div/div/span/span[1]/button")).size() != 0) {
            element = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/div[1]/div[2]/div/div/div/span/span[1]/button"));
            return element;
        }
        element = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/div[1]/div[1]/div/div/div/span/span[1]/button"));
        return element;
    }

    /*возвращает элемент кнопки перехода к следующей публикации для первой публикации.*/
    @Getter
    @DescriptionOfElement("next publication button for first publication")
    @FindBy(xpath = "/html/body/div[5]/div[1]/div/div/a[1]")
    private WebElement nextPubButton1;

    /*возвращает элемент кнопки перехода к следующей публикации для остальных публикаций.*/
    @Getter
    @DescriptionOfElement("next publication button for other publications")
    @FindBy(xpath = "/html/body/div[5]/div[1]/div/div/a[2]")
    private WebElement nextPubButton2;
}
