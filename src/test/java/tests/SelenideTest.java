package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;


public class SelenideTest extends BaseTest {

    @Test
    public void loginTest() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        SelenideElement loginButton = $("#button_primary");
        loginButton
                .should(exist, enabled)
                .shouldBe(enabled)
                .click();
        // методы .val (=getValue) .press - нажатие клавиши конкретной (их 3)
        // .selectOption - выбор элемента Select .selectRadio - выбор элемента RadioButton
        // .append - добавить значение в поле (к имеющемуся значению)
        // .getWrapped - получить родительский элемент
        // .attr - имя атрибута передаем




//        $(withText("All Projects"))
//                .shouldBe(visible)
//                .shouldHave(text("All Projects"));

        $(By.xpath("//div[contains(text(), 'All Projects')]"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(withText("All Projects"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(byText("All Projects")) // конкретный текст ищет
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(byTitle("All Projects")) // текст, который в самой закладке в браузере виден
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(byValue("All Projects")) // элементы в атрибуте value
                .shouldBe(visible)
                .shouldHave(text("All Projects"));


        $$(withText("All Projects"))
                //.shouldBe(empty)
                .shouldBe(size(12))
                .shouldHave(texts("ee",
                        "eee", "www"))
                .texts();
                //.shouldHave(exactTexts("ee",
//                        "eee", "www"))
//                .texts();

        $$(withText("All Projects"))
                .filterBy(text("qwerty"))
                .excludeWith(hidden)
                .findBy(visible);
               // .get(1);

        isChrome(); // проверка на браузер
    }

    @Test
    public void loginTest2() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        SelenideElement loginButton = $("#button_primary");
        loginButton
                .should(exist, enabled)
                .shouldBe(enabled)
                .click();

        $(By.xpath("//div[contains(text(), 'All Projects')]"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));


    }


}
