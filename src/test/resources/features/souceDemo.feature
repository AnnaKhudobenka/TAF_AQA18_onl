Feature: Тестирование сайта saucedemo.com

  Scenario Outline: Пройти авторизацию и осуществить оформление заказа
    Given открыта страница авторизации
    * пройдена авторизация пользователя <username> с паролем <password>
    * добавлен товар в корзину
    * переход на страницу оплаты товара
    * введены данные для оплаты: имя <firstname>, фамилия <lastname>, зипкод <zipcode>
    * завершена оплата товара и возвращение на главную станицу
    Examples:
      | username        | password       | firstname | lastname | zipcode |
      | "standard_user" | "secret_sauce" | "Ivan"    | "Ivanov" | "11111" |