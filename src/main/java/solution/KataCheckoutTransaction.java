package solution;

import solution.models.PriceQuote;
import solution.models.SKU;
import solution.models.SpecialPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KataCheckoutTransaction implements CheckoutTransaction {

    private final Map<SKU, PriceQuote> pricingRules;
    private final List<SKU> items = new ArrayList<>();

    public KataCheckoutTransaction(Map<SKU, PriceQuote> pricingRules){
        this.pricingRules = pricingRules;
    }

    public void scan(SKU item) {
        items.add(item);
    }

    /**
     * Need to refactor to make it look better to the eye lmao
     */
    public double getTotalPrice() {
        return items.stream() // go through item like a for loop
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()))// group by SKU (like 4A... etc) + counting
                .entrySet() //get the set from items
                .stream() //go through the new elements that have just been set
                .map(entry -> { // lambda to point to get the key from items
                    PriceQuote priceQuote = pricingRules.get(entry.getKey()); //get the key from the map
                    double totalItemPrice = 0;
                    int units = entry.getValue().intValue(); // set new field units and assigned value
                    if (priceQuote.getSpecialPrice().isPresent()) { //see if the quote has the special price
                        SpecialPrice specialPrice = priceQuote.getSpecialPrice().get(); //get the special price from SpecialPrice class
                        int specialApplied = units / specialPrice.getUnitThreshold(); //see the amount of units divdide the specialprice threshold to see how many times you get the special price
                        units -= specialApplied * specialPrice.getUnitThreshold(); // result subtracted from units to reflect the units have accounted for or discounted due to the special price
                        totalItemPrice += specialApplied * specialPrice.getPrice(); // calculates the total price for the units that qualify for the special price
                    };
                    totalItemPrice += units * priceQuote.getPrice();
                    return totalItemPrice;
                })
                .reduce(Double::sum)
                .get();


    }
}
