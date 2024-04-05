//Alex Svoboda

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            final double FEE_RATE = 0.25;
            boolean delinquent;
            String name, address, creditor, userInput;


            System.out.println("Welcome to the Debt Settlement Qualification Tool!\n----------------------------");

            // Prompt the user to enter their information
            System.out.print("Enter the total debt amount: $");
            int totalDebt = input.nextInt();
            input.nextLine();

            System.out.print("Are you seeking help with unsecured debts?: Y/N");
            userInput = input.nextLine();

            boolean unsecured = userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y");



            System.out.print("Have you experienced any financial hardship?: Y/N");
            userInput = input.nextLine();
            boolean hardship = userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y");


            boolean qualifies = qualificationTool(totalDebt, unsecured, hardship);

            if (qualifies) {
                    //start creating creditor profile, need to create class/loop
                // List<Creditor> creditors = enterCreditorInformation(sc);


            }

            System.out.println("*****************************************");
            System.out.println("Hello, ");
            System.out.println("Your total debt amount is: " +  totalDebt);
            System.out.println("Is this correct? Y/N " + qualifies);


            DraftCalculator calculator = new DraftCalculator();

            //change variables to match a client sided variable that contains their creditors
            //maybe there is a better way to transfer fee amount so that estimate/draft is accurate
            double estimate = calculator.provideEstimate(totalDebt, FEE_RATE);


    }

    private static boolean qualificationTool(int totalDebt, boolean unsecured, boolean hardship) {


            return totalDebt>=10000 && unsecured && hardship;
    }

    private static <Creditor> List<Creditor> enterCreditorInformation(Scanner sc) {
          CreditorManager creditorManager = new CreditorManager();
          return creditorManager.enterCreditorInformation(sc);


    }
}

