package ru.netology.web.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.TransferPage;
import ru.netology.web.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

public class TransferTests {



    @BeforeEach
    public void setUp() {
        open("http://localhost:9999");


    }


    @Test
    public void positiveTestTransferFromCardAToCardB() {
        int amount = 200;
        int indexA = 0;
        int indexB = 1;
        var userInfo = DataHelper.getAuthInfo();
        var code = DataHelper.getVerificationCodeFor(userInfo);
        var card1 = DataHelper.getCard(indexA);
        var card2 = DataHelper.getCard(indexB);
        LoginPage loginPage = new LoginPage();
        VerificationPage verificationPage = loginPage.login(userInfo);
        DashboardPage dashboardPage = verificationPage.verify(code);
        int amountCard0BeforeTransfer = dashboardPage.getBalance(indexA);
        int amountCard1BeforeTransfer = dashboardPage.getBalance(indexB);
        TransferPage transferPage = dashboardPage.transferFromCard(indexA);
        transferPage.transfer(card2, amount, indexB);
        int amountCard0AfterTransfer = dashboardPage.getBalance(indexA);
        int amountCard1AfterTransfer = dashboardPage.getBalance(indexB);
        Assertions.assertEquals(amountCard0BeforeTransfer, (amountCard0AfterTransfer - amount));
        Assertions.assertEquals(amountCard1BeforeTransfer, (amountCard1AfterTransfer + amount));
        dashboardPage.transferFromCard(indexB);
        transferPage.transfer(card1, amount, indexA);
    }

}
