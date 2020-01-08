package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataGiven;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private SelenideElement codeField = $("[name = 'code']");
    private SelenideElement verifyButton = $("[data-test-id='action-verify']");

    public MyAccountPage validVerify() {
        codeField.waitUntil(Condition.visible, 15000);
        codeField.setValue(DataGiven.getUserVerificationCode());
        verifyButton.click();
        $(withText("Ваши карты")).waitUntil(Condition.visible, 15000);
        return new MyAccountPage();
    }
}