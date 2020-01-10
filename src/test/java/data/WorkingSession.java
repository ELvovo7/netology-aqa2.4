package data;

import com.codeborne.selenide.Condition;
import pages.LoginPage;
import pages.VerificationPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WorkingSession {

    public static void startOfWork() {
        LoginPage loginPage = new LoginPage();
        VerificationPage verificationPage = new VerificationPage();
        open("http://localhost:9999");
        loginPage.verifyIfIsLoginPage();// проверили оно ли
        loginPage.validLogin();//залогинились корректно
        verificationPage.validVerify();//подтвердили смской
        $(withText("Пополнить")).waitUntil(Condition.visible, 15000);//убедились что зашли в личный кабинет
    }
}