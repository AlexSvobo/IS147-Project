/**
 * Alex Svoboda
 * Mohammed Mustafa
 * Mahir Ishtiaq
 * Tahir Ahmed
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            final double FEE_RATE = 0.25;
            boolean delinquent;
            String name, address, userInput;


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

            List<Creditor> creditors = new ArrayList<>();

            if (qualifies) {

                 creditors = enterCreditorInformation(input);

            }


            //Resets original debt amount, uses loop/array to obtain true debt total.
            totalDebt = 0;
            for (Creditor creditor : creditors) {
                totalDebt += creditor.getDebtAmount();
            }



            System.out.println("*****************************************");
            System.out.println("Hello, ");
            System.out.println("Your total debt amount is: " +  totalDebt);
            System.out.println("Is this correct? Y/N " + qualifies);


            DraftCalculator calculator = new DraftCalculator();

            //change variables to match a client sided variable that contains their creditors
            //maybe there is a better way to transfer fee amount so that estimate/draft is accurate
            double estimate = calculator.provideEstimate(totalDebt, FEE_RATE);
            System.out.println("Your estimate is: " + estimate + ", including our fees.");

            double monthlyDraft = calculator.provideMonthlyDraft(estimate);
            System.out.println("Your monthly draft amount is: $" + monthlyDraft);

            double programLength = calculator.provideProgramLength(monthlyDraft, estimate);
            System.out.println("Your program length is: " + programLength + "months.");


            System.out.println("Your creditors:");
            for (Creditor creditor : creditors) {
                System.out.println(creditor.getName().substring(0, 1).toUpperCase() + creditor.getName().substring(1) + " $" + ((int) creditor.getDebtAmount()));
            }

    }

    /**
     * Checks if the user qualifies for debt settlement based on total debt, unsecured debts, and financial hardship.
     *
     * @param totalDebt total debt amount
     * @param unsecured whether the debts are unsecured
     * @param hardship  whether the user has experienced financial hardship
     * @return true if the user qualifies, false otherwise
     */
    private static boolean qualificationTool(int totalDebt, boolean unsecured, boolean hardship) {


            return totalDebt>=10000 && unsecured && hardship;
    }

    private static List<Creditor> enterCreditorInformation(Scanner sc) {
        return new CreditorManager().enterCreditorInformation(sc);
    }

}

