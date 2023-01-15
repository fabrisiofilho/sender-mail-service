package br.com.bluty.senderservice.configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentVariable {

    public static final String EMAIL_USER = System.getenv("EMAIL_USER");
    public static final String EMAIL_PASS = System.getenv("EMAIL_PASS");

}