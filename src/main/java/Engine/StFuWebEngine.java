package Engine;

import Engine.Components.CheckEngine;
import Enums.WebDriverType;
import Events.WebEventListeners;
import Exceptions.*;
import Interfaces.Engine.Components.IStepActions;
import Interfaces.Engine.IStepFullWebEngine;
import Interfaces.IEventListeners;
import Interfaces.IStep;
import Step.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

public class StFuWebEngine extends CheckEngine implements IStepActions, IStepFullWebEngine {
    private IStep currentStep = null;

    public static IStepFullWebEngine getEngine() {
        return new StFuWebEngine(WebDriverType.CHROME_DRIVE, new WebEventListeners());
    }

    private StFuWebEngine(WebDriverType driverType, IEventListeners listeners) {
        super(driverType, listeners);
    }

    @Override
    public IStepFullWebEngine openPage(String url, String stepName) throws Exception {
        IStep myStep = new Step(stepName);
        IStep previousStep = this.currentStep;
        this.currentStep = myStep;
        this.steps.add(myStep);
        myStep.stepStart();


        openPage(url);


        currentStep = previousStep;
        myStep.stepEnd();

        return this;
    }

    @Override
    public IStepFullWebEngine click(String stepName) throws Exception {
        IStep myStep = new Step(stepName);
        IStep previousStep = this.currentStep;
        this.currentStep = myStep;
        this.steps.add(myStep);
        myStep.stepStart();

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

        currentStep = previousStep;
        myStep.stepEnd();

        return this;
    }

    @Override
    public IStepFullWebEngine closePage(String stepName) throws Exception {
        IStep myStep = new Step(stepName);
        IStep previousStep = this.currentStep;
        this.currentStep = myStep;
        this.steps.add(myStep);
        myStep.stepStart();


        driver.close();


        currentStep = previousStep;
        myStep.stepEnd();

        return this;
    }

    @Override
    public IStepFullWebEngine sleep(long waitTime, String stepName) throws Exception {
        IStep myStep = new Step(stepName);
        IStep previousStep = this.currentStep;
        this.currentStep = myStep;
        this.steps.add(myStep);
        myStep.stepStart();


        sleep(waitTime);


        currentStep = previousStep;
        myStep.stepEnd();

        return this;
    }

    @Override
    public IStepFullWebEngine waitForElementPresent(String xPath, String stepName) throws Exception {
        return waitForElementPresent(defaultWaitTime, xPath, stepName);
    }

    @Override
    public IStepFullWebEngine waitForElementPresent(Long waitingTime, String xPath, String stepName) throws Exception {
        IStep myStep = new Step(stepName);
        IStep previousStep = this.currentStep;
        this.currentStep = myStep;
        this.steps.add(myStep);
        myStep.stepStart();


        waitForElementPresent(waitingTime, xPath);


        currentStep = previousStep;
        myStep.stepEnd();

        return this;
    }

    @Override
    public IStepFullWebEngine waitForElementPresentAndClick(String xPath, String stepName) throws Exception {

        return waitForElementPresentAndClick(defaultWaitTime, xPath, stepName);
    }

    @Override
    public IStepFullWebEngine waitForElementPresentAndClick(Long waitingTime, String xPath, String stepName) throws Exception {
        return waitForElementPresentAndClick(waitingTime, xPath, stepName, 0L);
    }

    @Override
    public IStepFullWebEngine waitForElementPresentAndClick(String xPath, String stepName, Long sleepingTime) throws Exception {
        return waitForElementPresentAndClick(defaultWaitTime, xPath, stepName, sleepingTime);
    }

    @Override
    public IStepFullWebEngine waitForElementPresentAndClick(Long waitingTime, String xPath, String stepName, Long sleepingTime) throws Exception {
        IStep myStep = new Step(stepName);
        IStep previousStep = this.currentStep;
        this.currentStep = myStep;
        this.steps.add(myStep);
        myStep.stepStart();

        waitForElementPresent(waitingTime, xPath, stepName + " waitForElementPresent");
        click(stepName + " click");

        Thread.currentThread().sleep(sleepingTime * 1000);
        currentStep = previousStep;
        myStep.stepEnd();

        return this;
    }


    @Override
    public IStepFullWebEngine waitForElementPresentAndSendKeys(String xPath, CharSequence keys, String stepName) throws Exception {
        return waitForElementPresentAndSendKeys(defaultWaitTime, xPath, keys, stepName);
    }

    @Override
    public IStepFullWebEngine waitForElementPresentAndSendKeys(Long waitingTime, String xPath, CharSequence keys, String stepName) throws Exception {
        IStep myStep = new Step(stepName);
        IStep previousStep = this.currentStep;
        this.currentStep = myStep;
        this.steps.add(myStep);
        myStep.stepStart();

        waitForElementPresent(waitingTime, xPath, stepName + " waitForElementPresent");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", currentElement);
        click(stepName + " click");
        sendKeys(keys);
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", currentElement);


        currentStep = previousStep;
        myStep.stepEnd();

        return this;
    }

    @Override
    public IStepFullWebEngine waitForElementPresentAndSelect(String xPath, String selectValue, String stepName) throws Exception, NoneSelectedValueException {
        return waitForElementPresentAndSelect(defaultWaitTime, xPath, selectValue, stepName);
    }

    @Override
    public IStepFullWebEngine waitForElementPresentAndSelect(Long waitingTime, String xPath, String selectValue, String stepName) throws Exception, NoneSelectedValueException {
        IStep myStep = new Step(stepName);
        IStep previousStep = this.currentStep;
        this.currentStep = myStep;
        this.steps.add(myStep);
        myStep.stepStart();

        waitForElementPresent(waitingTime, xPath, stepName + " waitForElementPresent");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", currentElement);
        try {
            (new Select(currentElement)).selectByVisibleText(selectValue);
        } catch (NoSuchElementException e) {
            throw new NoneSelectedValueException();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", currentElement);

        currentStep = previousStep;
        myStep.stepEnd();

        return this;
    }

    @Override
    public String waitForElementPresentAndGetText(String xPath, String stepName) throws Exception {
        return waitForElementPresentAndGetText(defaultWaitTime, xPath, stepName);
    }

    @Override
    public String waitForElementPresentAndGetText(Long WaitingTime, String xPath, String stepName) throws Exception {
        IStep myStep = new Step(stepName);
        IStep previousStep = this.currentStep;
        this.currentStep = myStep;
        this.steps.add(myStep);
        myStep.stepStart();

        waitForElementPresent(WaitingTime, xPath, stepName + " waitForElementPresent");


        currentStep = previousStep;
        myStep.stepEnd();

        return getText();
    }
}
