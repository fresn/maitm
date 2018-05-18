import Enums.WebDriverType;
import Events.WebEventListeners;
import Interfaces.IStep;
import Interfaces.IStepFullWebEngine;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FacadeEngineTest {
    @Test
    public void firstTest() {
        IStepFullWebEngine drive = (new FacadeEngine()).getEngine();

        drive.openPage("http://confluence")
                .openPage("http://google.com")
                .openPage("http://amazon.ca")
                .quit();

    }

    @Test
    public void sec() {

        IStepFullWebEngine engine = new StepFullWebEngine(WebDriverType.CHROME_DRIVE, new WebEventListeners(), new ArrayList<IStep>());

        engine.openPage("http://confluence")
                .sleep(10L)
                .closePage()
                .quit();
    }
}