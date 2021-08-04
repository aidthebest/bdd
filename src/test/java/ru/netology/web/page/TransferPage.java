package ru.netology.web.page;

import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {
    public static void changeFirstCardBalanse(String amount, DataHelper.CardsNumber info) {
        $("[data-test-id=\"action-deposit\"]").click();
        $("[data-test-id=amount] input").setValue(amount);
        $("[data-test-id=from] input").setValue(info.getSecond());
        $("[data-test-id=\"action-transfer\"").click();
        new DashboardPage();
    }

    public static void changeSecondCardBalanse(String amount, DataHelper.CardsNumber info) {
        $$("[data-test-id=\"action-deposit\"]").get(1).click();
        $("[data-test-id=amount] input").setValue(amount);
        $("[data-test-id=from] input").setValue(info.getFirst());
        $("[data-test-id=\"action-transfer\"]").click();
        new DashboardPage();
    }
}
