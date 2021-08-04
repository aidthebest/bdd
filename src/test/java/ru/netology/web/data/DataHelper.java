package ru.netology.web.data;

import com.codeborne.selenide.ElementsCollection;
import lombok.Value;
import lombok.val;

import static com.codeborne.selenide.Selenide.$$;

public class DataHelper {
    private static ElementsCollection cards = $$(".list__item");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
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
}
