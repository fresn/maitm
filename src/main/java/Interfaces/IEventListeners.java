package Interfaces;

import Step.DataStorage;
import org.openqa.selenium.support.events.WebDriverEventListener;

public interface IEventListeners extends WebDriverEventListener {

    void BeforeStep(IStep step);

    void AfterStep(IStep step) throws Exception;

    void StepPopData(DataStorage data);


}
