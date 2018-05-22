package Interfaces.Engine.Components;

import Exceptions.*;

public interface IBasicActions {

    void openPage(String url);

    void click() throws NoneWindowOpenException, NoneElementException, ElementUnClickAbleException;

    void sleep(long time);

    void waitForElementPresent(long waitTime, String xPath) throws TimeOutException, InvalidatedXPathException, NoneElementException;

    void sendKeys(CharSequence keys) throws NoneWindowOpenException, NoneElementException, NoneKeyException;

    void quit();

}
