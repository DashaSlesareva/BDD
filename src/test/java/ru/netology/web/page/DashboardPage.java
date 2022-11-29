package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private ElementsCollection cards = $$(".list__item");
    private ElementsCollection topOffButtons = $$("button[data-test-id='action-deposit']");
    private SelenideElement reloadButton = $("button[data-test-id='action-reload']");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public TransferPage transferFromCard(int indexTo) {
        topOffButtons.get(indexTo).click();
        return new TransferPage();
    }

    public int getBallance(int index) {
        val text = cards.get(index).text();
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}
