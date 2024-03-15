package solution;

import solution.models.PriceQuote;
import solution.models.SKU;

import java.util.Map;

public class KataCheckoutTransaction implements CheckoutTransaction {

    private final Map<SKU, PriceQuote> pricingRules;

    public KataCheckoutTransaction(Map<SKU, PriceQuote> pricingRules){
        this.pricingRules = pricingRules;
    }

    public void scan(String item) {

    }

    public double getTotalPrice() {
        return 0;
    }
}
