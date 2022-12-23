package home.work;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideListenerTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").setValue("Khan-qa/-demoqa-tests-15");
        $(".header-search-input").submit();


        $(linkText("Khan-qa/-demoqa-tests-15")).click();
        $("#issues-tab").click();
        $(withText("Нет проверки дня и месяца")).should(Condition.exist);

    }
}
