package myTests;

import com.codeborne.selenide.Condition;
import data.WorkingSession;
import org.junit.jupiter.api.Test;
import pages.MyAccountPage;
import pages.TransferPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class ServiceTest {

    MyAccountPage myAccountPage = new MyAccountPage();
    WorkingSession workingSession = new WorkingSession();
    TransferPage transferPage = new TransferPage();


    @Test
    void shouldLogin() {
        workingSession.startOfWork();
        $(withText("Пополнить")).waitUntil(Condition.visible, 15000);//убедились что зашли в личный кабинет
    }

    @Test
    void shouldTransferToCard0001() {
        workingSession.startOfWork();
        $(withText("Пополнить")).waitUntil(Condition.visible, 15000);//убедились что зашли в личный кабинет
        transferPage.transferToFirstCard();
        $(withText("Ваши карты")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void shouldTransferToCard0002() {
        workingSession.startOfWork();
        $(withText("Пополнить")).waitUntil(Condition.visible, 15000);//убедились что зашли в личный кабинет
        transferPage.transferToSecondCard();
        $(withText("Ваши карты")).waitUntil(Condition.visible, 15000);

    }

    @Test
    void shouldReloadMyAccountPage() {
        workingSession.startOfWork();
        $(withText("Пополнить")).waitUntil(Condition.visible, 15000);//убедились что зашли в личный кабинет
        myAccountPage.reloadPage();
    }

    @Test
    void shouldCancelTransfer() {
        workingSession.startOfWork();
        $(withText("Пополнить")).waitUntil(Condition.visible, 15000);//убедились что зашли в личный кабинет
        myAccountPage.transferToSecondCard();//жмем кнопку пополнить карту 2
        $(withText("Пополнение карты")).waitUntil(Condition.visible, 15000);
        transferPage.cancelTransfer();
        $(withText("Ваши карты")).waitUntil(Condition.visible, 15000);
    }
}