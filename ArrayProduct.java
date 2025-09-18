import java.util.Arrays;

public class ArrayProduct {
    public static void main(String[] args) {
        // Retrieve the environment variable 'a'
        String envVar = System.getenv("a");

        if (envVar == null || envVar.isEmpty()) {
            System.err.println("Error: Environment variable 'a' is not set or is empty.");
            System.exit(1);
        }

        // Split the string by comma or space
        String[] parts = envVar.trim().split("[,\\s]+");

        long product = 1;
        boolean isValid = true;

        System.out.print("Processing elements: ");
        for (String part : parts) {
            try {
                int number = Integer.parseInt(part);
                System.out.print(number + " ");
                product *= number;
            } catch (NumberFormatException e) {
                System.err.println("\nError: '" + part + "' is not a valid integer.");
                isValid = false;
            }
        }
        System.out.println(); // New line after printing elements

        if (isValid) {
            System.out.println("The product of the array elements is: " + product);
        } else {
            System.exit(1);
        }
    }
}