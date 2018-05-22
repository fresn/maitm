package Engine.Components;

import Enums.WebDriverType;
import Exceptions.InvalidatedXPathException;
import Interfaces.Engine.Components.ICheckActions;
import Interfaces.IEventListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public abstract class CheckEngine extends GetEngine implements ICheckActions {
    public CheckEngine(WebDriverType driverType, IEventListeners listeners) {
        super(driverType, listeners);
    }

    @Override
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

    @Override
    public boolean isElementDisplayed(String xPath) throws InvalidatedXPathException {
        if (isElementPresent(xPath)) {
            if (currentElement.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isElementSelected(String xPath) throws InvalidatedXPathException {
        if (isElementPresent(xPath)) {
            if (currentElement.isSelected()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isElementInnerTextEquals(String xPath, String text) throws InvalidatedXPathException {
        if (isElementPresent(xPath)) {
            if (currentElement.getText().equals(text)) {
                return true;
            }
        }
        return false;
    }
}
