package data;

import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

public class WorkingSession {
    public static CharSequence sumTransfer = new String("300"); // задаем сумму перевода

    @BeforeEach
    public void startOfWork() {
        LoginPage loginPage = new LoginPage();
        VerificationPage verificationPage = new VerificationPage();
        open("http://localhost:9999");
        loginPage.verifyIfIsLoginPage();// проверили оно ли
        loginPage.validLogin();//залогинились корректно
        verificationPage.validVerify();//подтвердили смской
    }
}