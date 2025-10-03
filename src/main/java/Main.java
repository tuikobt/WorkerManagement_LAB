import constants.Messages;
import controllers.WorkerController;
import dto.WorkerDTO;
import exception.SystemException;
import utils.Validation;

public class Main {
    public static void main(String[] args) throws SystemException {
        WorkerController controller = new WorkerController();

        while(true) {
            System.out.print(Messages.MENU);
            int choice = Validation.checkInputIntLimit("Enter your choice: ", 1, 5);

            try {
                WorkerDTO inputForm = new WorkerDTO();

                switch (choice) {
                    case 1:
                        System.out.println(Messages.TITLE_ADD);
                        inputForm.setId(Validation.checkInputString("Enter code: "));
                        inputForm.setName(Validation.checkInputString("Enter name: "));
                        inputForm.setAge(Validation.checkInputAge("Enter age: "));
                        inputForm.setSalary(Validation.checkInputPositiveAmount("Enter salary: "));
                        inputForm.setLocaton(Validation.checkInputString("Enter location: "));
                        controller.addWorker(inputForm);
                        System.out.println("Add successful");
                        break;

                    case 2:
                        System.out.println(Messages.TITLE_INCREASE);
                        inputForm.setId(Validation.checkInputString("Enter Code: "));
                        inputForm.setAmount(Validation.checkInputPositiveAmount("Enter amount to increase: "));
                        controller.increaseSalary(inputForm);
                        System.out.println("Increase successful");
                        break;

                    case 3:
                        System.out.println(Messages.TITLE_DECREASE);
                        inputForm.setId(Validation.checkInputString("Enter Code: "));
                        inputForm.setAmount(Validation.checkInputPositiveAmount("Enter amount to decrease: "));
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
