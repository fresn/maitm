import Enums.WebDriverType;
import Events.WebEventListeners;
import Exceptions.*;
import Interfaces.IStep;
import Interfaces.Engine.IStepFullWebEngine;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class FacadeEngineTest {
    IStepFullWebEngine engine;
    WebDriver driver;

    @Before
    public void init() {
        engine = new StepFullWebEngine(WebDriverType.CHROME_DRIVE, new WebEventListeners(), new ArrayList<IStep>());
//         driver=new ChromeDriver();
    }

    @Test
    public void firstTest() throws InvalidatedXPathException, NoneWindowOpenException, ElementUnClickAbleException, NoneElementException, TimeOutException {
        engine
                .openPage("https://webqat.wawanesa.com/canada/", "OpenPage https://webqat.wawanesa.com/canada/")
                .waitForElementPresentAndClick(10L, "//a[contains(text(), 'Claims')]", "Click Claims")
                .waitForElementPresentAndClick(10L, "//a[contains(text(), 'Automobile Claim')]", "Click AutoClaim")
                .waitForElementPresentAndClick(10L, "//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick(10L, "/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick(10L, "//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick(10L, "/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick(10L, "//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick(10L, "/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick(10L, "//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick(10L, "/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick(10L, "//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick(10L, "/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick(10L, "//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick(10L, "/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick(10L, "//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick(10L, "/html/body/div[5]/div/div", "234")
                .sleep(5L).closePage().quit();
    }

    @Test
    public void sec() {

        IStepFullWebEngine engine = new StepFullWebEngine(WebDriverType.CHROME_DRIVE, new WebEventListeners(), new ArrayList<IStep>());

        engine.openPage("http://confluence")
                .sleep(10L)
                .closePage()
                .quit();
    }


    @Test
    public void WebClaimCa_testCanadaClaimAuto() throws InvalidatedXPathException, NoneWindowOpenException, ElementUnClickAbleException, NoneElementException, TimeOutException, NoneKeyException, NoneSelectedValueException {
        engine
                .openPage("https://webqat.wawanesa.com/canada/", "OpenPage https://webqat.wawanesa.com/canada/")
                .waitForElementPresentAndClick(10L, "//a[contains(text(), 'Claims')]", "Click Claims")
                .waitForElementPresentAndClick(10L, "//a[contains(text(), 'Automobile Claim')]", "Click AutoClaim")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'reportingParty.firstName')]", "Natalia", "Input First Name Natalia")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'reportingParty.lastName')]", "Romanova", "Input Last Name Romanova")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'reportingParty.cellPhoneNumber')]", "9715551212", "Input Phone number 9715551212")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'reportingParty.emailAddress')]", "dserle@wawanesa.com", "Input Emailaddr dserle@wawanesa.com")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'policyNumber')]", "5000240", "Input policyNum 5000240")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'dateOfLoss')]", "03042018", "Input Date of loss 03042018")
                .waitForElementPresentAndClick(10L, 1L, "//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "loss fo of date con")
                .waitForElementPresentAndSelect(10L, "//*[contains(@name,'timeOfLossHour')]", "04", "Select Time Of loss Hour 04")
                .waitForElementPresentAndSelect(10L, "//*[contains(@name,'timeOfLossMinute')]", "05", "Select Time of loss minute 05")
                .waitForElementPresentAndSelect(10L, "//*[contains(@name,'timeOfLossAMPM')]", "PM", "Select time of loss APPM PM")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'lossLocation.street')]", "191 Broadway Avenue", "Input loss street 191 Broadway Avenue")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'lossLocation.city')]", "Calgary", "Input loss city Calgary");
        switch ("Alberta") {
            case "Quebec":
            case "Alberta":
                engine.waitForElementPresentAndSelect(10L, "//*[contains(@name,'autoClaim.lossLocation.state')][not(@disabled='disabled')]", "Alberta", "Select Alberta");
                break;
            case "us":
        }
        engine
                .waitForElementPresentAndSendKeys(10L, "//textarea[contains(@name,'lossDescription')]", "Business end-to-end case #6 - Process Online WebFNOL claim", "Input Description")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.firstName')]", "Boris", "insuredFirstName Boris")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.lastName')]", "Romanova", "insuredLastName")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.address.street')]", "201 Broadway Avenue", "Address 201 Broadway Avenue")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.address.city')]", "Calgary", "insuredCity")
                .waitForElementPresentAndSelect(10L, "//*[contains(@name,'insured.address.state')]", "Alberta", "insuredState")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.cellPhoneNumber')]", "9715550101", "insuredCellphone")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.address.postalCode')]", "97202", "insuredPostalCode")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.dateOfBirth')]", "01011990", "dateOfBirth")
                .waitForElementPresentAndClick(10L, 1L, "//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "loss fo of date con")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.driversLicenseNo')]", "ROMANOB12345", "driversLicenseNo")
                .waitForElementPresentAndSendKeys(10L, "//*[contains(@name,'insured.injuries')]", "None", "injuries")
                .waitForElementPresentAndClick(10L, "//input[contains(@name,'insured.vehicle.vehicleYear')]", "click vehicleYear")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.vehicle.vehicleYear')]", "2003", "vehicleYear")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.vehicle.vehicleMake')]", "Mazda", "vehicleMake")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.vehicle.vehicleModel')]", "Truck", "vehicleModel")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.vehicle.vehicleColor')]", "Pearl Black", "vehicleColor")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.vehicle.licensePlateNumber')]", "WH0004", "licensePlateNumber")
                .waitForElementPresentAndSendKeys(10L, "//input[contains(@name,'insured.vehicle.VIN')]", "12345678901234567", "VIN")
                .waitForElementPresentAndSendKeys(10L, "//*[contains(@name,'insured.vehicle.vehicleDamages')]", "Cracked front bumper and passenger quarter-panel.", "vehicleDamages")
                .waitForElementPresentAndClick(10L, "//*[contains(@name,'oliceInfo')]", "oliceInfo");


        engine.sleep(7).closePage().quit();


    }
}