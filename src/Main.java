//Alex Svoboda

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            final double FEE_RATE = 0.25;
            byte hours, payRate;
            boolean delinquent, hardship;
            String name, address, creditor;
            char fullTime;


            System.out.println("Welcome to the Debt Settlement Qualification Tool!\n----------------------------");

            // Prompt the user to enter their information
            System.out.print("Enter the total debt amount: $");
            int totalDebt = input.nextInt();

            System.out.print("Are you seeking help with unsecured debts?: Y/N");
            String unsecured = input.nextLine();


            System.out.print("Have you experienced any financial hardship?: Y/N");
            String hardship = input.nextLine();


            boolean qualifies = qualificationTool(totalDebt, unsecured, hardship)

            System.out.println("*****************************************");
            System.out.println("Hello, ");
            System.out.println("Your total debt amount is: " +  totalDebt);
            System.out.println("Is this correct? Y/N");



        // Remainder of code is not being used, just holding for ease of coding. 
        // this should be where we start a loop asking the client to enter their creditor information, inserting this into a table
        // we will need to create different files, classes, and perform these loops through those and then call them here to meet project qualifications.
            double grossPay = payRate*hours;
            System.out.println("Gross Pay: $" + grossPay);
            System.out.println("*************************************************");


    }
}

        private static boolean qualificationTool(int totalDebt, boolean unsecured, boolean hardship) {


                return totalDebt>=10000 && unsecured && hardship;
        }