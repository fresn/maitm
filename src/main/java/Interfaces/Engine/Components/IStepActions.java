package Interfaces.Engine.Components;

import Interfaces.Engine.IStepFullWebEngine;

public interface IStepActions {

    IStepFullWebEngine openPage(String url);

    IStepFullWebEngine closePage();

    IStepFullWebEngine sleep(long time);

    IStepFullWebEngine waitForElementPresent(String xPath, Long waitingTime, String stepName);

    void quit();
}
