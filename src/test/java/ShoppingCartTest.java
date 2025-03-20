import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testSelectLanguageEnglish() {
        Scanner scanner = new Scanner("1\n");
        Locale locale = cart.selectLanguage(scanner);
        assertEquals(new Locale("en", "US"), locale);
    }

    @Test
    void testSelectLanguageFinnish() {
        Scanner scanner = new Scanner("2\n");
        Locale locale = cart.selectLanguage(scanner);
        assertEquals(new Locale("fi", "FI"), locale);
    }

    @Test
    void testSelectLanguageSwedish() {
        Scanner scanner = new Scanner("3\n");
        Locale locale = cart.selectLanguage(scanner);
        assertEquals(new Locale("sv", "SE"), locale);
    }

    @Test
    void testSelectLanguageJapanese() {
        Scanner scanner = new Scanner("4\n");
        Locale locale = cart.selectLanguage(scanner);
        assertEquals(new Locale("ja", "JP"), locale);
    }

    @Test
    void testSelectLanguageDefault() {
        Scanner scanner = new Scanner("5\n");
        Locale locale = cart.selectLanguage(scanner);
        assertEquals(new Locale("en", "US"), locale);
    }

    @Test
    void testGetResourceBundleValid() {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = cart.getResourceBundle(locale);
        assertEquals(ResourceBundle.getBundle("messages", locale), rb);
    }

}