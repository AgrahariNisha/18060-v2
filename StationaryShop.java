import java.util.Scanner;
import java.util.Vector;

class StationeryItem 
{
    String name;
    double price;
    int quantity;

    StationeryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class StationaryShop 
{
    public static void main(String[] args) {
        // Initialize a Vector for managing inventory
        Vector<StationeryItem> inventory = new Vector<StationeryItem>();
        inventory.add(new StationeryItem("Pens", 5.0, 100));
        inventory.add(new StationeryItem("Pencils", 5.0, 200));
        inventory.add(new StationeryItem("Notebooks", 50.0, 50));
        inventory.add(new StationeryItem("Staplers", 100.0, 20));
        inventory.add(new StationeryItem("Glue", 15.0, 30));
        
        double totalSales = 0.0;

        // Create an instance of the Scanner class to receive input from the user
        Scanner scanner = new Scanner(System.in);

        // Show menu
        System.out.println("Welcome to the Stationary Shop!");
        System.out.println("-------------------------------");
        for (int i = 0; i < inventory.size(); i++) {
            StationeryItem item = inventory.get(i);
            System.out.println((i + 1) + ". " + item.name + " - $ " + item.price);
        }
        System.out.println("-------------------------------");

        // Loop until user decides to quit
        while (true) {
            System.out.println("Enter a number of the product you want to buy(0 to exit): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= inventory.size()) {
                System.out.println("How many would you like to buy?");
                int quantity = scanner.nextInt();

                StationeryItem selectedItem = inventory.get(choice - 1);

                if (quantity > 0 && quantity <= selectedItem.quantity) {
                    double subtotal = selectedItem.price * quantity;
                    totalSales += subtotal;
                    selectedItem.quantity -= quantity;
                    System.out.println("You bought " + quantity + " " + selectedItem.name + "(s) for $" + subtotal);
                } else {
                    System.out.println("Sorry, we do not have that much stock.");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for shopping at the Stationary Shop!");
        System.out.println("Total sales: $" + totalSales);
    }
} 

