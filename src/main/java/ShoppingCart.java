import java.util.Scanner;
import java.util.ResourceBundle;
import java.text.MessageFormat;
import java.util.Locale;

public class ShoppingCart {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        Locale locale = cart.selectLanguage(scanner);
        ResourceBundle rb = cart.getResourceBundle(locale);

        cart.processItems(scanner, rb);
    }

    protected Locale selectLanguage(Scanner scanner) {
        System.out.println("Select a language");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return new Locale("en", "US");
            case 2:
                return new Locale("fi", "FI");
            case 3:
                return new Locale("sv", "SE");
            case 4:
                return new Locale("ja", "JP");
            default:
                return new Locale("en", "US");
        }
    }

    protected ResourceBundle getResourceBundle(Locale locale) {
        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Invalid language selection");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }
        return rb;
    }

    protected void processItems(Scanner scanner, ResourceBundle rb) {
        System.out.println(rb.getString("items"));

        int amountOfItems = scanner.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < amountOfItems; i++) {
            System.out.println(rb.getString("price"));
            double price = scanner.nextDouble();
            System.out.println(rb.getString("quantity"));
            int quantity = scanner.nextInt();
            double total = price * quantity;
            String itemMessage = MessageFormat.format(rb.getString("totalCost"), total);
            System.out.println(itemMessage);
            totalCost += total;
        }

        String totalMessage = MessageFormat.format(rb.getString("shoppingCartTotal"), totalCost);
        System.out.println(totalMessage);
    }
}