package Engine.Components;

import Enums.WebDriverType;
import Exceptions.*;
import Interfaces.Engine.Components.IBasicActions;
import Interfaces.IEventListeners;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;

public abstract class BasicEngine extends SettingEngine implements IBasicActions {
    protected static final String JS_IS_AJAX_TALKING = "return document.getAjaxReadyStatus";
    protected static final String JS_SETTING_AJAX_Hijacker =
            "document.AjaxConns = [];\n" +
                    "document.getAjaxReadyStatus = function () {\n" +
                    "    var state = false;\n" +
                    "    document.AjaxConns.forEach(function (value, index) {\n" +
                    "        if (value.readyState !== 4) {\n" +
                    "            state = state || true;\n" +
                    "        }\n" +
                    "    });\n" +
                    "    return state;\n" +
                    "};\n" +
                    "document.addAjaxConn = function (conn) {\n" +
                    "    document.AjaxConns.push(conn)\n" +
                    "};\n" +
                    "(function (open) {\n" +
                    "    XMLHttpRequest.prototype.open = function (method, url, async, user, pass) {\n" +
                    "        document.addAjaxConn(this);\n" +
                    "        this.addEventListener(\"readystatechange\", function () {\n" +
                    "            console.log(document.getAjaxReadyStatus());\n" +
                    "            if(this.readyState===1){\n" +
                    "                this.StateOPENED=Date.now();\n" +
                    "            }else if(this.readyState===2){\n" +
                    "                this.StateHEADERS_RECEIVED=Date.now();\n" +
                    "            }else if(this.readyState===3){\n" +
                    "                this.StateLOADING=Date.now();\n" +
                    "            }else if(this.readyState===4){\n" +
                    "                this.StateDONE=Date.now();\n" +
                    "            }\n" +
                    "        }, false);\n" +
                    "        open.call(this, method, url, async, user, pass);\n" +
                    "    };\n" +
                    "\n" +
                    "})(XMLHttpRequest.prototype.open);\n" +
                    "\n";



    public BasicEngine(WebDriverType driverType, IEventListeners listeners) {
        super(driverType, listeners);
    }

    @Override
    public void openPage(String url) {
        try {
            this.driver.get(url);
            exJs(JS_SETTING_AJAX_Hijacker);
        } catch (Exception e) {
            //TODO unhandled Exp
            System.out.println(e.getCause().toString());
        }
    }

    @Override
    public void click() throws NoneWindowOpenException, NoneElementException, ElementUnClickAbleException {
        if (isWindowOpened()) {
            if (this.currentElement != null) {
                if (this.currentElement.isDisplayed()) {
                    while (true) {
                        if (exJs("JS_IS_AJAX_TALKING") == "false") {
                            break;
                        }
                    }
                    this.currentElement.click();
                } else {
                    throw new ElementUnClickAbleException();
                }
            } else {
                throw new NoneElementException();
            }
        } else {
            throw new NoneWindowOpenException();
        }
    }

    @Override
    public void sleep(long time) {
        try {
            Thread.currentThread().sleep(time * 1000);
        } catch (Exception e) {
            //TODO unhandled Exp
            e.printStackTrace();
        }
    }

    @Override
    public void waitForElementPresent(long waitTime, String xPath) throws TimeOutException, InvalidatedXPathException, NoneElementException {
        try {
            this.currentElement = new WebDriverWait(driver, waitTime).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        } catch (TimeoutException e) {
            throw new TimeOutException();
        } catch (IllegalArgumentException e) {
            throw new InvalidatedXPathException();
        } catch (NoSuchElementException e) {
            throw new NoneElementException();
        } catch (WebDriverException e) {
            //TODO WebDriverException
        }
    }

    @Override
    public void sendKeys(CharSequence keys) throws NoneWindowOpenException, NoneElementException, NoneKeyException {
        if (isWindowOpened()) {
            if (this.currentElement != null) {
                try {
                    this.currentElement.sendKeys(keys);
                } catch (IllegalArgumentException e) {
                    throw new NoneKeyException();
                }
            } else throw new NoneElementException();
        } else throw new NoneWindowOpenException();
    }

    public void quit() {
        driver.quit();
    }


    protected boolean isWindowOpened() {
        try {
            driver.getWindowHandle();
        } catch (NoSuchSessionException e) {
            return false;
        }
        return true;
    }

    protected Object exJs(String jsCode) {
        return (JavascriptExecutor) driver.executeScript(jsCode);
    }
}
