package Interfaces.Engine.Components;

import Exceptions.*;
import Interfaces.Engine.IStepFullWebEngine;
import Step.Step;

public interface IStepActions {

    IStepFullWebEngine openPage(String url, String stepName);

    IStepFullWebEngine click(String stepName) throws NoneWindowOpenException, NoneElementException, ElementUnClickAbleException;

    IStepFullWebEngine closePage();

    IStepFullWebEngine sleep(long time, String stepName);

    IStepFullWebEngine waitForElementPresent(Long waitingTime, String xPath, String stepName) throws TimeOutException, InvalidatedXPathException, NoneElementException;

    IStepFullWebEngine waitForElementPresentAndClick(Long waitingTime, String xPath, String stepName) throws ElementUnClickAbleException, NoneElementException, NoneWindowOpenException, InvalidatedXPathException, TimeOutException;

    IStepFullWebEngine waitForElementPresentAndClick(Long waitingTime, Long sleepingTime, String xPath, String stepName) throws ElementUnClickAbleException, NoneElementException, NoneWindowOpenException, InvalidatedXPathException, TimeOutException;

    IStepFullWebEngine waitForElementPresentAndSendKeys(Long waitingTime, String xPath, CharSequence keys, String stepName) throws NoneKeyException, NoneElementException, NoneWindowOpenException, InvalidatedXPathException, TimeOutException, ElementUnClickAbleException;

    IStepFullWebEngine waitForElementPresentAndSelect(Long waitingTime, String xPath, String value, String stepName) throws TimeOutException, InvalidatedXPathException, NoneElementException, NoneSelectedValueException;


    void quit();
}
