package tests;

import org.testng.annotations.Test;

public class ContactTests extends BaseTest {

    @Test
    public void verifyValidationErrorOnContactPage() {
        homePage.navigateToContactPage().clickSubmit();
    }
}
