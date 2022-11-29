package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import javax.xml.crypto.Data;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginField = $("[data-test-id='login'] input");
    private SelenideElement passwordField = $("[data-test-id='password'] input");
    private SelenideElement loginButton = $("[data-test-id='action-login']");

    public VerificationPage login(DataHelper user) {
        loginField.val(user.getLogin());
        passwordField.val(user.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
