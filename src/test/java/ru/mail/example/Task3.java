package ru.mail.example;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.example.data.FooterLink;
import ru.mail.example.driver.DriverProvider;
import ru.mail.example.steps.AutoMainPageSteps;

@DisplayName("Авто. Подвал. Ссылка \"Условия использования материалов\"")
public class Task3{
        private DriverProvider driverProvider = null;

        @Before
        public void initDriver() {
            driverProvider = new DriverProvider();
        }

        @After
        public void closeDriver() {
            driverProvider.closeDriver();
        }

        @Test
        @Severity(SeverityLevel.BLOCKER)
        public void test3() {
            AutoMainPageSteps steps = new AutoMainPageSteps(driverProvider.getDriver());
            steps.open("Авто Mail.Ru: тест-драйвы, новости авторынка, авто-обзоры");
            steps.clickLink(FooterLink.Policy);
            steps.checkUrl("https://auto.mail.ru/policy/");
        }
}
