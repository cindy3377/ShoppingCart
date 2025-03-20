import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void testCalculateTotalCost() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(10.0, 2); // Price = 10, Quantity = 2 -> Total = 20
        cart.addItem(5.0, 3);  // Price = 5, Quantity = 3 -> Total = 15
        assertEquals(35.0, cart.getTotalCost());
    }
}
