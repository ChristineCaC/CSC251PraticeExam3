import java.util.ArrayList;
import java.util.Scanner;

public class ExamPratice3_Christine_Chapman {
    public static void main(String[] args) {
        ArrayList<TicketPlan> plans = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String repeat;
        TicketPlan mostExpensivePlan = null;

        do {
            // Get user input
            System.out.print("Enter the last name of the family purchasing the plan: ");
            String familyLastName = sc.nextLine();

            System.out.println("1. Amusement Park Only\n2. Water Park Only\n3. Both Parks");
            System.out.print("\nSelect a Ticket Plan from the menu above (1, 2, or 3): ");
            String ticketPlanType = sc.nextLine();

            // Validate ticket plan selection
            while (!ticketPlanType.equals("1") && !ticketPlanType.equals("2") && !ticketPlanType.equals("3")) {
                System.out.println("\nERROR: Invalid menu option. Please try again.");
                System.out.print("Select a Ticket Plan from the menu above (1, 2, or 3): ");
                ticketPlanType = sc.nextLine();
            }

            // Get number of adults
            System.out.print("Enter the number of adults on the ticket plan: ");
            int numberOfAdults = sc.nextInt();
            while (numberOfAdults < 1) {
                System.out.println("\nERROR: Invalid number of adults. Must be at least 1.");
                System.out.print("Enter the number of adults on the ticket plan: ");
                numberOfAdults = sc.nextInt();
            }

            // Get number of children
            System.out.print("Enter the number of children on the ticket plan: ");
            int numberOfChildren = sc.nextInt();
            while (numberOfChildren < 0) {
                System.out.println("\nERROR: Invalid number of children. Must be 0 or greater.");
                System.out.print("Enter the number of children on the ticket plan: ");
                numberOfChildren = sc.nextInt();
            }

            // Get number of days
            System.out.print("Enter the number of days the ticket plan covers: ");
            int numberOfDays = sc.nextInt();
            while (numberOfDays < 1) {
                System.out.println("\nERROR: Invalid number of days. Must be at least 1.");
                System.out.print("Enter the number of days the ticket plan covers: ");
                numberOfDays = sc.nextInt();
            }

            sc.nextLine();  // Consume the remaining newline character after nextInt()

            // Create and store the TicketPlan object
            TicketPlan plan = new TicketPlan(familyLastName, ticketPlanType, numberOfAdults, numberOfChildren, numberOfDays);
            plans.add(plan);

            // Check for the most expensive plan
            if (mostExpensivePlan == null || plan.getPlanPrice() > mostExpensivePlan.getPlanPrice()) {
                mostExpensivePlan = plan;
            }

            // Ask if they want to enter more data
            System.out.print("\nDo you wish to enter information for another ticket plan (Y/N)? ");
            repeat = sc.nextLine();
            if (repeat.equalsIgnoreCase("Y")) {
                System.out.println();  // This will add the space between the lines
            }

        } while (repeat.equalsIgnoreCase("Y"));

        // Display all ticket plans
        System.out.println("\nTicket Plan Report:\n");
        for (TicketPlan p : plans) {
            System.out.printf("Last Name: %s\n", p.getFamilyLastName());
            System.out.printf("Ticket Plan Type: %s\n", 
                p.getTicketPlanType().equals("1") ? "Amusement Park Only" :
                p.getTicketPlanType().equals("2") ? "Water Park Only" : "Both Parks");
            System.out.printf("Number of Adults: %d\n", p.getNumberOfAdults());
            System.out.printf("Number of Children: %d\n", p.getNumberOfChildren());
            System.out.printf("Number of Days: %d\n", p.getNumberOfDays());
            System.out.printf("Price of Ticket Plan: $%.2f\n\n", p.getPlanPrice());
        }

        // Display the family with the most expensive plan
        if (mostExpensivePlan != null) {
            System.out.printf("Family that purchased the most expensive ticket plan: %s\n", mostExpensivePlan.getFamilyLastName());
        }

        sc.close(); // Close the scanner
    }
}