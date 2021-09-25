package autotest.core.business;

import lombok.Getter;

/*
* Класс User - Пользователь веб приложения вынесен в отдельный класс для отделения
* бизнес логики от тестирования и классов страниц
*/
public class User {
    @Getter
    private final String login;
    @Getter
    private final String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
