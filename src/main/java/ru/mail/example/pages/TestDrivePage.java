package ru.mail.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.mail.example.data.FooterLink;
import ru.mail.example.navigation.Page;
import ru.mail.example.navigation.UrlPattern;

@Page("/testdrives")
@UrlPattern("/testdrives")
public class TestDrivePage extends AbstractPage{
    public TestDrivePage(WebDriver driver) {
        super(driver);
    }

    private String FooterLinkSelector = "//a[.='%s']";

    public WebElement getFooterLink (FooterLink link) {
        String selector = String.format(FooterLinkSelector, link.name());
        return getDriver().findElement(By.xpath(selector));
    }
}

