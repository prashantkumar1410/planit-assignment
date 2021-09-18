package tests;

import org.testng.annotations.Test;

public class ContactTests extends BaseTest {

    @Test
    public void verifyValidationErrorAndSuccessfulSuccessMsgOnContactPage() {
        homePage
                .navigateToContactPage()
                .clickSubmit()
                .verifyValidationError()
                .enterMandatoryField()
                .clickSubmit()
                .verifySuccessMessage();
    }
    @Test
    public void verifyMandatoryFieldErrorOnContactPage() {
        homePage
                .navigateToContactPage()
                .clickSubmit()
                .verifyValidationError()
                .enterInvalidDataInMandatoryField()
                .clickSubmit()
                .verifyMandatoryFieldValidationError();
    }
}
