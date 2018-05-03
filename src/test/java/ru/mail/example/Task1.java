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

@DisplayName("Авто. Подвал. Ссылка \"Mail.Ru\"")
public class Task1 {
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
    public void test1() {
        AutoMainPageSteps steps = new AutoMainPageSteps(driverProvider.getDriver());
        steps.open();
        steps.clickLink(FooterLink.Mailru);
        steps.checkUrl("https://mail.ru/");
    }
}
