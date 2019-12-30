package myTests;
import com.codeborne.selenide.Condition;
import lombok.Data;
import lombok.Value;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.TransferPage;
import pages.VerificationPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@Value
@Data
 public class ServiceTest {

    LoginPage loginPage = new LoginPage();
    VerificationPage verificationPage = new VerificationPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    TransferPage transferPage = new TransferPage();

    @Test
    void shouldLogin() {
        open("http://localhost:9999");
        loginPage.verifyIfIsLoginPage();// проверили оно ли
        loginPage.validLogin();//залогинились корректно
        verificationPage.validVerify();//подтвердили смской
        $(withText("Пополнить")).waitUntil(Condition.visible, 15000);//убедились что зашли в личный кабинет
    }
     @Test
     void shouldTransferToCard0001(){
            open("http://localhost:9999");
            loginPage.verifyIfIsLoginPage();// проверили оно ли
            loginPage.validLogin();//залогинились корректно
            verificationPage.validVerify();//подтвердили смской
            $(withText("Пополнить")).waitUntil(Condition.visible,15000);//убедились что зашли в личный кабинет
            int card1Balance = myAccountPage.balance0001();// запомнили начальный баланс нарты 1
            int card2Balance = myAccountPage.balance0002();// запомнили начальный баланс карты 2
            myAccountPage.transferToFirstCard();//нажали кнопку пополнить карту 1
            $(withText("Пополнение карты")).waitUntil(Condition.visible,15000); //дождались окошка перевода
            transferPage.transferToFirstCard300Rub();// переводим 300 рублей
            // дожидаемся появления личного кабинета
            $(withText("Ваши карты")).waitUntil(Condition.visible,15000);
            int actualCard1 = myAccountPage.balance0001();
            int actualCard2 = myAccountPage.balance0002();
         assertEquals(card1Balance + 300, actualCard1);
         assertEquals(card2Balance-300, actualCard2  );
         System.out.println(card1Balance + " " + actualCard1);
        }


    @Test
    void shouldTransferToCard0002(){
        open("http://localhost:9999");
        loginPage.verifyIfIsLoginPage();// проверили оно ли
        loginPage.validLogin();//залогинились корректно
        verificationPage.validVerify();//подтвердили смской
        $(withText("Пополнить")).waitUntil(Condition.visible,15000);//убедились что зашли в личный кабинет
        int card1Balance = myAccountPage.balance0001();// запомнили начальный баланс нарты 1
        int card2Balance = myAccountPage.balance0002();
        myAccountPage.transferToSecondCard();//жмем кнопку пополнить карту 2
        $(withText("Пополнение карты")).waitUntil(Condition.visible,15000);
        transferPage.transferToSecondCardAmount(50);
        $(withText("Ваши карты")).waitUntil(Condition.visible,15000);
        int actualCard1 = myAccountPage.balance0001();
        int actualCard2 = myAccountPage.balance0002();
        assertEquals( card2Balance + 50, actualCard2);
        assertEquals(actualCard1, card1Balance - 50);
        System.out.println(card2Balance + " " + actualCard2);

    }
    @Test
    void shouldReloadMyAccountPage(){
        open("http://localhost:9999");
        loginPage.verifyIfIsLoginPage();// проверили оно ли
        loginPage.validLogin();//залогинились корректно
        verificationPage.validVerify();//подтвердили смской
        $(withText("Пополнить")).waitUntil(Condition.visible,15000);//убедились что зашли в личный кабинет
        myAccountPage.reloadPage();
    }
    @Test
    void shouldCancelTransfer(){
        open("http://localhost:9999");
        loginPage.verifyIfIsLoginPage();// проверили оно ли
        loginPage.validLogin();//залогинились корректно
        verificationPage.validVerify();//подтвердили смской
        $(withText("Пополнить")).waitUntil(Condition.visible,15000);//убедились что зашли в личный кабинет
        myAccountPage.transferToSecondCard();//жмем кнопку пополнить карту 2
        $(withText("Пополнение карты")).waitUntil(Condition.visible,15000);
        transferPage.cancelTransfer();
        $(withText("Ваши карты")).waitUntil(Condition.visible,15000);

    }
}




