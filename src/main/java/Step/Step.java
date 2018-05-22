package Step;

import Events.WebEventListeners;
import Interfaces.IEventListeners;
import Interfaces.IStep;

import java.util.LinkedHashMap;

public class Step implements IStep {
    private IEventListeners listeners;
    private String name;
    long startTime;
    long endTime;
    StepStatus stepState;
    LinkedHashMap<String, DataStorage> popData;

    public Step(String stepName) {
        this.name = stepName;
        this.listeners = new WebEventListeners();
        this.stepState = StepStatus.READY;
    }


    @Override
    public String getStepName() {
        return this.name;
    }

    @Override
    public StepStatus getState() {
        return stepState;
    }

    @Override
    public void popData(String key, Object value) {
        popData.put(key, new DataStorage(value));

    }

    @Override
    public double getRunTime() throws Exception {
        if (this.stepState == StepStatus.END) {
            return ((double) (endTime - startTime) / 1000);
        } else {
            throw new Exception("step unfinished");
        }


    }

    @Override
    public void stepEnd() throws Exception {
        this.stepState = StepStatus.END;
        this.endTime = System.currentTimeMillis();
        this.listeners.AfterStep(this);
    }

    @Override
    public void stepStart() {
        this.stepState = StepStatus.RUNNING;
        this.startTime = System.currentTimeMillis();
        this.listeners.BeforeStep(this);
    }
}
