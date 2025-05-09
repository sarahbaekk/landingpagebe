package com.petapp.signup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccessService {

    @Value("${access.token}")
    private String accessToken;

    @Value("${access.key}")
    private String accessKey;

    @Value("${access.secret}")
    private String accessSecret;

    public void printAccessInfo() {
        System.out.println("🔐 Access Token: " + accessToken);
        System.out.println("🗝️ Access Key: " + accessKey);
        System.out.println("🕵️ Access Secret: " + accessSecret);
    }
}
