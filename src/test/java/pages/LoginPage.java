package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataGiven;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import pages.VerificationPage;

import static com.codeborne.selenide.Selenide.$;

@Value
@Data
@NoArgsConstructor

public class LoginPage {

    private SelenideElement loginField = $("[name = 'login']");
    private SelenideElement passwordField = $("[name = 'password']");
    private SelenideElement loginButton = $("[data-test-id = 'action-login']");

    public void verifyIfIsLoginPage() {
        loginField.waitUntil(Condition.appear, 5000);
        loginButton.shouldBe(Condition.visible);

    }


    public VerificationPage validLogin() {
        loginField.setValue(DataGiven.getUserLogin());
        passwordField.setValue(DataGiven.getUserPassword());
        loginButton.click();


        return new VerificationPage();

    }
}
