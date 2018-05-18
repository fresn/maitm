package Interfaces.Engine.Components;

import Exceptions.InvalidatedXPathException;
import Exceptions.NoneElementException;
import Interfaces.Engine.IStepFullWebEngine;

public interface ICheckActions {
    public boolean isElementPresent(String xPath) throws InvalidatedXPathException;

    public boolean isElementDisplayed(String xPath) throws InvalidatedXPathException;

    public boolean isElementSelected(String xPath) throws InvalidatedXPathException;

    public boolean isElementInnerTextEquals(String xPath, String text) throws InvalidatedXPathException;
}
