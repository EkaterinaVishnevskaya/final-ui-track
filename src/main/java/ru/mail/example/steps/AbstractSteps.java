package ru.mail.example.steps;

import org.openqa.selenium.WebDriver;
import ru.mail.example.navigation.PageObject;

/**
 * Абстрактные Шаги
 */
public abstract class AbstractSteps extends PageObject {

    public AbstractSteps(WebDriver driver) {
        super(driver);
    }
}
