package ru.mail.example.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.data.FooterLink;
import ru.mail.example.pages.TestDrivePage;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestDrivePageSteps extends AbstractSteps {
    private TestDrivePage testDrivePage = null;
    public TestDrivePageSteps(WebDriver driver) {
        super(driver);
        testDrivePage = PageFactory.initElements(driver, TestDrivePage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                testDrivePage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open(String header) {
        testDrivePage.open();
        testDrivePage.pageValidate();
        pageHeaderShouldBeSameAs(header);
    }

    @Step("Кликаем по ссылке")
    public void  clickLink(FooterLink link) {
        testDrivePage.getFooterLink(link).click();
    }

    @Step("Проверяем, что мы перешли на нужную страницу")
    public void checkRedirect(FooterLink link, String url) {
        Set<String> oldHandles = getDriver().getWindowHandles();
        clickLink(link);
        Set<String> newHandles = getDriver().getWindowHandles();

        newHandles.removeAll(oldHandles);
        getDriver().switchTo().window(newHandles.iterator().next());

        assertEquals(url, getDriver().getCurrentUrl());
    }

    @Step("Проверяем,  мобильная версия или полная")
    public boolean isMobile() {
        return getDriver().findElement(By.cssSelector("#fb-root")).isEnabled()
                ;
    }
}
