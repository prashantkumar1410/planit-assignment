package tests;

import org.testng.annotations.Test;

public class ShopTests extends BaseTest {
    @Test
    public void verifyValidationErrorAndSuccessfulSuccessMsgOnContactPage() throws InterruptedException {
        homePage
                .navigateToShopPage()
                .selectProductAndBuy("Funny Cow")
                .selectProductAndBuy("Funny Cow")
                .selectProductAndBuy("Fluffy Bunny")
                .navigateToCart()
                .verifyProductAdded("3")
        ;
    }
}
