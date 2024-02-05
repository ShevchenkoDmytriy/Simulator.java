import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Клас, що представляє акцію
class Stock {
    private String companyName;
    private String symbol;
    private double price;

    public Stock(String companyName, String symbol, double price) {
        this.companyName = companyName;
        this.symbol = symbol;
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class MarketIndex {
    private String name;
    private List<Stock> stocks;

    public MarketIndex(String name) {
        this.name = name;
        this.stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

}
class TradingOperation {
    private Stock stock;
    private int quantity;
    private boolean isBuy;

    public TradingOperation(Stock stock, int quantity, boolean isBuy) {
        this.stock = stock;
        this.quantity = quantity;
        this.isBuy = isBuy;
    }
}
class User {
    private String username;
    private List<Stock> portfolio;

    public User(String username) {
        this.username = username;
        this.portfolio = new ArrayList<>();
    }

    public void addStockToPortfolio(Stock stock) {
        portfolio.add(stock);
    }

    public void removeStockFromPortfolio(Stock stock) {
        portfolio.remove(stock);
    }

    public void displayPortfolio() {
        System.out.println("Portfolio of " + username + ":");
        for (Stock stock : portfolio) {
            System.out.println(stock.getSymbol() + " - " + stock.getCompanyName() + " - $" + stock.getPrice());
        }
    }

    public void buyStock(String symbol, int quantity) {
        // Логіка покупки акцій
    }

    public void sellStock(String symbol, int quantity) {
        // Логіка продажу акцій
    }
}
class Market {
    private List<Stock> stocks;

    public Market() {
        this.stocks = new ArrayList<>();
        initializeMarket();
    }

    private void initializeMarket() {
        stocks.add(new Stock("AAPL", "Apple Inc.", 150.0));
        stocks.add(new Stock("MSFT", "Microsoft Corporation", 300.0));
        stocks.add(new Stock("GOOGL", "Alphabet Inc.", 2500.0));
    }

    public void displayMarket() {
        System.out.println("Stocks in the Market:");
        for (Stock stock : stocks) {
            System.out.println(stock.getSymbol() + " - " + stock.getCompanyName() + " - $" + stock.getPrice());
        }
    }
}
class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }
    public void displayMessage(String message) {
        System.out.println(message);
    }
    public int getMenuChoice(String[] options) {
        displayMessage("Please select an option:");
        for (int i = 0; i < options.length; i++) {
            displayMessage((i + 1) + ". " + options[i]);
        }
        int choice = getIntegerInput("Enter your choice:", 1, options.length);
        return choice;
    }
    public String getStringInput(String prompt) {
        displayMessage(prompt);
        return scanner.nextLine();
    }
    public int getIntegerInput(String prompt, int min, int max) {
        int input;
        while (true) {
            try {
                displayMessage(prompt);
                input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    break;
                } else {
                    displayMessage("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                displayMessage("Please enter a valid number.");
            }
        }
        return input;
    }

    public void closeScanner() {
        scanner.close();
    }
}
    public class Main {
        public static void main(String[] args) {
            Market market = new Market();
            User user1 = new User("User1");
            User user2 = new User("User2");
            user1.addStockToPortfolio(new Stock("AAPL", "Apple Inc.", 150.0));
            user1.addStockToPortfolio(new Stock("MSFT", "Microsoft Corporation", 300.0));
            user2.addStockToPortfolio(new Stock("GOOGLE", "Alphabet Inc.", 2500.0));
            System.out.println("User1's Portfolio:");
            user1.displayPortfolio();
            System.out.println("User2's Portfolio:");
            user2.displayPortfolio();
            // user1.buyStock("AAPL", 10);
            // user2.sellStock("GOOGLE", 5);
            // System.out.println("Updated User1's Portfolio:");
            // user1.displayPortfolio();
            // System.out.println("Updated User2's Portfolio:");
            // user2.displayPortfolio();
            market.displayMarket();
        }
    }

