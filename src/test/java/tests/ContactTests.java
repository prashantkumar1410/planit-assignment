package tests;

import org.testng.annotations.Test;
import utils.Categories;

public class ContactTests extends BaseTest {

    @Test(groups = Categories.SANITY)
    public void verifyValidationErrorAndSuccessfulSuccessMsgOnContactPage() {
        homePage
                .navigateToContactPage()
                .clickSubmit()
                .verifyValidationError()
                .enterMandatoryField()
                .clickSubmit()
                .verifySuccessMessage();
    }
    @Test(groups = Categories.SANITY)
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
