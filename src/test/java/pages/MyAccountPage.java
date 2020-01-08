package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAccountPage {

    private static SelenideElement transferToFirstCardButton = $("[data-test-id = 'action-deposit']");
    private static SelenideElement transferToSecondCardButton = $$("[data-test-id = 'action-deposit']").get(1);
    private static SelenideElement reloadButton = $("[data-test-id = 'action-reload']");


    public MyAccountPage() {
    }

    public TransferPage transferToFirstCard() {
        transferToFirstCardButton.click();
        $(withText("Пополнение карты")).waitUntil(Condition.visible, 15000);
        return new TransferPage();
    }

    public TransferPage transferToSecondCard() {

        transferToSecondCardButton.click();
        $(withText("Пополнение карты")).waitUntil(Condition.visible, 15000);
        return new TransferPage();
    }

    public MyAccountPage reloadPage() {
        reloadButton.click();
        return new MyAccountPage();
    }

    public Integer balance0001() {
        String text = $(withText("0001")).text();
        String str = text.substring(text.indexOf(":"), text.lastIndexOf("р"));
        Pattern intsOnly = Pattern.compile("\\d+");
        Matcher makeMatch = intsOnly.matcher(str);
        makeMatch.find();
        String inputInt1 = makeMatch.group();
        inputInt1.trim();
        int balance0001 = Integer.parseInt(inputInt1);
        return balance0001;
    }

    public Integer balance0002() {
        String text = $(withText("0002")).text();
        String str2 = text.substring(text.indexOf(":"), text.lastIndexOf("р"));
        Pattern intsOnly = Pattern.compile("\\d+");
        Matcher makeMatch = intsOnly.matcher(str2);
        makeMatch.find();
        String inputInt2 = makeMatch.group();
        inputInt2.trim();
        int balance0002 = Integer.parseInt(inputInt2);
        return balance0002;
    }
}