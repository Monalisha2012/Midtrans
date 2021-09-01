package Utility;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Constants {


    public static List<String> getAccountSectionList(){
        List<String> accountList = new ArrayList<String>();
        accountList.add("Name\nEmail\nPhone no\nCity\nAddress MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11\nPostal Code");
        return accountList;
    }

    public static List<String> getPaymentSectionList(){
        List<String> accountList = new ArrayList<String>();
        accountList.add("Credit/Debit Card");
        accountList.add("ATM/Bank Transfer");
        accountList.add("GoPay/other e-Wallets");
        accountList.add("ShopeePay/other e-Wallets");
        accountList.add("KlikBCA");
        accountList.add("BCA KlikPay");
        accountList.add("OCTO Clicks");
        accountList.add("Danamon Online Banking");
        accountList.add("e-Pay BRI");
        accountList.add("LINE Pay e-cash | mandiri e-cash");
        accountList.add("Telkomsel Cash");
        accountList.add("Indomaret");
        accountList.add("Alfa Group");
        accountList.add("Akulaku");
        return accountList;
    }

    public static final int ELEMENTS_COUNTS = 6;
    public static final String PILLOW_AMOUNT = "20000";
    public static final String ITEM_NAME = "Midtrans Pillow";
    public static final String ITEM_PRICE = "20,000";
    public static final String SELECT_PAYMENT = "Select Payment";
    public static final String DISCOUNTED_PRICE = "19,990";
    public static final String MERCHANT_NAME = "Merchant Name:";
    public static final String AMOUNT= "Amount:";
    public static final String TRANSACTION = "Transaction Time:";
    public static final String CARDNO = "Card Number:";
    public static final String ISSUING_BANK = "Issuing Bank";
    public static final String FAILED_STATUS = "Transaction failed";
}
