import java.util.*;

public class ShoppingCart {
    private static double totalCost = 0;

    // Method to add an item to the shopping cart
    public void addItem(double price, int quantity) {
        totalCost += price * quantity;
    }

    // Getter for total cost
    public double getTotalCost() {
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale locale = getLocale(scanner);

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println(messages.getString("prompt.enter_items_number"));
        int numItems = scanner.nextInt();

        for (int i = 1; i <= numItems; i++) {
            System.out.println(messages.getString("prompt.enter_item_price"));
            double price = scanner.nextDouble();

            System.out.println(messages.getString("prompt.enter_item_quantity"));
            int quantity = scanner.nextInt();

            totalCost += price * quantity;
        }

        System.out.println(messages.getString("prompt.total_cost") + totalCost);
        scanner.close();
    }

    private static Locale getLocale(Scanner scanner) {
        System.out.println("Select language: (1) English, (2) Finnish, (3) Swedish, (4) Japanese");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: return Locale.US;
            case 2: return new Locale("fi", "FI");
            case 3: return new Locale("sv", "SE");
            case 4: return new Locale("ja", "JP");
            default: return Locale.US;
        }
    }
}
