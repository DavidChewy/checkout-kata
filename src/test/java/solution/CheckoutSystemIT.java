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

class CheckoutSystemIT {

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
    void pricingRulesUpdate(){
        CheckoutTransaction transaction1 = CheckoutSystem.getInstance().createTransaction();
        transaction1.scan(A);
        transaction1.scan(A);
        transaction1.scan(A);

        assertEquals(130, transaction1.getTotalPrice());

        Map<SKU, PriceQuote> pricingRules = new HashMap<>();
        pricingRules.put(A, new PriceQuote(50)); //no special price
        CheckoutSystem.getInstance().setPricingRules(pricingRules);

        CheckoutTransaction transaction2 = CheckoutSystem.getInstance().createTransaction();
        transaction2.scan(A);
        transaction2.scan(A);
        transaction2.scan(A);

        assertEquals(150, transaction2.getTotalPrice());
        assertEquals(130, transaction1.getTotalPrice()); //checkout transaction 1 keeps the old pricing rule

    }
}