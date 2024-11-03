package com.example.URLShortner.ServiceLayer;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class URLShortenerUtils {

    // Generate a short URL key using Murmur3 hashing and Base62 encoding
    public static String generateShortUrlKey(String originalUrl) {
        // Generate a 32-bit hash using Murmur3 (non-deprecated version)
        int murmurHash = Hashing.murmur3_32_fixed().hashString(originalUrl, StandardCharsets.UTF_8).asInt();

        // Convert hash to positive value (Murmur3 can generate negative values)
        System.out.println("murmurhash " + murmurHash);
        murmurHash = Math.abs(murmurHash);

        // Convert the hash to Base62 for URL-friendliness
        return encodeBase62(murmurHash);
    }

    // Base62 encoding method
    private static String encodeBase62(int num) {
        final String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder encoded = new StringBuilder();

        while (num > 0) {
            encoded.append(chars.charAt(num % 62));
            num /= 62;
        }
        System.out.println(" final jo shore hoga  "+ encoded.reverse().toString());
        return encoded.reverse().toString();
    }
}
