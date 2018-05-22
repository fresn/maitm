package Interfaces.Engine.Components;

import Exceptions.*;
import Interfaces.Engine.IStepFullWebEngine;
import Interfaces.IStep;
import Step.Step;

public interface IStepActions {

    IStepFullWebEngine openPage(String url, String stepName) throws Exception;

    IStepFullWebEngine click(String stepName) throws Exception;

    IStepFullWebEngine closePage(String stepName) throws Exception;

    IStepFullWebEngine sleep(long waitTime, String stepName) throws Exception;

    IStepFullWebEngine waitForElementPresent(String xPath, String stepName) throws Exception;

    IStepFullWebEngine waitForElementPresent(Long waitingTime, String xPath, String stepName) throws Exception;

    IStepFullWebEngine waitForElementPresentAndClick(String xPath, String stepName) throws Exception;

    IStepFullWebEngine waitForElementPresentAndClick(Long waitingTime, String xPath, String stepName) throws Exception;

    IStepFullWebEngine waitForElementPresentAndClick(String xPath, String stepName, Long sleepingTime) throws Exception;

    IStepFullWebEngine waitForElementPresentAndClick(Long waitingTime, String xPath, String stepName, Long sleepingTime) throws Exception;

    IStepFullWebEngine waitForElementPresentAndSendKeys(String xPath, CharSequence keys, String stepName) throws Exception;

    IStepFullWebEngine waitForElementPresentAndSendKeys(Long waitingTime, String xPath, CharSequence keys, String stepName) throws Exception;

    IStepFullWebEngine waitForElementPresentAndSelect(String xPath, String selectValue, String stepName) throws Exception, NoneSelectedValueException;

    IStepFullWebEngine waitForElementPresentAndSelect(Long waitingTime, String xPath, String selectValue, String stepName) throws Exception, NoneSelectedValueException;


    String waitForElementPresentAndGetText(String xPath, String stepName) throws Exception;

    String waitForElementPresentAndGetText(Long WaitingTime, String xPath, String stepName) throws Exception;


}
