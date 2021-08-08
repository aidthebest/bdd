package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromCardField = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=\"action-transfer\"]");
    private SelenideElement heading = $("[data-test-id=dashboard]");

    public TransferPage() {
        heading.shouldBe(visible);
    }

    public CardsPage changeFirstCardBalanse(String amount, String cardsNumber) {
        amountField.setValue(amount);
        fromCardField.setValue(cardsNumber);
        transferButton.click();
        return new CardsPage();
    }

    public CardsPage changeSecondCardBalanse(String amount, String cardsNumber) {
        amountField.setValue(amount);
        fromCardField.setValue(cardsNumber);
        transferButton.click();
        return new CardsPage();
    }



//    public CardsPage changeFirstCardBalanse(String amount, String cardsNumber) {
//        $("[data-test-id=\"action-deposit\"]").click();
//        $("[data-test-id=amount] input").setValue(amount);
//        $("[data-test-id=from] input").setValue(cardsNumber);
//        $("[data-test-id=\"action-transfer\"").click();
//        return new CardsPage();
//    }
//
//    public CardsPage changeSecondCardBalanse(String amount, String cardsNumber) {
//        $$("[data-test-id=\"action-deposit\"]").get(1).click();
//        $("[data-test-id=amount] input").setValue(amount);
//        $("[data-test-id=from] input").setValue(cardsNumber);
//        $("[data-test-id=\"action-transfer\"]").click();
//        return new CardsPage();
//    }
}
