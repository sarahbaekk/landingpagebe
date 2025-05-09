package com.petapp.signup;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SignupController {

    @PostMapping("/signup")
    public String handleSignup(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        System.out.println("✅ Received email: " + email);
        return "Thanks! Your email was received.";
    }
}
