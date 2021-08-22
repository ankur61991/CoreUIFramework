package org.test.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.test.AbstractComponents.SearchFlightAvail;
import org.test.AbstractComponents.StrategyFactory;
import org.test.PageComponents.FooterNav;
import org.test.PageComponents.MultiTrip;
import org.test.PageComponents.NavigationBar;

import java.util.HashMap;

public class TravelHomePage {

    By sectionElement= By.id("traveller-home");
    By navsectionElement=By.id("buttons");
    SearchFlightAvail searchFlightAvail;
    WebDriver driver;

    public TravelHomePage(WebDriver driver) {
        this.driver=driver;
    }

    public void goTo()
    {
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
    }
    public NavigationBar getNavigationBar()
    {

        return new NavigationBar(driver,navsectionElement);
    }

    public FooterNav getFooterNav()
    {

        return new FooterNav(driver, sectionElement);
    }

    public void setBookingStrategy(String strategyType)
    {
        StrategyFactory sf= new StrategyFactory(driver);
        searchFlightAvail=sf.createStrategy(strategyType);
        this.searchFlightAvail  = searchFlightAvail;
    }



    public void checkAvail(HashMap<String,String> reservationDetails) throws InterruptedException {
        searchFlightAvail.checkAvail(reservationDetails);

    }
}
