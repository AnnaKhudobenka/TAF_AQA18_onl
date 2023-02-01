Feature: Параметризированные тесты

  Scenario: Параметризация степов
    Given открыт браузер
    * страница логина открыта
    When user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in
    Then title is "All projects"
    And project id is 123

  Scenario Outline: Параметризация при помощи таблицы значений
    Given открыт браузер
    * страница логина открыта
    When user "<username>" with password "<password>" logged in
    Then title is "All projects"
    And project id is 123
    Examples:
      | username | password |
      | atrostyanko@gmail.com | Qwertyu_1 |
      | atrostyanko@gmailcom | Qwertyu_1 |
