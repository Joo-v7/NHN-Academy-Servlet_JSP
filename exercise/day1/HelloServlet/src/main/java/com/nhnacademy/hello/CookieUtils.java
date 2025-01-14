package com.nhnacademy.hello;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class CookieUtils {

    private CookieUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        return Optional.ofNullable(request.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                        .filter(c->c.getName().equals(name))
                        .findFirst())
                .orElse(null);
    }
}
