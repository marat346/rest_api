package com.calisto.spring.rest_api.validate;

public class UserValidate {
    public static String userValidate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
        boolean isValid = false;
        for (int index = 0; index < name.length(); index++) {
            if (Character.isDigit(name.charAt(index)) &&
                    Character.isLowerCase(name.charAt(index)) &&
                    Character.isUpperCase(name.charAt(index))) {
                isValid = true;
                break;
            }

            if (!isValid) {
                throw new IllegalArgumentException("Password must have at least 1 special symbol");
            }
        }
        return name;
    }
}
