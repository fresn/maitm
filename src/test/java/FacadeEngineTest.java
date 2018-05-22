import Engine.StFuWebEngine;
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
        engine = StFuWebEngine.getEngine();
//         driver=new ChromeDriver();
    }

    @Test
    public void firstTest() throws Exception {
        engine
                .openPage("https://webqat.wawanesa.com/canada/", "OpenPage https://webqat.wawanesa.com/canada/")
                .waitForElementPresentAndClick("//a[contains(text(), 'Claims')]", "Click Claims")
                .waitForElementPresentAndClick("//a[contains(text(), 'Automobile Claim')]", "Click AutoClaim")
                .waitForElementPresentAndClick("//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick("/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick("//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick("/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick("//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick("/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick("//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick("/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick("//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick("/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick("//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick("/html/body/div[5]/div/div", "234")
                .waitForElementPresentAndClick("//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "123")
                .waitForElementPresentAndClick("/html/body/div[5]/div/div", "234")
                .sleep(5L, "sleep").closePage("close page").quit();
    }


    @Test
    public void WebClaimCa_testCanadaClaimAuto() throws Exception, NoneSelectedValueException {
        engine.setDefaultWaitingTime(8L);
        engine
                .openPage("https://webqat.wawanesa.com/canada/", "OpenPage https://webqat.wawanesa.com/canada/")
                .waitForElementPresentAndClick("//a[contains(text(), 'Claims')]", "Click Claims")
                .waitForElementPresentAndClick("//a[contains(text(), 'Automobile Claim')]", "Click AutoClaim")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'reportingParty.firstName')]", "Natalia", "Input First Name Natalia")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'reportingParty.lastName')]", "Romanova", "Input Last Name Romanova")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'reportingParty.cellPhoneNumber')]", "9715551212", "Input Phone number 9715551212")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'reportingParty.emailAddress')]", "dserle@wawanesa.com", "Input Emailaddr dserle@wawanesa.com")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'policyNumber')]", "5000240", "Input policyNum 5000240")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'dateOfLoss')]", "03042018", "Input Date of loss 03042018")
                .waitForElementPresentAndClick("//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "loss fo of date con", 1L)
                .waitForElementPresentAndSelect("//*[contains(@name,'timeOfLossHour')]", "04", "Select Time Of loss Hour 04")
                .waitForElementPresentAndSelect("//*[contains(@name,'timeOfLossMinute')]", "05", "Select Time of loss minute 05")
                .waitForElementPresentAndSelect("//*[contains(@name,'timeOfLossAMPM')]", "PM", "Select time of loss APPM PM")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'lossLocation.street')]", "191 Broadway Avenue", "Input loss street 191 Broadway Avenue")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'lossLocation.city')]", "Calgary", "Input loss city Calgary");
        switch ("Alberta") {
            case "Quebec":
            case "Alberta":
                engine.waitForElementPresentAndSelect("//*[contains(@name,'autoClaim.lossLocation.state')][not(@disabled='disabled')]", "Alberta", "Select Alberta");
                break;
            case "us":
        }
        engine
                .waitForElementPresentAndSendKeys("//textarea[contains(@name,'lossDescription')]", "Business end-to-end case #6 - Process Online WebFNOL claim", "Input Description")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.firstName')]", "Boris", "insuredFirstName Boris")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.lastName')]", "Romanova", "insuredLastName")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.address.street')]", "201 Broadway Avenue", "Address 201 Broadway Avenue")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.address.city')]", "Calgary", "insuredCity")
                .waitForElementPresentAndSelect("//*[contains(@name,'insured.address.state')]", "Alberta", "insuredState")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.cellPhoneNumber')]", "9715550101", "insuredCellphone")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.address.postalCode')]", "97202", "insuredPostalCode")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.dateOfBirth')]", "01011990", "dateOfBirth")
                .waitForElementPresentAndClick("//*[@id=\"doAutoClaimPreview\"]/div[2]/h2[1]", "loss fo of date con", 1L)
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.driversLicenseNo')]", "ROMANOB12345", "driversLicenseNo")
                .waitForElementPresentAndSendKeys("//*[contains(@name,'insured.injuries')]", "None", "injuries")
                .waitForElementPresentAndClick("//input[contains(@name,'insured.vehicle.vehicleYear')]", "click vehicleYear")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.vehicle.vehicleYear')]", "2003", "vehicleYear")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.vehicle.vehicleMake')]", "Mazda", "vehicleMake")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.vehicle.vehicleModel')]", "Truck", "vehicleModel")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.vehicle.vehicleColor')]", "Pearl Black", "vehicleColor")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.vehicle.licensePlateNumber')]", "WH0004", "licensePlateNumber")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'insured.vehicle.VIN')]", "12345678901234567", "VIN")
                .waitForElementPresentAndSendKeys("//*[contains(@name,'insured.vehicle.vehicleDamages')]", "Cracked front bumper and passenger quarter-panel.", "vehicleDamages")
                .waitForElementPresentAndClick("//*[contains(@name,'oliceInfo')]", "oliceInfo")
                .waitForElementPresentAndSendKeys("//*[contains(@name,'policeInformation.policeDeptName')]", "OPD", "policeDeptName")
                .waitForElementPresentAndSendKeys("//*[contains(@name,'policeInformation.reportNumber')]", "012345678", "reportNumber")
                .waitForElementPresentAndClick("//*[contains(@name,'OtherParties')]", "OtherParties")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Claimants[0].firstName')]", "corporateWebData.claimantFirstName", "firstName")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Claimants[0].lastName')]", "Wayne", "lastName")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Claimants[0].phoneNumber')]", "9714567890", "phoneNumber")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Claimants[0].vehicle.vehicleMake')]", "Subaru", "vehicleMake")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Claimants[0].vehicle.vehicleModel')]", "Forester", "vehicleModel")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Claimants[0].vehicle.vehicleColor')]", "Yellow", "vehicleColor")
                .waitForElementPresentAndClick("//*[contains(@name,'sPassengers')]", "sPassengers")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Passengers[0].firstName')]", "Charles", "Passengers[0].firstName")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Passengers[0].lastName')]", "Xavier", "Passengers[0].lastName")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Passengers[0].phoneNumber')]", "9717890123", "Passengers[0].phoneNumber")
                .waitForElementPresentAndClick("//*[contains(@name, 'sWitnesses')]", "sWitnesses")
                .waitForElementPresentAndSendKeys("//input[contains(@name, 'Witness[0].firstName')]", "Oswald", "Witness[0].firstName")
                .waitForElementPresentAndSendKeys("//input[contains(@name, 'Witness[0].lastName')]", "Cobblepot", "Witness[0].lastName")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Witness[0].businessPhoneNumber')]", "9713338181", "Witness[0].businessPhoneNumber")
                .waitForElementPresentAndSendKeys("//input[contains(@name,'Witness[0].businessPhoneNumberExt')]", "54321", "Witness[0].businessPhoneNumberExt")
                .waitForElementPresentAndClick("//*[contains(text(),'Submit Claim')]", "'Submit Claim'");
        engine.waitForElementPresentAndClick("//input[@id='submitButton'][@value='Submit Claim']", "submitButton");

        /*get claimNum*/
        String claimNum = engine.waitForElementPresentAndGetText("//*[@id=\"doAutoClaimSubmit\"]//div/h1/center", "waiting for submission");

        /*login cc*/
        engine.openPage("https://qat2cc.wmic.ins/claimCenter.do", "open claimCenter")
                .waitForElementPresentAndSendKeys("//td[@id='Login:LoginScreen:LoginDV:username-bodyEl']/input", "su", "username")
                .waitForElementPresentAndSendKeys("//td[@id='Login:LoginScreen:LoginDV:password-bodyEl']/input", "gw", "password")
                .waitForElementPresentAndClick("//span[@id='Login:LoginScreen:LoginDV:submit-btnEl']", "login");
        /*searchClaimNumber*/
//        engine.waitForElementPresentAndClick( "//span[@id='TabBar:SearchTab-btnEl']/span", "SearchTab")
//                .waitForElementPresentAndSendKeys( "//td[@id='SimpleClaimSearch:SimpleClaimSearchScreen:SimpleClaimSearchDV:ClaimNumber-bodyEl']/input", "00" + claimNum, "Search")
//                .waitForElementPresentAndClick( "//*[@id='SimpleClaimSearch:SimpleClaimSearchScreen:SimpleClaimSearchDV:ClaimSearchAndResetInputSet:Search']", "click search")
//                .waitForElementPresentAndClick( "//a[contains(text(),'00" + claimNum + "')]","wait and click search res" );

    }
}