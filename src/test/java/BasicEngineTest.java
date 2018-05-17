import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BasicEngineTest {
    private String username = "";
    private String password = "";
    private BasicEngine engine;

    @Before
    public void init() throws NoSuchMethodException {

        this.engine = new BasicEngine(new EventFiringWebDriver(new ChromeDriver()), new EventL());
    }

    @Test
    public void confluenceTest() {
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
                    .pause(3L)
                    .testTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void finala() {
        engine.close().quit();
    }
}
