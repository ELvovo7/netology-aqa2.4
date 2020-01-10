package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.CardInfoHelper;
import data.DataGiven;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferPage {

    private static SelenideElement amountField = $("[data-test-id = 'amount'] input");
    private static SelenideElement fromCardField = $("[data-test-id = 'from'] input");
    private static SelenideElement transferButton = $(withText("Пополнить"));
    private static SelenideElement cancelButton = $(withText("Отмена"));

    public static void transferToFirstCard() {
        int card1Balance = MyAccountPage.balance0001();// запомнили начальный баланс нарты 1
        int card2Balance = MyAccountPage.balance0002();// запомнили начальный баланс карты 2
        MyAccountPage.transferToFirstCard();//нажали кнопку пополнить карту 1
        $(withText("Пополнение карты")).waitUntil(Condition.visible, 15000); //дождались окошка перевода
        amountField.sendKeys(DataGiven.getSumTransfer()); // пополняем карту
        fromCardField.sendKeys(CardInfoHelper.getCard0002Number());
        transferButton.click();
        int actualCard1 = MyAccountPage.balance0001();
        int actualCard2 = MyAccountPage.balance0002();
        assertEquals(card1Balance + Integer.parseInt((String) DataGiven.getSumTransfer()), actualCard1);
        assertEquals(card2Balance - Integer.parseInt((String) DataGiven.getSumTransfer()), actualCard2);
        $(withText("Ваши карты")).waitUntil(Condition.visible, 15000);
        new MyAccountPage();
    }

    public static void transferToSecondCard() {
        int card1Balance = MyAccountPage.balance0001();// запомнили начальный баланс нарты 1
        int card2Balance = MyAccountPage.balance0002();
        MyAccountPage.transferToSecondCard();//жмем кнопку пополнить карту 2
        $(withText("Пополнение карты")).waitUntil(Condition.visible, 15000);
        amountField.sendKeys(DataGiven.getSumTransfer());
        fromCardField.sendKeys(CardInfoHelper.getCard0001Number());
        transferButton.click();
        int actualCard1 = MyAccountPage.balance0001();
        int actualCard2 = MyAccountPage.balance0002();
        assertEquals(card2Balance + Integer.parseInt((String) DataGiven.getSumTransfer()), actualCard2);
        assertEquals(card1Balance - Integer.parseInt((String) DataGiven.getSumTransfer()), actualCard1);
        $(withText("Ваши карты")).waitUntil(Condition.visible, 15000);
        new MyAccountPage();
    }

    public static void cancelTransfer() {
        cancelButton.click();
        $(withText("Ваши карты")).waitUntil(Condition.visible, 15000);
        new MyAccountPage();
    }
}