package solution;

import solution.models.PriceQuote;
import solution.models.SKU;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KataCheckoutTransaction implements CheckoutTransaction {

    private final Map<SKU, PriceQuote> pricingRules;
    private final List<SKU> items = new ArrayList<>();

    public KataCheckoutTransaction(Map<SKU, PriceQuote> pricingRules){
        this.pricingRules = pricingRules;
    }

    public void scan(SKU item) {
        items.add(item);
    }

    public double getTotalPrice() {
        return 0;
    }
}
