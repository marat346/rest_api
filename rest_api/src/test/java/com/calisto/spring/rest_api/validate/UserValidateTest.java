package com.calisto.spring.rest_api.validate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

class UserValidateTest {

    @Test
    public void whenPasswordIswW3wwwwwThrowsException() {
        String password = "wW3wwwww";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> UserValidate.userValidate(password));
        Assertions.assertEquals("Password must have at least 1 special symbol", thrown.getMessage());
    }
}