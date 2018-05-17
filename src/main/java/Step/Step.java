package Step;

import Interfaces.IEventListeners;
import Interfaces.IStep;

public class Step implements IStep {
    private IEventListeners listeners;
    private String name;

    public Step(String stepName, IEventListeners listeners) {
        this.listeners = listeners;
        this.listeners.BeforeStep(this);
        this.name = stepName;
    }

    public String GetStepName() {
        return this.name;
    }

    public void SetStepLogMessage() {

    }

    public String getStepLogMessage() {
        return null;
    }

    public void StepEnd() {
        listeners.AfterStep(this);
    }
}
