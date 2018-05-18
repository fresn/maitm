package Step;

import Interfaces.IEventListeners;
import Interfaces.IStep;

public class Step implements IStep {
    private IEventListeners listeners;
    private String name;


    public Step(String stepName, IEventListeners listeners) {
        this.name = stepName;
        this.listeners = listeners;
        this.listeners.BeforeStep(this);
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
