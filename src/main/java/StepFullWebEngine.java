import Enums.WebDriverType;
import Exceptions.*;
import Interfaces.IEventListeners;
import Interfaces.IStep;
import Interfaces.Engine.IStepFullWebEngine;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        this.driver.manage().window().setSize(new Dimension(1024, 768));
        this.eventListeners = listeners;
    }

    /**
     *
     * */
    public IStepFullWebEngine setDefaultWaitingTime(long time) {

        defaultWaitingTime = time;

        return this;
    }


    public IStepFullWebEngine waitForElementPresent(Long waitTime, String xPath, String stepName) throws TimeOutException, InvalidatedXPathException, NoneElementException {

        return waitForElementPresent(waitTime, xPath);
    }

    public IStepFullWebEngine waitForElementPresent(long waitTime, String xPath) throws TimeOutException, InvalidatedXPathException, NoneElementException {
        try {
            currentElement = new WebDriverWait(driver, waitTime).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        } catch (TimeoutException e) {
            throw new TimeOutException();
        } catch (IllegalArgumentException e) {
            throw new InvalidatedXPathException();
        } catch (NoSuchElementException e) {
            throw new NoneElementException();
        } catch (WebDriverException e) {
            //TODO WebDriverException
        }
        return this;
    }

    public IStepFullWebEngine waitForElementPresentAndClick(Long waitingTime, String xPath, String stepName) throws ElementUnClickAbleException, NoneElementException, NoneWindowOpenException, InvalidatedXPathException, TimeOutException {
        waitForElementPresent(waitingTime, xPath, stepName + "waitForElementPresent");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", currentElement);
        click(stepName + "click");
        return this;
    }

    @Override
    public IStepFullWebEngine waitForElementPresentAndClick(Long waitingTime, Long sleepingTime, String xPath, String stepName) throws ElementUnClickAbleException, NoneElementException, NoneWindowOpenException, InvalidatedXPathException, TimeOutException {
        waitForElementPresentAndClick(waitingTime, xPath, stepName);
        sleep(sleepingTime, stepName + "sleep");
        return this;
    }

    public IStepFullWebEngine waitForElementPresentAndSendKeys(Long waitingTime, String xPath, CharSequence keys, String stepName) throws NoneKeyException, NoneElementException, NoneWindowOpenException, InvalidatedXPathException, TimeOutException, ElementUnClickAbleException {
        waitForElementPresent(waitingTime, xPath, stepName + "waitForElementPresent");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", currentElement);
        click(stepName + "click");
        sendKeys(keys);
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", currentElement);
        return this;
    }

    public IStepFullWebEngine waitForElementPresentAndSelect(Long waitingTime, String xPath, String selectedValue, String stepName) throws TimeOutException, InvalidatedXPathException, NoneElementException, NoneSelectedValueException {
        waitForElementPresent(waitingTime, xPath, stepName + "waitForElementPresent");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", currentElement);
        try {
            (new Select(currentElement)).selectByVisibleText(selectedValue);
        } catch (NoSuchElementException e) {
            throw new NoneSelectedValueException();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", currentElement);
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

    public IStepFullWebEngine openPage(String url, String stepName) {
        return openPage(url);
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

    public IStepFullWebEngine sleep(long time, String stepName) {
        return sleep(time);
    }


    public IStepFullWebEngine click(String stepName) throws NoneElementException, NoneWindowOpenException, ElementUnClickAbleException {
        return click();
    }

    public IStepFullWebEngine click() throws NoneWindowOpenException, NoneElementException, ElementUnClickAbleException {
        if (isWindowOpened()) {
            if (currentElement != null) {
                if (currentElement.isDisplayed()) {
                    currentElement.click();
                } else {
                    throw new ElementUnClickAbleException();
                }
            } else {
                throw new NoneElementException();
            }
        } else {
            throw new NoneWindowOpenException();
        }
        return this;
    }


    public boolean isElementPresent(String xPath) throws InvalidatedXPathException {
        try {
            currentElement = driver.findElement(By.xpath(xPath));
        } catch (NoSuchElementException e) {
            return false;
        } catch (IllegalArgumentException e) {
            throw new InvalidatedXPathException();
        }
        return true;
    }

    public boolean isElementDisplayed(String xPath) throws InvalidatedXPathException {
        if (isElementPresent(xPath)) {
            if (currentElement.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public boolean isElementSelected(String xPath) throws InvalidatedXPathException {
        if (isElementPresent(xPath)) {
            if (currentElement.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public boolean isElementInnerTextEquals(String xPath, String text) throws InvalidatedXPathException {
        if (isElementPresent(xPath)) {
            if (currentElement.getText().equals(text)) {
                return true;
            }
        }
        return false;
    }


    public IStepFullWebEngine sendKeys(CharSequence keys) throws NoneWindowOpenException, NoneElementException, NoneKeyException {
        if (isWindowOpened()) {
            if (currentElement != null) {
                try {
                    currentElement.sendKeys(keys);
                } catch (IllegalArgumentException e) {
                    throw new NoneKeyException();
                }
            } else throw new NoneElementException();
        } else throw new NoneWindowOpenException();
        return this;
    }


    public void quit() {
        driver.quit();
    }


    private boolean isWindowOpened() {
        try {
            driver.getWindowHandle();
        } catch (NoSuchSessionException e) {
            return false;
        }
        return true;
    }
}
