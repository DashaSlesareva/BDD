package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement transferAmount = $("[data-test-id='amount'] input");
    private SelenideElement fromCard = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");

    public void transfer(DataHelper user, int amount, int indexFrom) {
        transferAmount.val(String.valueOf(amount));
        fromCard.val(user.getCard(indexFrom));
        transferButton.click();
    }


}
