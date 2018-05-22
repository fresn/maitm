package Interfaces;

import Step.StepStatus;

public interface IStep {

    String getStepName();

    StepStatus getState();

    void popData(String key, Object value);

    double getRunTime() throws Exception;

    void stepEnd() throws Exception;

    void stepStart();
}
