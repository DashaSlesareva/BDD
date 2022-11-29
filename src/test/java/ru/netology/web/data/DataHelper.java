package ru.netology.web.data;

import lombok.Data;


@Data
public class DataHelper {
    private String login = "vasya";
    private String password = "qwerty123";
    private String verificationCode = "12345";
    private String[] cards = {"5559 0000 0000 0001", "5559 0000 0000 0002"};

    public String getCard(int index) {
        return cards[index];
    }


}
