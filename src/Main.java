/**
 * Alex Svoboda
 * Mohammed Mustafa
 * Mahir Ishtiaq
 * Tahir Ahmed
 */
import java.util.List;
import java.util.Scanner;
import java.util.Date;

/**
 * A class containing the main method to run the debt settlement qualification tool.
 */
public class Main {

    /**
     * The main method to run the debt settlement qualification tool.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Date currentDate = new Date();

        final double FEE_RATE = 0.25;
        int totalDebt = 0;
        boolean unsecured, hardship, fixedIncome;
        String userInput;

        System.out.printf("\nCurrent Date: %tc%n", currentDate);
        System.out.println("Welcome to the Debt Settlement Qualification Tool!\n----------------------------");

        while (totalDebt <= 0) {
            System.out.println("Enter the total debt amount: $");
            if (input.hasNextInt()) {
                totalDebt = input.nextInt();
                input.nextLine();
                if (totalDebt <= 0) {
                    System.out.println("Please enter a positive integer for the debt amount.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.nextLine();
            }
        }

        while (true) {
            System.out.print("Are you seeking help with unsecured debts?: Y/N");
            userInput = input.nextLine();
            switch (userInput.toUpperCase()) {
                case "Y":
                    unsecured = true;
                    break;
                case "N":
                    unsecured = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter Y or N.");
                    continue;
            }
            break;
        }

        while (true) {
            System.out.print("Have you experienced any financial hardship?: Y/N");
            userInput = input.nextLine();
            switch (userInput.toUpperCase()) {
                case "Y":
                    hardship = true;
                    break;
                case "N":
                    hardship = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter Y or N.");
                    continue;
            }
            break;
        }

        while (true) {
            System.out.print("Are you on a fixed income?: Y/N");
            userInput = input.nextLine();
            switch (userInput.toUpperCase()) {
                case "Y":
                    fixedIncome = true;
                    break;
                case "N":
                    fixedIncome = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter Y or N.");
                    continue;
            }
            break;
        }

        boolean qualifies;
        if (fixedIncome) {
            qualifies = qualificationTool(unsecured, fixedIncome);
        } else {
            qualifies = qualificationTool(totalDebt, unsecured, hardship);
        }
        if (!qualifies) {
            System.out.println("Sorry, you do not qualify for debt settlement assistance based on the provided information.");
            return;
        }

        List<Creditor> creditors = CreditorManager.enterCreditorInformation(input);

        //Resets original debt amount, uses loop/array to obtain true debt total.
        totalDebt = 0;
        for (Creditor creditor : creditors) {
            totalDebt += (int) creditor.getDebtAmount();
        }


        if (totalDebt<10000 && !fixedIncome){
            System.out.println("Sorry, you do not qualify for the program because your total debt amount is below $10,000.");
            return;
        }




        System.out.println("*****************************************");
        System.out.println("Hello, ");
        System.out.println("Your total debt amount is: $" + totalDebt);


        DraftCalculator calculator = new DraftCalculator();

        double estimate = calculator.provideEstimate(totalDebt, FEE_RATE);
        System.out.println("Your estimate is: $" + estimate + ", including our fees.");

        double monthlyDraft = calculator.provideMonthlyDraft(estimate);
        System.out.println("Your monthly draft amount is: $" + monthlyDraft);

        double programLength = calculator.provideProgramLength(monthlyDraft, estimate);
        System.out.println("Your program length is: " + programLength + " months.");


        System.out.println("Your creditors:");
        for (Creditor creditor : creditors) {
            System.out.println(creditor.getName().substring(0, 1).toUpperCase() + creditor.getName().substring(1) + " $" + ((int) creditor.getDebtAmount()));
        }
    }

    /**
     * Checks if the user qualifies for debt settlement based on total debt, unsecured debts, and financial hardship.
     *
     * @param totalDebt The total debt amount.
     * @param unsecured Whether the debts are unsecured.
     * @param hardship  Whether the user has experienced financial hardship.
     * @return true if the user qualifies, false otherwise.
     */
    private static boolean qualificationTool(int totalDebt, boolean unsecured, boolean hardship){

        return totalDebt >= 10000 && unsecured && hardship;
    }

    /**
     * Checks if the user qualifies for debt settlement based on unsecured debts, and fixed income.
     *
     * @param unsecured Whether the debts are unsecured.
     * @param fixedIncome  Whether the user receives fixed income.
     * @return true if the user qualifies, false otherwise.
     */
    private static boolean qualificationTool(boolean unsecured, boolean fixedIncome){

        return unsecured && fixedIncome;
    }
}


