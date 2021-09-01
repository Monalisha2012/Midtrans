package Pages;

import Base.BasePage;
import Utility.ElementUtils;
import io.github.bonigarcia.wdm.managers.SeleniumServerStandaloneManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage {

    public WebDriver driver;
    public ElementUtils elementUtils;


    public HomePage(WebDriver driver){
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }


    private By text = By.xpath("//div[text()='Midtrans Pillow']");
    private By buynowbutton = By.xpath("//a[@class='btn buy']");
    private By name = By.xpath("//td[text()='Name']");
    private By email = By.xpath("//td[text()='Email']");
    private By phone = By.xpath("//td[text()='Phone no']");
    private By city = By.xpath("//td[text()='City']");
    private By address = By.xpath("//td[text()='Address']");
    private By postal_code = By.xpath("//td[text()='Postal Code']");
    private By cart_values = By.xpath("//div[@class='cart-inner']//div[4]");
    private By shopping_cart = By.xpath("//span[@data-reactid='.0.0.1.0.0.0']");
    private By checkout_btn = By.xpath("//div[text()='CHECKOUT']");
    private By amount = By.xpath("//input[@value='20000']");
    private By name_placeholder = By.xpath("//input[@value='Budi']");
    private By email_placeholder = By.xpath("//input[@value='budi@utomo.com']");
    private By phone_no_placeholder = By.xpath("//input[@value='081808466410']");
    private By city_placeholder = By.xpath("//input[@value='Jakarta']");
    private By address_placeholder = By.xpath("//textarea[normalize-space()='MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11']");
    private By postalcode_placeholder = By.xpath("//input[@value='10220']");
    private By frameId = By.id("snap-midtrans");
    private By cocostore = By.xpath("//h1[text()='COCO STORE']");
    private By item_name = By.xpath("//span[@class='item-name']");
    private By price = By.xpath("//td[@class='table-amount text-body']");
    private By continuebtn = By.xpath("//a[@class='button-main-content']");
    private By selectpayment = By.xpath("//p[text()='Select Payment']");
    private By frameIdtwo = By.xpath("//iframe[@name='popup_1630334370908']");
    private By paylist = By.xpath("//div[@class='list-title text-actionable-bold']");
    //private By paylist = By.xpath("//div[@id='payment-list']//div//a//div[@class='list-content']//div[@class='list-title text-actionable-bold']");
    private By creditcard = By.xpath("//div[text()='Credit/Debit Card']");
    private By midtranspayment = By.xpath("//span[text()='Midtrans secured payments']");
    private By discountcheckbox = By.xpath("//div[@class='page-container scroll']//div[1]//div[1]//label[1]//input[1]");
    private By discountedvalue = By.xpath("//span[text()='19,990']");
    private By seconddiscountedvalue = By.xpath("//div[@class='input-row']//div[2]//div[1]//label[1]//input[1]");
    private By cardno = By.xpath("//input[@name='cardnumber']");
    private By expiry = By.xpath("//input[@placeholder='MM / YY']");
    private By cvv = By.xpath("//input[@placeholder='123']");
    private By paynowbutton = By.xpath("//a[@class='button-main-content']");
    private By issuingbank = By.xpath("//h1[text()='Issuing Bank']");
    private By merchantname = By.xpath("//label[text()='Merchant Name:']");
    private By itemamount = By.xpath("//label[text()='Amount:']");
    private By transactiontime = By.xpath("//label[text()='Transaction Time:']");
    private By cardnumber = By.xpath("//label[text()='Card Number:']");
    private By failedstatusmsg = By.xpath("//span[text()='Transaction failed']");
    private By otpfield = By.xpath("//input[@id='PaRes']");
    private By okbtn = By.xpath("//button[@name='ok']");
    private By cancelbtn = By.xpath("//button[@name='cancel']");
    private By textcreditordebit = By.xpath("//p[text()='Credit/Debit Card']");
    private By useotherpaymentsmethod = By.xpath("//span[text()='Use Another Payment Options']");


    public Boolean isWrittenTextDisplayed(){
        if(elementUtils.doIsDisplayed(text))
            return true;
        else
            return false;
    }

    public void clickOnBuyNow(){
        elementUtils.doClick(buynowbutton);
    }

    public List<String> getAccountSectionsList() {
        List<String>accountList = new ArrayList<String>();
        List<WebElement> accSectionList = elementUtils.getElements(cart_values);

        for(WebElement e : accSectionList) {
            System.out.println(e.getText());
            accountList.add(e.getText());
            System.out.println(accountList.size());
        }

        return accountList;
    }

    public Boolean elementIsVisible(){
        return elementUtils.doIsDisplayed(shopping_cart);
    }

    public void clickOnCheckOutButton(){
        elementUtils.doClick(checkout_btn);
    }

    public String getElementTextForPillow(){
       return elementUtils.getElementText(amount);
    }

    public Boolean getVisibleTextForPillow(){
        return elementUtils.doIsDisplayed(amount);
    }

    public void enterDetailsOfName(String value){
        elementUtils.doSendKeys(name_placeholder,value);
    }

    public void enterDetailsOfEmail(String value){
        elementUtils.doSendKeys(email_placeholder,value);
    }

    public void enterDetailsOfPhone(String value){
        elementUtils.doSendKeys(phone_no_placeholder,value);
    }

    public void enterDetailsOfCity(String value){
        elementUtils.doSendKeys(city_placeholder,value);
    }

    public void enterDetailsOfAddress(String value){
        elementUtils.doSendKeys(address_placeholder,value);
    }

    public void enterDetailsOfPostalcode(String value){
        elementUtils.doSendKeys(postalcode_placeholder,value);
    }

    public void clickOnCheckoutBtn(){
        elementUtils.doClick(checkout_btn);
    }

    public void navigateToFrame(){
        elementUtils.switchToFrame(frameId);
    }

    public Boolean isDisplayedCocostoreElement(){
       if(elementUtils.doIsDisplayed(cocostore))
           return true;
       else
           return false;
    }

    public String getElementItemNameValue(){
        String textvalue = elementUtils.getElement(item_name).getText();
        System.out.println(textvalue);
        return textvalue;
    }

    public String getElementPriceValue(){
        String textvalue = elementUtils.getElement(price).getText();
        System.out.println(textvalue);
        return textvalue;
    }

    public void clickOnContinueButton(){
        elementUtils.doClick(continuebtn);
    }

    public Boolean isDisplayedSelectPaymentElement(){
        if(elementUtils.doIsDisplayed(selectpayment))
            return true;
        else
            return false;
    }



    public String getElementSelectPaymentValue(){
        String textvalue = elementUtils.getElement(selectpayment).getText();
        System.out.println(textvalue);
        return textvalue;
    }

    public int getAccountSectionCounts(){
        int elementssize = elementUtils.getCount(cart_values);
        return elementssize;
    }

    public List<String> getPaymentList() {
        List<String>paymentlist = new ArrayList<String>();
        elementUtils.waitForElementToBeClickable(paylist,5000);
        List<WebElement> paymentsectionlist = elementUtils.getElements(paylist);

        for(WebElement e : paymentsectionlist) {
            System.out.println(e.getText());
            paymentlist.add(e.getText());

        }

        return paymentlist;
    }

    public void clickOnCreditCard(){
        elementUtils.doClick(creditcard);
    }

    public Boolean isDisplayedElementOnCreditCardPayment(){
       if(elementUtils.doIsDisplayed(merchantname))
           return true;
       else
           return false;
    }

    public void clickOnDiscountCheckbox(){
        elementUtils.doClick(discountcheckbox);
    }

    public String getTextOfDiscountedValue(){
       return elementUtils.getElementText(discountedvalue);
    }

    public void clickOnSecondDiscountedValue(){
        elementUtils.doClick(seconddiscountedvalue);
    }

    public void enterDetailsOfCreditCard(String value1,String value2,String value3){

        elementUtils.doSendKeys(cardno,value1);
        elementUtils.doSendKeys(expiry,value2);
        elementUtils.doSendKeys(cvv,value3);

    }


    public Boolean isDisplayedElementIssuingBank(){
        if(elementUtils.doIsDisplayed(issuingbank))
            return true;
        else
            return false;
    }

    public String getTextForElementMerchant(){
        return elementUtils.getElementText(merchantname);
    }

    public String getTextForElementAmount(){
        return elementUtils.getElementText(itemamount);
    }

    public String getTextForElementTransaction(){
        return elementUtils.getElementText(transactiontime);
    }

    public String getTextForElementCardNumber(){
        return elementUtils.getElementText(cardnumber);
    }

    public String getTextForElementIssuingBank(){
        return elementUtils.getElementText(issuingbank);
    }

    public String getTextForElementFailedStatusMsg(){
        return elementUtils.getElementText(failedstatusmsg);
    }

    public Boolean isTextOfFailedStatusMsgDisplayed(){
        if(elementUtils.doIsDisplayed(useotherpaymentsmethod))
            return true;
        else
            return false;
    }

    public void enterOTP(String value){
        elementUtils.doSendKeys(otpfield,value);
    }

    public void clickOnOkButton(){
        elementUtils.doClick(okbtn);
        elementUtils.holdExecutionForSeconds(3000);
        driver.switchTo().frame(0);
    }

    public void clickOnPayNowButton(){
        elementUtils.doClick(paynowbutton);
        driver.switchTo().frame(0);

    }

    public void clickOnCancelButton(){
        elementUtils.holdExecutionForSeconds(3000);
        elementUtils.doClick(cancelbtn);

    }

}
