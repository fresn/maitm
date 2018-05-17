import Exceptions.CurrentElementNullException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Main class of infinite transaction framework
 * </p>
 * <p>
 * rule: for readable purpose all class variable accessed using "this.xxx"
 * <p>
 * todo: after send key check new pages
 * todo: after click check new pages
 * todo: Infinite transaction
 * todo: get page
 * todo: get element
 * todo: wait element
 * todo: element click
 * todo: element sendKeys
 * todo: element enter
 * todo: element get value
 * todo: element wait value
 *
 * <p>
 * author: Ian Ma
 * inc: Wawanesa auto test
 * version: 0.1 starting point
 * </p>
 */


public class BasicEngine {
    //to store WebDrive instance
    private EventFiringWebDriver driver;
    //to store current PageHandle #it seems not necessary, todo currentPageHandle tobe determined to keep or not
    private String currentPageHandle;
    //to store pageHandles
    private HashMap<String,String > pageHandles = new HashMap<String, String>();

    private WebElement currentElement;


    public boolean testTrue() {
        return true;
    }

    /**
     * Contractor
     *
     * @param driver        receive instance of EventFiringWebDriver of instance of WebDriver Could be
     *                      chrome drive or firefox drive etc.
     * @param eventListener receive instance of WebDriverEventListener implement
     */
    public BasicEngine(EventFiringWebDriver driver, WebDriverEventListener eventListener) {
        this.driver = driver;
        this.driver.register(eventListener);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
    }

    /*****************************************************************************************************************************/
    //actions

    /**
     * todo write docs
     * */
    public BasicEngine page(String URL, String pageName) {
        try {
            this.driver.get(URL);
            pageHandles.put(pageName,this.driver.getWindowHandle());
        } catch (RuntimeException e) {
            // TODO: 2018-05-11 un-finished exception
            e.printStackTrace();
        }

        //return self to keep transaction
        return this;
    }


    /**
     * todo write docs
     * */
    public BasicEngine page(String pageName) {
        //if page we wait not current
        try {
            if(!pageHandles.get(pageName).equals(this.driver.getWindowHandle())){
                this.driver.switchTo().window(pageHandles.get(pageName));
            }
        }catch (Exception e){
            /* TODO: 2018-05-11 un-finished exception*/
            e.printStackTrace();
        }
        //return self to keep transaction
        return this;
    }
    /***********************************************************************************************************************/
    //elements
    public BasicEngine element(String xPath){
        try {
            currentElement=driver.findElement(By.xpath(xPath));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }


        return this;
    }

    public BasicEngine waitForElement(Long waitTime,String xPath){
        try {
            this.currentElement=new WebDriverWait(this.driver,waitTime).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        }catch (Exception e){
            e.printStackTrace();
        }


        return this;
    }

    public BasicEngine click(){
        try {
            if(currentElement!=null){
                currentElement.click();
            }else {
                throw new CurrentElementNullException();
            }
        }catch (CurrentElementNullException e) {
            e.printStackTrace();
        }


        return this;
    }

    public BasicEngine sendEnter(){
        try {
            if(currentElement!=null){
                currentElement.sendKeys(Keys.ENTER);
            }else {
                throw new CurrentElementNullException();
            }
        }catch (CurrentElementNullException e) {
            e.printStackTrace();
        }

        return this;
    }

    public BasicEngine sendValue(String value){
        try {
            if(currentElement!=null){
                currentElement.sendKeys(value);
            }else {
                throw new CurrentElementNullException();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    /*
    *
    * **/
    public BasicEngine pause(long time){
        try {
            Thread.currentThread().sleep(time*1000);
        }catch (Exception e){
            e.printStackTrace();
        }


        return this;
    }

    public BasicEngine waitForAttrEqualTo(Long timeWait,String attrName,String equalToValue){
        try {
            new WebDriverWait(this.driver,timeWait).until(ExpectedConditions.attributeToBe(currentElement,attrName,equalToValue));
        }catch (Exception e){
            e.printStackTrace();
        }

        return this;
    }


    public BasicEngine takesScreenshot() throws IOException {
        File scrFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("Copy File to " + System.getProperty("java.io.tmpdir") + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(scrFile, new File(System.getProperty("java.io.tmpdir") + System.currentTimeMillis() + ".png"));
        return this;
    }




    /***********************************************************************************************************************/

    /**
     * TODO: write docs
     * */
    public BasicEngine close(){
        driver.close();
        //return self to keep transaction
        return this;
    }

    /**
     * TODO: WRITE DOCS
     * */
    public void quit()  {
        //quit drive
        driver.quit();
        try {
            //end self
            this.finalize();
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
