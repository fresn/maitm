import Interfaces.Engine.IStepFullWebEngine;

public class ClaimCA {
    static void loginPC(IStepFullWebEngine engine) throws Exception {
        engine.openPage("https://qat2pc.wmic.ins/policyCenter.do", "open page policyCenter")
                .waitForElementPresentAndSendKeys("//td[@id='Login:LoginScreen:LoginDV:username-bodyEl']/input", "su", "type in username ")
                .waitForElementPresentAndSendKeys("//td[@id='Login:LoginScreen:LoginDV:password-bodyEl']/input", "gw", "type in password")
                .waitForElementPresentAndClick("//span[@id='Login:LoginScreen:LoginDV:submit-btnEl']", "click login");
    }

    static void navigateToCreateNewAccount(IStepFullWebEngine engine) throws Exception {
        engine
                .waitForElementPresentAndClick("//span[@id='TabBar:DesktopTab-btnEl']/span", "")
                .sleep(1, "")
                .waitForElementPresentAndClick("//a[@id='Desktop:DesktopMenuActions']", "")
                .sleep(1, "")
                .waitForElementPresentAndClick("//a[contains(@id,'DesktopMenuActions_NewAccount-itemEl')]/span", "")
                .sleep(1, "")
                .waitForElementPresentAndSendKeys("//td[contains(@id,'GlobalContactNameInputSet:Name-bodyEl')]/input", "crystal", "")
                .sleep(1, "")
                .waitForElementPresentAndClick("//a[contains(@id,'SearchLinksInputSet:Search')]", "")
                .sleep(1, "")
                .waitForElementPresentAndClick("//span[@id='NewAccount:NewAccountScreen:NewAccountButton-btnEl']/span", "")
                .sleep(1, "")
                .waitForElementPresentAndClick("//div[@id='NewAccount:NewAccountScreen:NewAccountButton:NewAccount_Person']/a", "");
    }

    static void fillPersonAction(IStepFullWebEngine engine) throws Exception {
        engine.waitForElementPresent("//*[text()='Create account']", "waitfor Create account")
                .waitForElementPresent("//input[contains(@id,':GlobalPersonNameInputSet:FirstName-inputEl')]", "waitfor FirstName")
                .waitForElementPresentAndSendKeys("//input[contains(@id,':GlobalPersonNameInputSet:FirstName-inputEl')]", "Automation", "")
                .waitForElementPresentAndSendKeys("//td[contains(@id,'LastName-bodyEl')]/input", "lastname", "");
    }

    static void fillPhoneSection(IStepFullWebEngine engine) throws Exception {
        engine.waitForElementPresentAndClick("//input[contains(@id,':CreateAccountContactInputSet:PrimaryPhone-inputEl')]", "")
                .waitForElementPresentAndClick("//li[text()='Home']", "")
                .waitForElementPresentAndSendKeys("//input[contains(@id,'HomePhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl')]", "555-555-5555", "");
    }

    static void fillEmailSection(IStepFullWebEngine engine) throws Exception {
        engine.waitForElementPresentAndSendKeys("//input[contains(@id,'CreateAccountContactInputSet:EmailAddress1-inputEl')]", "autotestemail@wawanesa.com", "")
                .waitForElementPresent("//input[contains(@id,'EmailConfirmation_WMICInputSet:EmailConfirmation-inputEl')]", "")
                .waitForElementPresentAndSendKeys(
                        "//input[contains(@id,'EmailConfirmation_WMICInputSet:EmailConfirmation-inputEl')]",
                        "autotestemail@wawanesa.com",
                        ""
                );
    }

    static void fillAdditionalCrap(IStepFullWebEngine engine) throws Exception {
        engine
                .waitForElementPresentAndSendKeys(
                        "//input[contains(@id,':DateOfBirth-inputEl')]",
                        "01/01/1970", ""
                )
                .waitForElementPresentAndClick("//td[contains(@id,':Gender-inputCell')]/input", "")
                .waitForElementPresentAndClick("//li[text()='Male']", "")
                .waitForElementPresentAndClick("//td[contains(@id,':MaritalStatus-inputCell')]/input", "")
                .waitForElementPresentAndClick("//li[text()='Single']", "");
    }

    static void educationSection(IStepFullWebEngine engine) throws Exception {
        engine
                .waitForElementPresentAndClick("//input[contains(@id,':id_educationlevel-inputEl')]", "")
                .waitForElementPresentAndClick("//li[text()='Masters']", "");
    }

    static void employmentSection(IStepFullWebEngine engine) throws Exception {
        engine
                .waitForElementPresentAndSendKeys("//input[contains(@id,'id_occupationtk-inputEl')]", "Other (Please Specify)", "")
                .waitForElementPresentAndSendKeys("//input[contains(@id,'id_occupationdescription-inputEl')]", "Educator", "");

    }

    static void brokerSection(IStepFullWebEngine engine) throws Exception {
        engine
                .waitForElementPresentAndClick("//input[contains(@id,':BaseState-inputEl')]", "")
                .waitForElementPresentAndClick("//li[text()='Oregon']", "");
    }
}
