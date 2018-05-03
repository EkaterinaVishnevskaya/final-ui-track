package ru.mail.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.mail.example.data.FooterLink;
import ru.mail.example.navigation.Page;
import ru.mail.example.navigation.UrlPattern;

@Page()
@UrlPattern()
public class AutoMainPage extends AbstractPage  {

    public AutoMainPage(WebDriver driver) {
        super(driver);
    }

    private String FooterLinkSelector = "//a[@class='footer__link'][.='%s']";

    public WebElement getFooterLink (FooterLink link) {
        String selector = String.format(FooterLinkSelector, link.name());
        return getDriver().findElement(By.xpath(selector));
    }
}
