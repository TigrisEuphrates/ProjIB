package autotest.pages.elements;

import autotest.core.annotations.DescriptionOfElement;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInAndSignOut extends LikesAndSubs {
    /*возвращает элемент указывающий на строку ввода логина.*/
    @DescriptionOfElement("Login")
    @Getter
    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[1]/div/label/input")
    private WebElement LoginInput;

    /*возвращает элемент указывающий на строку ввода пароля.*/
    @DescriptionOfElement("Password")
    @Getter
    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[2]/div/label/input")
    private WebElement PasswordInput;

    /*возвращает элемент указывающий на кнопку входа в аккаунт.*/
    @DescriptionOfElement("LogIn button")
    @Getter
    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[3]/button")
    private WebElement loginButton;

    /*возвращает элемент указывающий на кнопку открывающую меню вашего аккаунта.*/
    @DescriptionOfElement("Profile menu button")
    @Getter
    @FindBy(xpath = "//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[3]/div/div[5]/span")
    private WebElement ProfMenuBtn;

    /*возвращает элемент указывающий на кнопку выхода из аккаунта.*/
    @DescriptionOfElement("Log out button")
    @Getter
    @FindBy(xpath = "//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[3]/div/div[5]/div[2]/div[2]/div[2]/div[2]/div")
    private WebElement LogOutBtn;
}
