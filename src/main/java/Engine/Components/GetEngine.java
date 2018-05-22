package Engine.Components;

import Enums.WebDriverType;
import Interfaces.Engine.Components.IGetActions;
import Interfaces.IEventListeners;

public abstract class GetEngine extends BasicEngine implements IGetActions {
    public GetEngine(WebDriverType driverType, IEventListeners listeners) {
        super(driverType, listeners);
    }

    @Override
    public String getText() {
        return currentElement.getText();
    }

    @Override
    public String getValue() {
        return currentElement.getAttribute("value");
    }
}
