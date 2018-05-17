import Enums.WebDriverType;
import Interfaces.IEventListeners;
import Interfaces.IStepManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class StepFullWebEngine {
    private final IEventListeners eventListeners;
    private final IStepManager stepManager;
    private WebElement currentElement;
    private EventFiringWebDriver driver;

    private long defaultWaitingTime = 10L;

    public StepFullWebEngine(WebDriverType driverType, IEventListeners listeners, IStepManager stepManager) {
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
        this.stepManager = stepManager;
    }

    /**
     *
     * */
    public StepFullWebEngine setDefaultWaitingTime(long time) {

        defaultWaitingTime = time;

        return this;
    }


    public StepFullWebEngine WaitForElementPresent(String xPath, Long waitingTime, String stepName) {
        try {
            currentElement = driver.findElement(By.xpath(xPath));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return this;
    }


}
