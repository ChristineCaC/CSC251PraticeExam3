import java.util.ArrayList;

public class TicketPlan {
    private String familyLastName;
    private String ticketPlanType;
    private int numberOfAdults;
    private int numberOfChildren;
    private int numberOfDays;

    // Constants for the cost per day per adult and child based on the ticket plan type
    private static final double AMUSEMENT_PARK_ADULT_COST_4_DAYS = 104.99;
    private static final double AMUSEMENT_PARK_ADULT_COST_MORE = 94.99;
    private static final double WATER_PARK_ADULT_COST_4_DAYS = 84.99;
    private static final double WATER_PARK_ADULT_COST_MORE = 79.99;
    private static final double BOTH_PARKS_ADULT_COST_4_DAYS = 169.99;
    private static final double BOTH_PARKS_ADULT_COST_MORE = 149.99;

    private static final double AMUSEMENT_PARK_CHILD_COST_2_CHILDREN = 52.49;
    private static final double AMUSEMENT_PARK_CHILD_COST_MORE = 47.49;
    private static final double WATER_PARK_CHILD_COST_2_CHILDREN = 42.49;
    private static final double WATER_PARK_CHILD_COST_MORE = 39.99;
    private static final double BOTH_PARKS_CHILD_COST_2_CHILDREN = 84.99;
    private static final double BOTH_PARKS_CHILD_COST_MORE = 74.99;

    // No-arg constructor
    public TicketPlan() {
        familyLastName = "";
        ticketPlanType = "";
        numberOfAdults = 0;
        numberOfChildren = 0;
        numberOfDays = 0;
    }

    // Constructor that accepts arguments for each field
    public TicketPlan(String n, String t, int a, int c, int d) {
        familyLastName = n;
        ticketPlanType = t.toUpperCase(); // Ensure uppercase to match input
        numberOfAdults = a;
        numberOfChildren = c;
        numberOfDays = d;
    }

    // Setters
    public void setFamilyLastName(String n) {
        familyLastName = n;
    }

    public void setTicketPlanType(String t) {
        ticketPlanType = t.toUpperCase(); // Ensure uppercase to match input
    }

    public void setNumberOfAdults(int a) {
        numberOfAdults = a;
    }

    public void setNumberOfChildren(int c) {
        numberOfChildren = c;
    }

    public void setNumberOfDays(int d) {
        numberOfDays = d;
    }

    // Getters
    public String getFamilyLastName() {
        return familyLastName;
    }

    public String getTicketPlanType() {
        return ticketPlanType;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    // Method to calculate the cost per day for an adult based on ticket plan and number of days
    public double getCostPerDayAdult() {
        if (ticketPlanType.equals("1")) { // Amusement Park Only
            return numberOfDays <= 4 ? AMUSEMENT_PARK_ADULT_COST_4_DAYS : AMUSEMENT_PARK_ADULT_COST_MORE;
        } else if (ticketPlanType.equals("2")) { // Water Park Only
            return numberOfDays <= 4 ? WATER_PARK_ADULT_COST_4_DAYS : WATER_PARK_ADULT_COST_MORE;
        } else if (ticketPlanType.equals("3")) { // Both Parks
            return numberOfDays <= 4 ? BOTH_PARKS_ADULT_COST_4_DAYS : BOTH_PARKS_ADULT_COST_MORE;
        } else {
            return 0.0; // Invalid plan type
        }
    }

    // Method to calculate the cost per day for a child based on ticket plan and number of children
    public double getCostPerDayChild() {
        if (ticketPlanType.equals("1")) { // Amusement Park Only
            return numberOfChildren <= 2 ? AMUSEMENT_PARK_CHILD_COST_2_CHILDREN : AMUSEMENT_PARK_CHILD_COST_MORE;
        } else if (ticketPlanType.equals("2")) { // Water Park Only
            return numberOfChildren <= 2 ? WATER_PARK_CHILD_COST_2_CHILDREN : WATER_PARK_CHILD_COST_MORE;
        } else if (ticketPlanType.equals("3")) { // Both Parks
            return numberOfChildren <= 2 ? BOTH_PARKS_CHILD_COST_2_CHILDREN : BOTH_PARKS_CHILD_COST_MORE;
        } else {
            return 0.0; // Invalid plan type
        }
    }

    // Method to calculate the total price of the ticket plan
    public double getPlanPrice() {
        double totalCostPerDay = (getCostPerDayChild() * numberOfChildren) + (getCostPerDayAdult() * numberOfAdults);
        return totalCostPerDay * numberOfDays;
    }
}
