package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue в рапозитории")
    @Story("Создание Issue")
    @Owner("Khan")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://testing.github.com")
    @DisplayName("Создание Issue для фвторизованного пользователя")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для фвторизованного пользователя")
        );
        Allure.feature("Issue в рапозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "Khan");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("GitHub", "https://testing.github.com");
    }
}
