package ru.netology.web.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.TransferPage;
import ru.netology.web.page.VerificationPage;

import javax.xml.crypto.Data;

import static com.codeborne.selenide.Selenide.open;

public class TransferTests {

    DataHelper userInfo = new DataHelper();

    @BeforeEach
    public void setUp() {
        open("http://localhost:9999");


    }


    @Test
    public void positiveTestTransferFromCardAToCardB() {
        int amount = 200;
        int indexA = 0;
        int indexB = 1;
        LoginPage loginPage = new LoginPage();
        VerificationPage verificationPage = loginPage.login(userInfo);
        DashboardPage dashboardPage = verificationPage.verify(userInfo);
        int amountCard0BeforeTransfer = dashboardPage.getBallance(indexA);
        int amountCard1BeforeTransfer = dashboardPage.getBallance(indexB);
        TransferPage transferPage = dashboardPage.transferFromCard(indexA);
        transferPage.transfer(userInfo, amount, indexB);
        int amountCard0AfterTransfer = dashboardPage.getBallance(indexA);
        int amountCard1AfterTransfer = dashboardPage.getBallance(indexB);
        Assertions.assertEquals(amountCard0BeforeTransfer, (amountCard0AfterTransfer - amount));
        Assertions.assertEquals(amountCard1BeforeTransfer, (amountCard1AfterTransfer + amount));
        dashboardPage.transferFromCard(indexB);
        transferPage.transfer(userInfo, amount, indexA);
    }

}
