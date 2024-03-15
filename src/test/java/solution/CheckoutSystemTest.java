package solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import solution.models.PriceQuote;
import solution.models.SKU;
import solution.models.SpecialPrice;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static solution.models.SKU.*;
import static solution.models.SKU.D;

class CheckoutSystemTest {

    @BeforeEach
    void setUp() {
        Map<SKU, PriceQuote> pricingRules = new HashMap<>();
        pricingRules.put(A, new PriceQuote(50, new SpecialPrice(130, 3)));
        pricingRules.put(B, new PriceQuote(30, new SpecialPrice(45, 2)));
        pricingRules.put(C, new PriceQuote(20));
        pricingRules.put(D, new PriceQuote(15));
        CheckoutSystem.getInstance().setPricingRules(pricingRules);
    }

    @Test
    void setPricingRules() {
        Map<SKU, PriceQuote> pricingRules = new HashMap<>();
        pricingRules.put(A, new PriceQuote(50, new SpecialPrice(130, 3)));
        CheckoutSystem.getInstance().setPricingRules(pricingRules);
        assertEquals(pricingRules, CheckoutSystem.getInstance().getPricingRules());
    }

    @Test
    void createTransaction() {
        assertNotNull(CheckoutSystem.getInstance().createTransaction());
    }

    @Test
    void getInstance() {
        CheckoutSystem system1 = CheckoutSystem.getInstance();
        CheckoutSystem system2 = CheckoutSystem.getInstance();
        //Should be the same since CheckOutSystem is a singleton :)
        assertEquals(system1,system2);
        assertSame(system1, system2);
    }
}