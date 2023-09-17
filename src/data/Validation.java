package data;

import java.util.regex.Pattern;

public class Validation {
    public static boolean isPositiveInteger(String input) {
        // Kiểm tra xem input có phải là một số nguyên dương bằng regex
        return Pattern.matches("\\d+", input);
    }
}