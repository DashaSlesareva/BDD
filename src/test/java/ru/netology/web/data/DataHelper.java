package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class Card  {
        private String card;

    }

    public static Card getCard (int index) {
        Card one = new Card("5559 0000 0000 0001");
        Card two = new Card("5559 0000 0000 0002");
        Card [] cards = new Card[]{one,two};
        return cards[index];
    }
}