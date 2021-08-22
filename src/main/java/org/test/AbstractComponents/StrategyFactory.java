package org.test.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.test.PageComponents.MultiTrip;
import org.test.PageComponents.RoundTrip;

public class StrategyFactory {

    WebDriver driver;
    By sectionElement=By.id("flightSearchContainer");

    public StrategyFactory(WebDriver driver) {
        this.driver=driver;
    }

    public SearchFlightAvail createStrategy(String strategyType)
    {
        if(strategyType.equalsIgnoreCase("multiTrip"))
        {
            return new MultiTrip(driver,sectionElement);
        }

        if(strategyType.equalsIgnoreCase("roundTrip"))
        {
            return new RoundTrip(driver,sectionElement);
        }
        return null;
    }


}
