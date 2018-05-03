package ru.mail.example;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.example.data.FooterLink;
import ru.mail.example.driver.DriverProvider;
import ru.mail.example.pages.TestDrivePage;
import ru.mail.example.steps.TestDrivePageSteps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@DisplayName("Авто. Тест-драйвы. Подвал. Ссылка \"Мобильная версия\"")
public class Task4 {
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
    public void test4() {
        TestDrivePageSteps steps = new TestDrivePageSteps(driverProvider.getDriver());
        steps.open("Тест-драйвы автомобилей. Test-drive авто на сайте Авто Mail.Ru");
        assertFalse(steps.isMobile());
        steps.clickLink(FooterLink.Mobile);
        assertTrue(steps.isMobile());
    }
}
