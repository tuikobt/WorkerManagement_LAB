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

    public static final String DISPLAY_HEADER = String.format("%-5s %-10s %-5s %-10s %-10s %-20s",
            "Code", "Name", "Age", "Salary", "Status", "Date");
}
