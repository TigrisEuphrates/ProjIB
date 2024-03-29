Требования:
скачать и установить:
    - jdk8
    - maven
    - плагин Lombok
Автотест использует фреймворк тестирования Testng. Паттерном проектирования автотеста является PageObjectPattern.
Структура автотеста разделена на 3 части:
1) Пакет core - состоит из нескольких подпакетов. Этот пакет является конфигурационным и базовым.
    1) base - хранит базовые настройки для страниц и тестов. 
    2) business - отделение бизнес логики от реализации.
    3) data - хранит тестовые данные.
    4) helper - хранит вспомогательные классы к базовым.
    5) manager - конфигурация драйвера.
2) Пакет pages - состоит из 2 пакетов, они разделены так чтобы элементы на страницах хранились отдельно
от их использования. К примеру, класс SignInAndSignOut хранит элементы, а SignInAndSignOutHelper производит действия
над этими элементами.
    Пакет actions:
    1)SignInAndSignOutHelper - реализует логику входа и выхода из вашего аккаунта.
    2)SearchingAccHelper - реализует логику поиска случайного аккаунта и его открытия.
    3)LikesAndSubsHelper - реализует логику открытия публикации, нажатие на кнопку лайка, переход
    к следующим, нажатие на кнопку лайка у следующих и нажатие на кнопку подписки на аккаунт.
3) Пакет tests - состоит из тестового класса.

Ресурсный пакет(resources) хранит конфигурационный файл(Config.properties), и сам testng файл.

Чтобы запустить бота достаточно открыть проект, и правой кнопкой мыши запустить instaBot.xml файл который расположен в resources/runner.

В Intellij idea  нужно настроить java на версию 1.8, а также в настройках поставить галочку на пункте Enable annotation processing.

В данном автотесте используется библиотека WebDriverManager.

Алгоритм автотеста таков что:
    1)открывается браузер, происходит переход на страницу входа в ваш аккаунт и авторизация.
    2)производится поиск случайного аккаунта и его открытие.
    3)ставятся лайки и производится подписка на аккаунт, если страница профиля соответствует всем требованиям.
    4)второй и третий пункт повторяется пять раз.
    5)автотест выходит из вашего аккаунта, закрывает браузер тем самым завершается.

Данный автотест обрабатывает ситуации при которых найденная страница является закрытым аккаунтом и перезагружает тест.
Автотест обрабатывает ситуации при которых найденная страница является хештегом, либо аккаунтом над которым
уже произвели действия и в таких случаях продолжает искать аккаунты.
Также автотест обрабатывает ситуации при которых количество публикаций на странице аккаунта меньше десяти вплоть до нуля.
В случае если публикаций меньше 10, лайки ставятся такому количеству публикаций которое имеется.
В случае если публикаций нет, автотест просто подписывается на аккаунт.

Проанализировав данные с интернет ресурсов в которых говорится что во избежание бана, новым аккаунтам желательно не ставить
больше 25(примерно) лайков в час, было выставлено значение 144 000 миллисекунд(144 секунды) для паузы между лайками.
При желании скорость можно изменить.
Изменить скорость автотеста можно изменением значения переменной selectDuration в методе sleepLong находящейся в данном расположении: src/test/java/autotest/core/base/BasePage.java.
Изменить данные для авторизации можно изменением значений объекта Bot находящегося в данном расположении: src/test/java/autotest/core/base/BaseTest.java.

выполнил Рахметов Самурат