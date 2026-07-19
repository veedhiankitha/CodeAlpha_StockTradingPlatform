import java.util.*;

class Stock {
    String name;
    double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Transaction {
    String type;
    String stockName;
    int shares;
    double amount;

    public Transaction(String type, String stockName, int shares, double amount) {
        this.type = type;
        this.stockName = stockName;
        this.shares = shares;
        this.amount = amount;
    }

    public void display() {
        System.out.println(type + " | " + stockName + " | Shares: " + shares + " | Amount: ₹" + amount);
    }
}

class User {
    String name;
    double balance;
    int sharesOwned;
    ArrayList<Transaction> history;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.sharesOwned = 0;
        this.history = new ArrayList<>();
    }

    public void buyStock(Stock stock, int shares) {
        double cost = shares * stock.price;

        if (cost <= balance) {
            balance -= cost;
            sharesOwned += shares;
            history.add(new Transaction("BUY", stock.name, shares, cost));
            System.out.println("Purchase Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void sellStock(Stock stock, int shares) {
        if (shares <= sharesOwned) {
            double amount = shares * stock.price;
            balance += amount;
            sharesOwned -= shares;
            history.add(new Transaction("SELL", stock.name, shares, amount));
            System.out.println("Sale Successful!");
        } else {
            System.out.println("Not enough shares!");
        }
    }
}
    public class StockTradingPlatform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock stock = new Stock("TCS", 3500);

        System.out.print("Enter User Name: ");
        String userName = sc.nextLine();

        User user = new User(userName, 100000); // Initial Balance

        int choice;

        do {
            System.out.println("\n====== STOCK TRADING PLATFORM ======");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nMarket Data");
                    System.out.println("Stock : " + stock.name);
                    System.out.println("Price : ₹" + stock.price);
                    break;

                case 2:
                    System.out.print("Enter Shares to Buy: ");
                    int buy = sc.nextInt();
                    user.buyStock(stock, buy);
                    break;

                case 3:
                    System.out.print("Enter Shares to Sell: ");
                    int sell = sc.nextInt();
                    user.sellStock(stock, sell);
                    break;

                case 4:
                    System.out.println("\nPortfolio");
                    System.out.println("User : " + user.name);
                    System.out.println("Balance : ₹" + user.balance);
                    System.out.println("Shares Owned : " + user.sharesOwned);
                    System.out.println("Portfolio Value : ₹" + (user.sharesOwned * stock.price));
                    break;
                    case 5:
                    System.out.println("\n===== Transaction History =====");

                    if (user.history.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        for (Transaction t : user.history) {
                            t.display();
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Stock Trading Platform!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
        
