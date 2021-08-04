package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.TransferPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {

    @BeforeEach
    public void setUp() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

//    @Test
//    void shouldTransferMoneyBetweenOwnCards() {
//        $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] > [data-test-id=\"action-deposit\"").click();
//        $("[data-test-id=amount] input").setValue("5000");
//        $("[data-test-id=from] input").setValue("92df3f1c-a033-48e6-8390-206f6b1f56c0\\");
////        $("[data-test-id=to]").setValue("92df3f1c-a033-48e6-8390-206f6b1f56c0");
//        $("[data-test-id=\"action-transfer\"]").click();
//
//    }


    @Test
    void shouldTransferMoneyBetweenOwnCardsV4() {
        int firstCardStartBalance = DataHelper.getCardBalance(0);
        int secondCardStartBalance = DataHelper.getCardBalance(1);
        int transferAmount = 394;
        TransferPage.changeFirstCardBalanse(Integer.toString(transferAmount), "5559 0000 0000 0002");
        assertEquals(firstCardStartBalance + transferAmount, DataHelper.getCardBalance(0));
        assertEquals(secondCardStartBalance - transferAmount, DataHelper.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV5() {
        int firstCardStartBalance = DataHelper.getCardBalance(0);
        int secondCardStartBalance = DataHelper.getCardBalance(1);
        int transferAmount = 748;
        TransferPage.changeSecondCardBalanse(Integer.toString(transferAmount), "5559 0000 0000 0001");
        assertEquals(firstCardStartBalance - transferAmount, DataHelper.getCardBalance(0));
        assertEquals(secondCardStartBalance + transferAmount, DataHelper.getCardBalance(1));
    }

//    @Test
//    void shouldTransferMoneyBetweenOwnCardsV6() {
//        int firstCardStartBalance = DashboardPage.getCardBalance(0);
//        int secondCardStartBalance = DashboardPage.getCardBalance(1);
//        int transferAmount = -4800;
//        DashboardPage.changeSecondCardBalanse(Integer.toString(transferAmount));
//        assertEquals(firstCardStartBalance - transferAmount, DashboardPage.getCardBalance(0));
//        assertEquals(secondCardStartBalance + transferAmount, DashboardPage.getCardBalance(1));
//    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV7() {
        int firstCardStartBalance = DataHelper.getCardBalance(0);
        int secondCardStartBalance = DataHelper.getCardBalance(1);
        int transferAmount = 150_000;
        TransferPage.changeSecondCardBalanse(Integer.toString(transferAmount),"5559 0000 0000 0001");
        assertEquals(firstCardStartBalance - transferAmount, DataHelper.getCardBalance(0));
        assertEquals(secondCardStartBalance + transferAmount, DataHelper.getCardBalance(1));
    }
}