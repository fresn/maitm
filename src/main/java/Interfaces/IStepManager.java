package Interfaces;

import java.util.ArrayList;

public interface IStepManager {

    IStep newStep(String name);

    ArrayList<Object> getSteps();


}
