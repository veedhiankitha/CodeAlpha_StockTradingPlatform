import java.util.Scanner;

class Stock {
    String name;
    double price;
    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stock stock = new Stock("TCS", 3500);

        System.out.println("=== Stock Trading Platform ===");
        System.out.println("Available Stock: " + stock.name);
        System.out.println("Price: ₹" + stock.price);

        System.out.print("Enter number of shares to buy: ");
        int shares = sc.nextInt();

        double total = shares * stock.price;

        System.out.println("\nPurchase Successful!");
        System.out.println("Stock: " + stock.name);
        System.out.println("Shares: " + shares);
        System.out.println("Total Amount: ₹" + total);

        sc.close();
    }
}