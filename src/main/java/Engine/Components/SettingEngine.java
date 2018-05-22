package Engine.Components;

import Enums.WebDriverType;
import Interfaces.Engine.Components.ISettings;
import Interfaces.IEventListeners;
import Interfaces.IStep;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class SettingEngine implements ISettings {
    protected final IEventListeners eventListeners;
    protected WebElement currentElement;
    protected EventFiringWebDriver driver;
    protected long defaultWaitTime = 10;
    protected ArrayList<IStep> steps = new ArrayList<Interfaces.IStep>();

    public SettingEngine(WebDriverType driverType, IEventListeners listeners) {
        switch (driverType) {
            case CHROME_DRIVE:
                this.driver = new EventFiringWebDriver(new ChromeDriver());
        }

        //setting drive TODO temp settings
        //set implicitlyWait to 0 in order to getXXX immediately
        this.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(1024, 768));
        this.eventListeners = listeners;
    }


    @Override
    public void setDefaultWaitingTime(long time) {
        this.defaultWaitTime = time;
    }
}
