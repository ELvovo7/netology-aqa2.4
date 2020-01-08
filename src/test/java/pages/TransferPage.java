package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.CardInfoHelper;
import data.WorkingSession;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferPage {

    MyAccountPage myAccountPage = new MyAccountPage();


    private SelenideElement amountField = $("[data-test-id = 'amount'] input");
    private SelenideElement fromCardField = $("[data-test-id = 'from'] input");
    private SelenideElement transferButton = $(withText("Пополнить"));
    private SelenideElement cancelButton = $(withText("Отмена"));

    public void transferToFirstCard() {

        int card1Balance = myAccountPage.balance0001();// запомнили начальный баланс нарты 1
        int card2Balance = myAccountPage.balance0002();// запомнили начальный баланс карты 2
        myAccountPage.transferToFirstCard();//нажали кнопку пополнить карту 1
        $(withText("Пополнение карты")).waitUntil(Condition.visible, 15000); //дождались окошка перевода
        amountField.sendKeys(WorkingSession.sumTransfer); // пополняем карту
        fromCardField.sendKeys(CardInfoHelper.getCard0002Number());
        transferButton.click();
        int actualCard1 = myAccountPage.balance0001();
        int actualCard2 = myAccountPage.balance0002();
        assertEquals(card1Balance + Integer.parseInt((String) WorkingSession.sumTransfer), actualCard1);
        assertEquals(card2Balance - Integer.parseInt((String) WorkingSession.sumTransfer), actualCard2);
        new MyAccountPage();
    }

    public MyAccountPage transferToSecondCard() {

        int card1Balance = myAccountPage.balance0001();// запомнили начальный баланс нарты 1
        int card2Balance = myAccountPage.balance0002();
        myAccountPage.transferToSecondCard();//жмем кнопку пополнить карту 2
        $(withText("Пополнение карты")).waitUntil(Condition.visible, 15000);
        amountField.sendKeys(WorkingSession.sumTransfer);
        fromCardField.sendKeys(CardInfoHelper.getCard0001Number());
        transferButton.click();
        int actualCard1 = myAccountPage.balance0001();
        int actualCard2 = myAccountPage.balance0002();
        assertEquals(card2Balance + Integer.parseInt((String) WorkingSession.sumTransfer), actualCard2);
        assertEquals(card1Balance - Integer.parseInt((String) WorkingSession.sumTransfer), actualCard1);
        return new MyAccountPage();
    }

    public MyAccountPage cancelTransfer() {
        cancelButton.click();
        return new MyAccountPage();
    }
}