import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BasicEngineTest {
    private String username="";
    private String password="";
    private  BasicEngine engine;
    @Before
    public  void  init(){
        this.engine= new BasicEngine(new EventFiringWebDriver(new ChromeDriver()),new EventL());
    }

    @Test
    public void page() {
    }

    @Test
    public void page1() {
    }

    @Test
    public void element() {
    }

    @Test
    public void waitForElement() {
    }

    @Test
    public void click() {
    }

    @Test
    public void enter() {
    }

    @Test
    public void close() {
    }

    @Test
    public void quit() {
    }

    @Test
    public void basicTest(){
        engine.page("https://www.google.ca","google home")
                .element("//*[@id=\"gb_70\"]")
                .click()
                .waitForElement(10L,"//*[@id=\"identifierId\"]")
                .sendValue(username)
                .sendEnter()
                .waitForElement(10L,"//*[@id=\"password\"]/div[1]/div/div[1]/input")
                .sendValue(password)
                .sendEnter()
                .waitForElement(10L,"//*[@id=\"gsr\"]")
                .click()
                .waitForElement(10L,"//*[@id=\"gb_71\"]")
                .click()
                .goQuite(10)
                .close()
                .quit();
    }

    @Test
    public void  confluenceTest(){
        engine.page("http://confluence/","confluence")
                .element("/html//a[@id='login-link']")
                .click()
                .waitForElement(10L,"/html//form[@action='/dologin.action']//input[@placeholder='Username']")
                .sendValue("")
                .waitForElement(10L,"/html//form[@action='/dologin.action']//input[@placeholder='Password']")
                .sendValue("")
                .waitForElement(10L,"/html//form[@action='/dologin.action']//input[@type='submit']")
                .click()
                .goQuite(10)
                .quit();
    }
}
