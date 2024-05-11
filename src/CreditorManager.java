import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class to manage creditor information.
 */
public class CreditorManager {

    /**
     * Method to enter creditor information.
     *
     * @param sc The scanner object for user input.
     * @return A list of creditors with their name and debt amounts.
     */
    public static List<Creditor> enterCreditorInformation(Scanner sc) {
        List<Creditor> creditors = new ArrayList<>();

        while (true) {
            System.out.print("Please enter the creditor name: (type 'exit' to quit)");
            String creditorName = sc.nextLine();

            if ("exit".equalsIgnoreCase(creditorName)) break;

            double debtAmount = 0;
            boolean userInput = false;

            while (!userInput) {
                System.out.print("Please enter debt amount for " + creditorName + ": $");
                if (sc.hasNextDouble()) {
                    debtAmount = sc.nextDouble();
                    sc.nextLine();
                    if (debtAmount > 0) {
                        userInput = true;
                    } else {
                        System.out.println("Please enter a positive debt amount.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid decimal number.");
                    sc.nextLine();
                }
            }
            creditors.add(new Creditor(creditorName, debtAmount));
        }
        return creditors;
    }
}
