import com.sun.rowset.internal.WebRowSetXmlReader;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.IOException;

public class BasicEngineTest {
    private String username = "";
    private String password = "";
    private BasicEngine engine;

    @Before
    public void init() {
        this.engine = new BasicEngine(new EventFiringWebDriver(new ChromeDriver()), new EventL());
    }

//    @Test
//    public void page() {
//    }
//
//    @Test
//    public void page1() {
//    }
//
//    @Test
//    public void element() {
//    }
//
//    @Test
//    public void waitForElement() {
//    }
//
//    @Test
//    public void click() {
//    }
//
//    @Test
//    public void enter() {
//    }
//
//    @Test
//    public void close() {
//    }
//
//    @Test
//    public void quit() {
//    }

    @Test
    public void confluenceTest() throws IOException {
        try {
            engine.page("http://confluence/", "confluence")
                    .element("/html//a[@id='login-link']")
                    .takesScreenshot()
                    .click()
                    .waitForElement(10L, "/html//form[@action='/dologin.action']//input[@placeholder='Username']")
                    .sendValue("ianma")
                    .waitForElement(10L, "/html//form[@action='/dologin.action']//input[@placeholder='Password']")
                    .sendValue("Adm123x+")
                    .takesScreenshot()
                    .waitForElement(10L, "/html//form[@action='/dologin.action']//input[@type='submit']")
                    .click()
                    .pause(10)
                    .quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}