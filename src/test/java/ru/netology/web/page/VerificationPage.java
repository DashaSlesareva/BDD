package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private SelenideElement codeField = $("[data-test-id='code'] input");
    private SelenideElement verifyBurron = $("[data-test-id='action-verify']");

    public DashboardPage verify(DataHelper.VerificationCode code) {
        codeField.val(code.getCode());
        verifyBurron.click();
        return new DashboardPage();
    }
}
