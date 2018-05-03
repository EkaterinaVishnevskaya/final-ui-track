package ru.mail.example;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.example.data.FooterLink;
import ru.mail.example.driver.DriverProvider;
import ru.mail.example.steps.TestDrivePageSteps;

@DisplayName("Авто. Тест-драйвы. Подвал. Ссылка \"Реклама\"")
public class Task5 {
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
    public void test5() {
        TestDrivePageSteps steps = new TestDrivePageSteps(driverProvider.getDriver());
        steps.open();
        steps.checkRedirect(FooterLink.Advert, "http://sales.mail.ru/ru/russia/auto/latest/#price");
    }
}
