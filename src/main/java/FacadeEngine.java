/*
import Engine.StepFullWebEngine;
import Enums.WebDriverType;
import Events.WebEventListeners;
import Interfaces.Engine.Components.IStepActions;
import Interfaces.IEventListeners;
import Interfaces.IStep;
import Interfaces.Engine.IStepFullWebEngine;
import Step.Step;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;


public class FacadeEngine {
    private IEventListeners listeners;
    private ArrayList<IStep> steps;
    private IStepFullWebEngine engine;
    private WebProxyHandler handler;

    IStepFullWebEngine getEngine() {
        listeners = new WebEventListeners();
        steps = new ArrayList<IStep>();
        engine = new StepFullWebEngine(WebDriverType.CHROME_DRIVE, listeners, steps);
        handler = new WebProxyHandler(engine, steps, listeners);


        IStepFullWebEngine proxyDrive = (IStepFullWebEngine) Proxy.newProxyInstance(
                StepFullWebEngine.class.getClassLoader()
                , StepFullWebEngine.class.getInterfaces()
                , handler
        );

        return proxyDrive;
    }


    class WebProxyHandler implements InvocationHandler {
        private IStepFullWebEngine webEngine;
        private ArrayList<IStep> steps;
        IEventListeners listeners;


        public WebProxyHandler(IStepFullWebEngine engine, ArrayList<IStep> steps, IEventListeners listeners) {
            this.webEngine = engine;
            this.steps = steps;
            this.listeners = listeners;
        }


        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            IStep currentStep = null;

            for (Method m : IStepActions.class.getMethods()) {
                if (m.equals(method)) {
                    System.out.println("m : " + m.getName());
                    currentStep = new Step(Long.toString(System.currentTimeMillis()), this.listeners);
                    steps.add(currentStep);
                }
            }

            Object o = method.invoke(webEngine, args);


            //end step
            if (currentStep != null) {
                currentStep.stepEnd();
            }

            if (null == o) {
                return null;
            } else if (o.getClass().equals(StepFullWebEngine.class)) {
                return proxy;
            } else {
                return o;
            }
        }
    }
}
*/
