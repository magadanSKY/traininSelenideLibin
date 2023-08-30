package github;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {


    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        Configuration.holdBrowserOpen = true;

        //открыть главную страницу
        open("https://github.com/");
        //ввести в поле поиска selenide и нажать enter22
        $(".search-input").click();
        $("[data-target=\"query-builder.input\"]").setValue("selenide").pressEnter();
        //кликнуть первый репозиторий из списка найденных
        $$("div.Box-sc-g0xbh4-0.bBwPjs.search-title").first().click();
        //проверка заголовка selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        //клик по меню веток
        $("#branch-select-menu").click();
        //success
        $("#context-commitish-filter-field").setValue("success");
        //click view all branches
        $(".SelectMenu-footer").click();

    }
}