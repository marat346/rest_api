package com.calisto.spring.rest_api.validate;

public class LoginValidate {
    public static String loginValidate(String login) {
        if (login == null) {
            throw new IllegalArgumentException("Login не должен быть пустым");
        }

        boolean flag = true;
        for (int i = 0; i < login.length(); i++) {
            if(Character.isDigit(login.charAt(i)) {
                flag = false;
                break;
            }
        }

            if (!flag) {
                throw new IllegalArgumentException("Пароль латинецей и без цифр");
            }
            return login;
    }
}


