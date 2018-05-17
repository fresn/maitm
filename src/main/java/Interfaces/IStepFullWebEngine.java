package Interfaces;

public interface IStepFullWebEngine {
    IStepFullWebEngine setDefaultWaitingTime(long time);

    IStepFullWebEngine waitForElementPresent(String xPath, Long waitingTime, String stepName);

    IStepFullWebEngine openPage(String url);

    IStepFullWebEngine closePage();

    IStepFullWebEngine sleep(long time);

    void quit();
}

