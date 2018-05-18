package Interfaces.Engine.Components;

import Exceptions.*;
import Interfaces.Engine.IStepFullWebEngine;
import Interfaces.IStep;

public interface IBasicActions {

    IStepFullWebEngine openPage(String url);

    IStepFullWebEngine click() throws NoneWindowOpenException, NoneElementException, ElementUnClickAbleException;

    IStepFullWebEngine sleep(long time);

    IStepFullWebEngine waitForElementPresent(long waitTime, String xPath) throws TimeOutException, InvalidatedXPathException, NoneElementException;

    IStepFullWebEngine sendKeys(CharSequence keys) throws NoneWindowOpenException, NoneElementException, NoneKeyException;

}
