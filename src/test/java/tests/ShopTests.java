package tests;

import org.testng.annotations.Test;
import utils.Categories;

public class ShopTests extends BaseTest {
    @Test(groups = Categories.SANITY)
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
