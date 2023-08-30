package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class homeworkWikiAssertion {

    @Test
    void wikiAssertion() {
        Configuration.holdBrowserOpen = true;

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        sleep(10000);
        $(".wiki-rightbar").$$(byText("Show 2 more pages…")).first().click();
        sleep(10000);
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        //Откройте страницу SoftAssertions,
        $("[data-filterable-for=wiki-pages-filter]").$$(byText("SoftAssertions")).first().click();
        // проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));

    }
}