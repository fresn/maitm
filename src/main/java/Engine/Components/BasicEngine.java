package Engine.Components;

import Enums.WebDriverType;
import Exceptions.*;
import Interfaces.Engine.Components.IBasicActions;
import Interfaces.IEventListeners;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicEngine extends SettingEngine implements IBasicActions {

    public BasicEngine(WebDriverType driverType, IEventListeners listeners) {
        super(driverType, listeners);
    }

    @Override
    public void openPage(String url) {
        try {
            this.driver.get(url);
        } catch (Exception e) {
            //TODO unhandled Exp
            System.out.println(e.getCause().toString());
        }
    }

    @Override
    public void click() throws NoneWindowOpenException, NoneElementException, ElementUnClickAbleException {
        if (isWindowOpened()) {
            if (this.currentElement != null) {
                if (this.currentElement.isDisplayed()) {
                    this.currentElement.click();
                } else {
                    throw new ElementUnClickAbleException();
                }
            } else {
                throw new NoneElementException();
            }
        } else {
            throw new NoneWindowOpenException();
        }
    }

    @Override
    public void sleep(long time) {
        try {
            Thread.currentThread().sleep(time * 1000);
        } catch (Exception e) {
            //TODO unhandled Exp
            e.printStackTrace();
        }
    }

    @Override
    public void waitForElementPresent(long waitTime, String xPath) throws TimeOutException, InvalidatedXPathException, NoneElementException {
        try {
            this.currentElement = new WebDriverWait(driver, waitTime).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        } catch (TimeoutException e) {
            throw new TimeOutException();
        } catch (IllegalArgumentException e) {
            throw new InvalidatedXPathException();
        } catch (NoSuchElementException e) {
            throw new NoneElementException();
        } catch (WebDriverException e) {
            //TODO WebDriverException
        }
    }

    @Override
    public void sendKeys(CharSequence keys) throws NoneWindowOpenException, NoneElementException, NoneKeyException {
        if (isWindowOpened()) {
            if (this.currentElement != null) {
                try {
                    this.currentElement.sendKeys(keys);
                } catch (IllegalArgumentException e) {
                    throw new NoneKeyException();
                }
            } else throw new NoneElementException();
        } else throw new NoneWindowOpenException();
    }

    public void quit() {
        driver.quit();
    }


    protected boolean isWindowOpened() {
        try {
            driver.getWindowHandle();
        } catch (NoSuchSessionException e) {
            return false;
        }
        return true;
    }
}
