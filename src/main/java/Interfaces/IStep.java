package Interfaces;

public interface IStep {

    String GetStepName();

    void SetStepLogMessage();

    String getStepLogMessage();

    void StepStart();

    void StepEnd();

}
