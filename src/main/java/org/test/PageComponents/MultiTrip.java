package org.test.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.test.AbstractComponents.AbstractComponent;
import org.test.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

    private By modalPopup= By.id("MultiCityModelAlert");
    private By from1=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By multiCityRdo=By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By  dest1=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By submit=By.id("ctl00_mainContent_btn_FindFlights");
    private By from2=By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By dest2=By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    //Execute Around Pattern
    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        System.out.println("Inside MultiTrip");
        findElement(multiCityRdo).click();
        findElement(modalPopup).click();
        waitForElementDisappear(modalPopup);
        consumer.accept(this);
        System.out.println("Done");

    }
    @Override
    public void checkAvail(HashMap<String,String> reservationDetails)  {
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        findElement(dest1).click();
        selectDestinationCity(reservationDetails.get("destination"));
        //Thread.sleep(2000);
        findElement(from2).click();
        selectOriginCity2(reservationDetails.get("origin"));
        findElement(dest2).click();
        selectDestinationCity2(reservationDetails.get("destination2"));
    }


    public void selectOriginCity(String origin)
    {
        findElement(from1).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();

    }

    public void selectOriginCity2(String origin)
    {

        findElement(By.xpath("(//a[@value='"+origin+"'])[2]")).click();

    }

    public void selectDestinationCity(String destination)
    {
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();

    }

    public void selectDestinationCity2(String destination)
    {
        findElement(By.xpath("(//a[@value='"+destination+"'])[3]")).click();

    }
}
