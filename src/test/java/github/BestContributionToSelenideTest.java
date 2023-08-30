package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BestContributionToSelenideTest {

    @Test
    void libinShouldBeTheTopContributor(){

        Configuration.holdBrowserOpen = true;

        //открыть страницу гита selenide
        open("https://github.com/selenide/selenide");
        //найти первого контрибьютора и вывести его хавер
        $(".Layout-sidebar").$(Selectors.byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        //проверка
        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));

    }
}