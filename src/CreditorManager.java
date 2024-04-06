import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreditorManager {


    public List<Creditor> enterCreditorInformation(Scanner sc) {
        List<Creditor> creditors = new ArrayList<>();

        while (true) {
            System.out.print("Please enter the creditor name: (type 'exit' to quit)");
            String creditorName = sc.nextLine();

            if ("exit".equalsIgnoreCase(creditorName)) break;

            System.out.println("Please enter debt amount for " + creditorName + ": $");
            double debtAmount = sc.nextDouble();
            sc.nextLine();

            creditors.add(new Creditor(creditorName, debtAmount));



        }



        return creditors;
    }
}
