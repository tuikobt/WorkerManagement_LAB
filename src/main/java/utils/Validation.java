package utils;

import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    //Check limit input
    public static int checkInputIntLimit(String s, int min, int max) {
        while(true) {
            System.out.print(s);
            try {
                int res = Integer.parseInt(sc.nextLine().trim());
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
    public static String checkInputString(String s) {
        while(true) {
            System.out.print(s);
            String res = sc.nextLine().trim();
            if (res.isEmpty()) {
                System.err.println("Input cannot be empty");
                continue;
            }
            return res;
        }
    }

    //Check salary
    public static int checkInputPositiveAmount(String s) {
        while(true) {
            System.out.print(s);
            try {
                int res = Integer.parseInt(sc.nextLine().trim());
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
    public static int checkInputAge(String s){
        return checkInputIntLimit(s, 18, 50);
    }
}
