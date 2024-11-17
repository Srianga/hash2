package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generateHash")
public class hash2 {

    // Enable CORS globally for this endpoint
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping
    public String generateHash(@RequestBody String input) {
        return simpleHash(input);
    }

    // Simple hash generation method
    public static String simpleHash(String input) {
        int result = 7;
        int multiplier = 31;
        StringBuilder hash = new StringBuilder();

        // Generate the hash using the input string
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            result = result * multiplier + (character << (i % 8));
        }

        // Convert the result to hex and append
        hash.append(Integer.toHexString(result));

        // Ensure the hash is 64 characters long
        while (hash.length() < 64) {
            hash.append(Integer.toHexString((result++) * multiplier).substring(0, 4));
        }

        return hash.substring(0, 64);
    }
}
