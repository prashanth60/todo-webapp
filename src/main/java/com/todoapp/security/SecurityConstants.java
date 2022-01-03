package com.todoapp.security;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 3600000; // una hora
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SIGN_UP_URL = "/auth/register";
    public static final String JWT_SECRET = "zdtlD3JK56m6wTTgsNFhqzjqP";
}
