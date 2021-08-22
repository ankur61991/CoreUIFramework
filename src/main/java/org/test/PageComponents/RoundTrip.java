package org.test.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.test.AbstractComponents.AbstractComponent;
import org.test.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {

    private By rdo= By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from= By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By cb=By.id("ctl00_mainContent_chk_IndArm");
    private By submit=By.id("ctl00_mainContent_btn_FindFlights");
    private By to=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");


    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String,String> reservationDetails) throws InterruptedException {
        System.out.println("Inside RoundTrip");
        findElement(rdo).click();
        findElement(from).click();
        selectOriginCity(reservationDetails.get("origin"));
        findElement(to).click();
        selectDestinationCity(reservationDetails.get("destination"));
        Thread.sleep(1000);
        findElement(cb).click();
        findElement(submit).click();
    }

    public void selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();

    }

    public void selectDestinationCity(String destination)
    {
        findElement(By.xpath("//a[@value='"+destination+"']")).click();

    }
}
