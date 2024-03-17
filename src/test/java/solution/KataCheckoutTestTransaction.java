package solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import solution.models.PriceQuote;
import solution.models.SKU;
import solution.models.SpecialPrice;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static solution.models.SKU.*;

class KataCheckoutTestTransaction {
    private KataCheckoutTransaction kataCheckout;

    @BeforeEach
    void setup(){
        Map<SKU, PriceQuote> pricingRules = new HashMap<>();
        pricingRules.put(A, new PriceQuote(50, new SpecialPrice(130, 3)));
        pricingRules.put(B, new PriceQuote(30, new SpecialPrice(45, 2)));
        pricingRules.put(C, new PriceQuote(20));
        pricingRules.put(D, new PriceQuote(15));
        kataCheckout = new KataCheckoutTransaction(pricingRules);
    }

    @Test
    void getTotalPrice(){
        kataCheckout.scan(SKU.B);
        kataCheckout.scan(SKU.A);
        kataCheckout.scan(SKU.B);

        double result = kataCheckout.getTotalPrice();
        assertEquals(95, result);
    }

    @Test
    void getTotalPrice_4A(){
        kataCheckout.scan(SKU.A);
        kataCheckout.scan(SKU.A);
        kataCheckout.scan(SKU.A);
        kataCheckout.scan(SKU.A);
        double result = kataCheckout.getTotalPrice();
        assertEquals(180, result);
    }

    @Test
    void getTotalPrice_noSpecialPrice(){
        kataCheckout.scan(SKU.A);
        kataCheckout.scan(SKU.A);
        kataCheckout.scan(SKU.B);
        kataCheckout.scan(SKU.C);
        kataCheckout.scan(SKU.C);
        kataCheckout.scan(SKU.C);
        kataCheckout.scan(SKU.C);
        double result = kataCheckout.getTotalPrice();
        assertEquals(210, result);
    }

}