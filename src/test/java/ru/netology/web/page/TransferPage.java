package ru.netology.web.page;

import ru.netology.web.data.DataHelper;

//import lombok.Value;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {
    public static DashboardPage changeFirstCardBalanse(String amount, String cardsNumber) {
        $("[data-test-id=\"action-deposit\"]").click();
        $("[data-test-id=amount] input").setValue(amount);
        $("[data-test-id=from] input").setValue(cardsNumber);
        $("[data-test-id=\"action-transfer\"").click();
        return new DashboardPage();
    }

    public static DashboardPage changeSecondCardBalanse(String amount, String cardsNumber) {
        $$("[data-test-id=\"action-deposit\"]").get(1).click();
        $("[data-test-id=amount] input").setValue(amount);
        $("[data-test-id=from] input").setValue(cardsNumber);
        $("[data-test-id=\"action-transfer\"]").click();
        return new DashboardPage();
    }
}
