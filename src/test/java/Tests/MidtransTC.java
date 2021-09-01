package Tests;

import Base.BaseTest;
import Utility.Constants;
import Utility.ElementUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MidtransTC extends BaseTest {

    @Test(priority = 1,groups={"Regression","Smoke"})
    public void verifyIsTextDisplayedTest(){
        Assert.assertTrue(homepage.isWrittenTextDisplayed());
    }

    @Test(priority = 3, groups={"Regression","Smoke"})
    public void verifyPillowIsAddedToCartWithAmount() {


        homepage.clickOnBuyNow();

        Assert.assertEquals(homepage.getElementTextForPillow(),Constants.PILLOW_AMOUNT);

    }

    @Test(priority = 2, groups={"Regression","Smoke"})
    public void verifyClickingOnBuyNowRedirectsUserToPopUpWindowTest() throws InterruptedException {
        homepage.clickOnBuyNow();
        Assert.assertTrue(homepage.elementIsVisible());

        Thread.sleep(3000);
        Assert.assertEquals(homepage.getElementTextForPillow(),Constants.PILLOW_AMOUNT);
    }

    @Test(priority = 4,groups={"Regression","Smoke"})
    public void verifyBuyNowButtonRedirectsToCheckOutPopUpTest(){
       homepage.clickOnBuyNow();
       Assert.assertEquals(homepage.getAccountSectionsList(),Constants.getAccountSectionList());
    }

    @Test(priority = 5, groups={"Regression"})
    public void verifyUserShouldBeAbleToEnterDetailsTest(){
        homepage.clickOnBuyNow();
        homepage.enterDetailsOfName(prop.getProperty("name"));
        homepage.enterDetailsOfEmail(prop.getProperty("email"));
        homepage.enterDetailsOfPhone(prop.getProperty("phone_no"));
        homepage.enterDetailsOfCity(prop.getProperty("city"));
        homepage.enterDetailsOfAddress(prop.getProperty("address"));
        homepage.enterDetailsOfPostalcode(prop.getProperty("postal_code"));
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        Assert.assertTrue(homepage.isDisplayedCocostoreElement(),"Element not found");
    }

    @Test(priority = 6, groups={"Regression"})
    public void verifyOrderSummaryPopUp(){
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        Assert.assertEquals(homepage.getElementItemNameValue(),Constants.ITEM_NAME);
        Assert.assertEquals(homepage.getElementPriceValue(),Constants.ITEM_PRICE);
    }

    @Test(priority = 7, groups={"Regression"})
    public void verifyClickingOnContinueBtnRedirectsUserToPaymentPage(){
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        homepage.clickOnContinueButton();
        Assert.assertTrue(homepage.isDisplayedSelectPaymentElement(),"SelectPayment element not found");

    }

    @Test(priority = 8, groups={"Regression"})
    public void verifyPaymentSectionListTest() throws InterruptedException {
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        homepage.clickOnContinueButton();
        Assert.assertEquals(homepage.getPaymentList(),Constants.getPaymentSectionList(),"Values not matching");
    }

    //@Test(priority = 9, groups={"Regression","Smoke"})
    public void verifyClickingOnCreditCardRedirectsToPaymentPageTest() throws InterruptedException {
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        homepage.clickOnContinueButton();
        homepage.clickOnCreditCard();
        Assert.assertTrue(homepage.isDisplayedElementOnCreditCardPayment(),"Element not Visible");
    }

    @Test(priority = 10, groups={"Smoke"})
    public void verifyClickingOnCheckBoxDiscountedValueShouldAppear() throws InterruptedException {
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        homepage.clickOnContinueButton();
        homepage.clickOnCreditCard();
        homepage.clickOnDiscountCheckbox();
        Assert.assertEquals(homepage.getTextOfDiscountedValue(),Constants.DISCOUNTED_PRICE);
    }

    @Test(priority = 11, groups={"Smoke"})
    public void verifyAfterDetailsUserShouldRedirectsToNewPageTest() throws InterruptedException {
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        homepage.clickOnContinueButton();
        homepage.clickOnCreditCard();
        homepage.enterDetailsOfCreditCard(prop.getProperty("cardnumber"), prop.getProperty("expirydate"), prop.getProperty("cvv"));
        homepage.clickOnPayNowButton();
        Thread.sleep(3000);
        Assert.assertTrue(homepage.isDisplayedElementOnCreditCardPayment());

    }

   // @Test(priority = 12 ,groups={"Regression","Smoke"})
    public void verifyVisibilityOfElementsOnOTPPage(){
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        homepage.clickOnContinueButton();
        homepage.clickOnCreditCard();
        homepage.enterDetailsOfCreditCard(prop.getProperty("cardnumber"), prop.getProperty("expirydate"), prop.getProperty("cvv"));
        homepage.clickOnPayNowButton();
        Assert.assertEquals(homepage.getTextForElementMerchant(),Constants.MERCHANT_NAME);
        Assert.assertEquals(homepage.getTextForElementAmount(),Constants.AMOUNT);
        Assert.assertEquals(homepage.getTextForElementTransaction(),Constants.TRANSACTION);
        Assert.assertEquals(homepage.getTextForElementCardNumber(),Constants.CARDNO);
    }

    @Test(priority = 13, groups={"Smoke"})
    public void verifyFailedStatusMessageShouldBeVisible() throws InterruptedException {
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        homepage.clickOnContinueButton();
        homepage.clickOnCreditCard();
        homepage.enterDetailsOfCreditCard(prop.getProperty("cardnumber"), prop.getProperty("expirydate"), prop.getProperty("cvv"));
        homepage.clickOnPayNowButton();
        homepage.enterOTP(prop.getProperty("otpfield1"));
        homepage.clickOnOkButton();
        Thread.sleep(5000);
        Assert.assertTrue(homepage.isTextOfFailedStatusMsgDisplayed());
    }

    @Test(priority = 14, groups={"Smoke"})
    public void verifyClickingOnCancelBtnFailedStatusMessageShouldBeVisible(){
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        homepage.clickOnContinueButton();
        homepage.clickOnCreditCard();
        homepage.enterDetailsOfCreditCard(prop.getProperty("cardnumber"), prop.getProperty("expirydate"), prop.getProperty("cvv"));
        homepage.clickOnPayNowButton();
        homepage.clickOnCancelButton();
        Assert.assertTrue(homepage.isTextOfFailedStatusMsgDisplayed());
    }

}
