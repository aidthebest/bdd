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
        $("[class=button__content]").click();
        $("[class=input__control]").setValue(amount);
        $("[type=tel]").setValue("5559 0000 0000 0002");
        $("[class=button__text]").click();
    }

    public static void changeSecondCardBalanse(String amount) {
        $$("[class=button__content]").get(1).click();
        $("[class=input__control]").setValue(amount);
        $("[type=tel]").setValue("5559 0000 0000 0001");
        $("[class=button__text]").click();
    }
}