package solution;

import solution.models.PriceQuote;
import solution.models.SKU;
import solution.models.SpecialPrice;
import java.util.HashMap;
import java.util.Map;

public class KataCheckoutTransaction implements CheckoutTransaction {

    private final Map<SKU, PriceQuote> pricingRules;
    private final Map<SKU, Integer> items = new HashMap<>();

    public KataCheckoutTransaction(Map<SKU, PriceQuote> pricingRules){
        this.pricingRules = pricingRules;
    }

    public void scan(SKU item) {
        items.compute(item, (k, v) -> {
            if(v == null) { //scan item - if we don't have that item already return 1
                return 1;
            } else {
                return v + 1;
            }
        }); // going to put a key in, return a value, if value is null then there is no value in this key.
    }

    public double getTotalPrice() {
        return items
                .entrySet() //get the set from items
                .stream() //go through the new elements that have just been set
                .map(entry -> { // lambda to point to get the key from items
                    PriceQuote priceQuote = pricingRules.get(entry.getKey()); //get the key from the map
                    return CalculatePriceUtils.calculateItemPrice(entry.getValue(), priceQuote);
                })
                .reduce(Double::sum)
                .get();
    }
}
