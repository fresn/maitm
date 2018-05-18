import Enums.WebDriverType;
import Interfaces.IEventListeners;
import Interfaces.IStep;
import Interfaces.Engine.IStepFullWebEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class StepFullWebEngine implements IStepFullWebEngine {
    protected final IEventListeners eventListeners;
    private WebElement currentElement;
    private EventFiringWebDriver driver;
    private ArrayList<IStep> steps;

    private long defaultWaitingTime = 10L;

    public StepFullWebEngine(WebDriverType driverType, IEventListeners listeners, ArrayList<IStep> steps) {

        this.steps = steps;

        //creating drive
        switch (driverType) {
            case CHROME_DRIVE:
                this.driver = new EventFiringWebDriver(new ChromeDriver());
        }

        //setting drive TODO temp settings
        //set implicitlyWait to 0 in order to getXXX immediately
        this.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(800, 600));
        this.eventListeners = listeners;

    }

    /**
     *
     * */
    public IStepFullWebEngine setDefaultWaitingTime(long time) {

        defaultWaitingTime = time;

        return this;
    }

    public IStepFullWebEngine waitForElementPresent(String xPath, Long waitingTime, String stepName) {
        try {
            currentElement = new WebDriverWait(driver, waitingTime).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return this;
    }

    public IStepFullWebEngine openPage(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            //TODO unhandled Exp
            System.out.println(e.getCause().toString());
        }


        return this;
    }

    public IStepFullWebEngine closePage() {
        driver.close();

        return this;
    }

    public IStepFullWebEngine sleep(long time) {
        try {
            Thread.currentThread().sleep(time * 1000);
        } catch (Exception e) {
            //TODO unhandled Exp
            e.printStackTrace();
        }


        return this;
    }

    public void quit() {
        driver.quit();
    }


}
