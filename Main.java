//Alex Svoboda

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


            final double TAX_RATE = 0.10;
            byte age, hours, payRate;
            String name, fullTime;


            System.out.println("Welcome to the IS147 Project System!\nPlease follow the instructions provided on the screen\n----------------------------");

            Scanner input = new Scanner(System.in);
            // Prompt the user to enter their name
            System.out.print("What is your name?: ");
            name = input.nextLine();

            System.out.print("What is your age?: ");
            age = input.nextByte();

            System.out.print("Press F for full time or P for part time ?: ");
            fullTime = input.next();

            System.out.print("How many hours did you work this week?: ");
            hours = input.nextByte();

            System.out.print("What is your hourly pay rate?: ");
            payRate = input.nextByte();

            System.out.println("*****************************************");
            System.out.println("Hello, " + name+ " You are: " + age + " years old");
            System.out.println("Your Employment Status is: " +  fullTime);
            System.out.println("Vacation request: true");
            System.out.println("Your Tax Rate:" + TAX_RATE);
            System.out.println("Pay Rate per hour: $" +payRate);
            System.out.println("Hours worked: " + hours);

            double grossPay = payRate*hours;
            System.out.println("Gross Pay: $" + grossPay);

            double taxPaid = TAX_RATE*grossPay;
            System.out.println("Tax paid: $" + taxPaid);
            System.out.println("--------------------");

            double netPay = grossPay-taxPaid;
            System.out.println("Net pay: $" +netPay );
            System.out.println("*************************************************");

    }
}
