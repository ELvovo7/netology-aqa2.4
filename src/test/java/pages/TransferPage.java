package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.CardInfoHelper;
import lombok.Data;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
@Data
public class TransferPage {

    private SelenideElement amountField = $("[data-test-id = 'amount'] input");
    private SelenideElement fromCardField = $("[data-test-id = 'from'] input");
    private SelenideElement transferButton = $(withText("Пополнить"));
    private SelenideElement cancelButton = $(withText("Отмена"));

    public MyAccountPage transferToFirstCard300Rub(){
      amountField.sendKeys("300");
      fromCardField.sendKeys(CardInfoHelper.getCard0002Number());
      transferButton.click();
      $(withText("Ваши карты")).waitUntil(Condition.visible,15000);
        return new MyAccountPage();
    }



    public MyAccountPage transferToSecondCardAmount(int amount){

        amountField.setValue(String.valueOf(amount));
        fromCardField.sendKeys(CardInfoHelper.getCard0001Number());
        transferButton.click();
           return new MyAccountPage();
   }

   public MyAccountPage cancelTransfer(){
        cancelButton.click();
        return new MyAccountPage();

   }

}
