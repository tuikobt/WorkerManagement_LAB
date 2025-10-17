import constants.Messages;
import controllers.WorkerController;
import dto.WorkerDTO;
import exception.SystemException;
import utils.Validation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SystemException {
        WorkerController controller = new WorkerController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(Messages.MENU);
            System.out.print(Messages.ENTER_CHOICE);
            String inputChoice = sc.nextLine();
            int choice = Validation.checkInputIntLimit(inputChoice, 1, 5);

            try {
                WorkerDTO inputForm = new WorkerDTO();

                switch (choice) {
                    case 1:
                        System.out.println(Messages.TITLE_ADD);

                        System.out.print(Messages.ENTER_CODE);
                        inputForm.setId(Validation.checkInputString(sc.nextLine()));

                        System.out.print(Messages.ENTER_NAME);
                        inputForm.setName(Validation.checkInputString(sc.nextLine()));

                        System.out.print(Messages.ENTER_AGE);
                        inputForm.setAge(Validation.checkInputAge(sc.nextLine()));

                        System.out.print(Messages.ENTER_SALARY);
                        inputForm.setSalary(Validation.checkInputPositiveAmount(sc.nextLine()));

                        System.out.print(Messages.ENTER_LOCATION);
                        inputForm.setLocaton(Validation.checkInputString(sc.nextLine()));

                        controller.addWorker(inputForm);
                        System.out.println("Add successful");
                        break;

                    case 2:
                        System.out.println(Messages.TITLE_INCREASE);

                        System.out.print(Messages.ENTER_CODE);
                        inputForm.setId(Validation.checkInputString(sc.nextLine()));

                        System.out.print(Messages.ENTER_AMOUNT);
                        inputForm.setAmount(Validation.checkInputPositiveAmount(sc.nextLine()));

                        controller.increaseSalary(inputForm);
                        System.out.println("Increase successful");
                        break;

                    case 3:
                        System.out.println(Messages.TITLE_DECREASE);

                        System.out.print(Messages.ENTER_CODE);
                        inputForm.setId(Validation.checkInputString(sc.nextLine()));

                        System.out.print(Messages.ENTER_AMOUNT);
                        inputForm.setAmount(Validation.checkInputPositiveAmount(sc.nextLine()));

                        controller.decreaseSalary(inputForm);
                        System.out.println("Decrease successful");
                        break;

                    case 4:
                        System.out.println(Messages.TITLE_DISPLAY);
                        controller.displayInformation();
                        break;

                    case 5:
                        return;
                }

            } catch (SystemException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
