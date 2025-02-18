import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to compress: \"aaabb\" > \"a3b2\" ");
        String inputToCompress = scanner.nextLine();
        System.out.println("Compressed: " + compress(inputToCompress));

        System.out.println("Enter a string to decompress: \"abc\" > \"a1b1c1\" ");
        String inputToDecompress = scanner.nextLine();
        System.out.println("Decompressed: " + decompress(inputToDecompress));

        scanner.close();
    }

    // Method to compress the string
    public static String compress(String input) {
        // Check for empty input

    
        if (input.isEmpty()) {
            return "\"\"";
        }

        // Initialize variables
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        // Iterate through the string
        for (int i = 1; i < input.length(); i++) {
            // Count consecutive characters
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                // Append character and count to the compressed string
                compressed.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        // Append the last character and count
        compressed.append(input.charAt(input.length() - 1)).append(count);

        // Return the compressed string
        return compressed.toString();
    }

    // Method to decompress the string
    public static String decompress(String input) {
        // Check for empty input
        if (input.isEmpty()) {
            return "\"\"";
        }

        // Initialize variables
        StringBuilder decompressed = new StringBuilder();

        // Iterate through the string
        for (int i = 0; i < input.length(); i += 2) {
            // Extract character and count
            char character = input.charAt(i);
            int count = Character.getNumericValue(input.charAt(i + 1));

            // Append character multiple times
            for (int j = 0; j < count; j++) {
                decompressed.append(character);
            }
        }

        // Return the decompressed string
        return decompressed.toString();
    }
    
    
}