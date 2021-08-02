package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private static final ElementsCollection cards = $$(".list__item");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public static int getCardBalance(int index) {
        val text = cards.get(index).text();
        return extractBalance(text);
    }

    private static int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public static void changeFirstCardBalanse(String amount) {
        $("[data-test-id=\"action-deposit\"]").click();
        $("[data-test-id=amount] input").setValue(amount);
        $("[data-test-id=from] input").setValue("5559 0000 0000 0002");
        $("[data-test-id=\"action-transfer\"").click();
    }

    public static void changeSecondCardBalanse(String amount) {
        $$("[data-test-id=\"action-deposit\"]").get(1).click();
        $("[data-test-id=amount] input").setValue(amount);
        $("[data-test-id=from] input").setValue("5559 0000 0000 0001");
        $("[data-test-id=\"action-transfer\"]").click();
    }
}