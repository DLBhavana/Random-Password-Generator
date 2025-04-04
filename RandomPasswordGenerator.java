import java.util.*;

public class RandomPasswordGenerator {

    // Method to generate a random password
    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                           boolean includeDigits, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        StringBuilder characterPool = new StringBuilder();

        // Add characters to the pool based on user preferences
        if (includeUppercase) {
            characterPool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (includeLowercase) {
            characterPool.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (includeDigits) {
            characterPool.append("0123456789");
        }
        if (includeSpecialChars) {
            characterPool.append("!@#$%^&*()-_=+[{]}|;:,.<>?/");
        }

        // If the character pool is empty, return an error message
        if (characterPool.length() == 0) {
            return "Error: You must include at least one character type.";
        }

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get password length from the user
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        // Get password criteria from the user
        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUppercase = scanner.nextBoolean();
        
        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLowercase = scanner.nextBoolean();

        System.out.print("Include digits? (true/false): ");
        boolean includeDigits = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecialChars = scanner.nextBoolean();

        // Generate and display the password
        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }
}
