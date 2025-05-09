package com.petapp.signup;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class SignupController {

    private final AccessService accessService;

    // Constructor injection of AccessService
    public SignupController(AccessService accessService) {
        this.accessService = accessService;
    }

    @PostMapping("/signup")
    public String handleSignup(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        System.out.println("✅ Received email: " + email);

        // 🔑 This will print the access values from your environment
        accessService.printAccessInfo();

        return "Thanks! Your email was received.";
    }
}
