package home.work;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepAnnotationTest {

    private static final String REPOSITORY = "Khan-qa/-demoqa-tests-15";
    private static final String ISSUE = "Нет проверки дня и месяца";

    @Test
    public void testAnnotatedStep() {
        StepLibrary stepLibrary = new StepLibrary();
        SelenideLogger.addListener("allure", new AllureSelenide());

        stepLibrary.openMainPage();
        stepLibrary.searchForRepository(REPOSITORY);
        stepLibrary.clickOnRepositoryLink(REPOSITORY);
        stepLibrary.openIssuesTab();
        stepLibrary.shouldSeeIssueWithNumber(ISSUE);
    }
}
