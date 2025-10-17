package constants;

public class Messages {
    public static final String MENU =
            "======= Worker Management =======\n" +
                    "1. Add Worker\n" +
                    "2. Increase Salary\n" +
                    "3. Decrease Salary\n" +
                    "4. Display Information\n" +
                    "5. Exit\n";

    public static final String TITLE_ADD = "-------- Add Worker --------";
    public static final String TITLE_INCREASE = "-------- Increase Salary --------";
    public static final String TITLE_DECREASE = "-------- Decrease Salary --------";
    public static final String TITLE_DISPLAY = "-------- Display Salary History --------";

    public static final String ENTER_CHOICE = "Enter your choice: ";
    public static final String ENTER_CODE = "Enter code: ";
    public static final String ENTER_NAME = "Enter name: ";
    public static final String ENTER_AGE = "Enter age: ";
    public static final String ENTER_SALARY = "Enter salary: ";
    public static final String ENTER_LOCATION = "Enter location: ";
    public static final String ENTER_AMOUNT = "Enter amount: ";

    public static final String DISPLAY_HEADER = String.format("%-5s %-10s %-5s %-10s %-10s %-20s",
            "Code", "Name", "Age", "Salary", "Status", "Date");
}
