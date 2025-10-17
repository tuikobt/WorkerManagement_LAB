package utils;

public class Validation {

    //Check limit input
    public static int checkInputIntLimit(String input,int min, int max) {
        while(true) {
            try {
                int res = Integer.parseInt(input.trim());
                if (res < min || res > max) {
                    System.err.println("Input must be in range [" + min + ", " + max + "]");
                    continue;
                }
                return res;
            } catch (NumberFormatException e) {
                System.err.println("Invalid value");
            }
        }
    }

    //Check string empty
    public static String checkInputString(String input) {
        while(true) {
            String res = input.trim();
            if (res.isEmpty()) {
                System.err.println("Input cannot be empty");
                continue;
            }
            return res;
        }
    }

    //Check salary
    public static int checkInputPositiveAmount(String input) {
        while(true) {
            try {
                int res = Integer.parseInt(input.trim());
                if (res < 0) {
                    System.err.println("Salary must be greater than 0");
                    continue;
                }
                return res;
            } catch (NumberFormatException e) {
                System.err.println("Invalid value");
            }
        }
    }

    //Check age
    public static int checkInputAge(String input) {
        return checkInputIntLimit(input,18, 50);
    }
}
