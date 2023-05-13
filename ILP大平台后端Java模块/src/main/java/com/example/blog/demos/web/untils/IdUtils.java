package com.example.blog.demos.web.untils;

import java.time.Instant;
import java.util.Random;

public class IdUtils {

        private static final String NUMBERS = "0123456789";
        private static final int ID_LENGTH = 8;
        private static final Random RANDOM = new Random();

        public static String generate() {
            StringBuilder sb = new StringBuilder();
            sb.append(20);
            for (int i = 0; i < ID_LENGTH; i++) {
                int index = RANDOM.nextInt(NUMBERS.length());

                sb.append(NUMBERS.charAt(index));
            }
            return sb.toString();
        }
    }




