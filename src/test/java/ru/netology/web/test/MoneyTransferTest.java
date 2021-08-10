package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.CardsPage;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.TransferPage;

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

    @Test
    void shouldTransferMoneyBetweenOwnCardsV4() {
        CardsPage cardsPage = new CardsPage();
        int firstCardStartBalance = cardsPage.getCardBalance(0);
        int secondCardStartBalance = cardsPage.getCardBalance(1);
        TransferPage transferPage = cardsPage.firstCardUp();
        int transferAmount = 394;
//        TransferPage transferPage = new TransferPage();
        transferPage.changeCardBalanse(Integer.toString(transferAmount), DataHelper.getCardsInfo().getSecond());
        assertEquals(firstCardStartBalance + transferAmount, cardsPage.getCardBalance(0));
        assertEquals(secondCardStartBalance - transferAmount, cardsPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV5() {
        CardsPage cardsPage = new CardsPage();
        int firstCardStartBalance = cardsPage.getCardBalance(0);
        int secondCardStartBalance = cardsPage.getCardBalance(1);
        TransferPage transferPage = cardsPage.secondCardUp();
        int transferAmount = 748;
//        TransferPage transferPage = new TransferPage();
        transferPage.changeCardBalanse(Integer.toString(transferAmount), DataHelper.getCardsInfo().getFirst());
        assertEquals(firstCardStartBalance - transferAmount, cardsPage.getCardBalance(0));
        assertEquals(secondCardStartBalance + transferAmount, cardsPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV7() {
        CardsPage cardsPage = new CardsPage();
        int firstCardStartBalance = cardsPage.getCardBalance(0);
        int secondCardStartBalance = cardsPage.getCardBalance(1);
        TransferPage transferPage = cardsPage.secondCardUp();
        int transferAmount = 150_000;
//        TransferPage transferPage = new TransferPage();
        transferPage.changeCardBalanse(Integer.toString(transferAmount),DataHelper.getCardsInfo().getFirst());
        assertEquals(firstCardStartBalance - transferAmount, cardsPage.getCardBalance(0));
        assertEquals(secondCardStartBalance + transferAmount, cardsPage.getCardBalance(1));
    }
}