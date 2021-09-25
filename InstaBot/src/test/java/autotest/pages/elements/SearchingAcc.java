package autotest.pages.elements;

import autotest.core.annotations.DescriptionOfElement;
import autotest.core.helper.Randomizer;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchingAcc extends LikesAndSubs {

    /*возвращает элемент указывающий на поисковую строку.*/
    @DescriptionOfElement("Поиск")
    @Getter
    @FindBy(xpath = "//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[2]/input")
    private WebElement searchInput;

    /*возвращает элемент указывающий на случайный аккаунт из списка аккаунтов,
    раскрытого после ввода случайной буквы в поисковую строку.*/
    public WebElement getRandomAccountClick(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[" + Randomizer.randInt() + "]"));
        return element;
    }
}
