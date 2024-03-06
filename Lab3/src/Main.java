// Alex Svoboda
// a400@umbc.edu
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask a user to enter first name and last name. (Allow for mixed case)
        System.out.print("Enter your first name. ");
        String firstName = input.nextLine().replaceAll("\\s+", "").toUpperCase();

        System.out.print("Enter your last name and press enter: ");
        String lastName = input.nextLine().replaceAll("\\s+", "").toLowerCase().substring(0,3);

        //Returns the last letter of first name, capitalized
        char firstNameLetter = firstName.charAt(firstName.length() - 1);

        //Create random integer from 10-99
        int randNum = new Random().nextInt(90) + 10;
        //Create password string
        String password = String.valueOf(firstNameLetter)+randNum+lastName;

        System.out.println(("Your password is: " + password));

        //Use concat method
        String newPassword = password.concat("****");

        System.out.println(("Your password using concat: " + newPassword)); // debugging

        //Reverse the result of the string and print
        System.out.printf("Your new password after reverse: %s", new StringBuilder(newPassword).reverse());




        }

    }
