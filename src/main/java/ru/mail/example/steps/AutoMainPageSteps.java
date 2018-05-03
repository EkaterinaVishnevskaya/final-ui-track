package ru.mail.example.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.data.FooterLink;
import ru.mail.example.pages.AutoMainPage;

import static org.junit.Assert.assertEquals;

public class AutoMainPageSteps extends AbstractSteps{
    private AutoMainPage autoMainPage = null;

    public AutoMainPageSteps(WebDriver driver) {
        super(driver);
        autoMainPage = PageFactory.initElements(driver, AutoMainPage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                autoMainPage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open() {
        autoMainPage.open();
        autoMainPage.pageValidate();
    }

    @Step("Кликаем по ссылке")
    public void  clickLink(FooterLink link) {
        autoMainPage.getFooterLink(link).click();
    }

    @Step("Проверяем, что мы перешли на другую страницу")
    public void checkUrl(String url) {
        assertEquals(url, getDriver().getCurrentUrl());
    }
}
