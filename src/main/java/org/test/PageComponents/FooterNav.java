package org.test.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.test.AbstractComponents.AbstractComponent;

public class FooterNav extends AbstractComponent {
    WebDriver driver;
    By flights= By.cssSelector("[title='Flights']");
    By links=By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
    }

    public String getFlightAttribute()
    {
        return findElement(flights).getAttribute("class");
        //findElement(flights).click();

    }
    public int getLinkCount()
    {
        return findElements(links).size();

    }
}

