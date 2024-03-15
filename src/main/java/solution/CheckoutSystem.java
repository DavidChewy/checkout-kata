package solution;


import solution.models.PriceQuote;
import solution.models.SKU;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This is a singleton hence there is only one instance of this class.
 */
public class CheckoutSystem {

    private Map<SKU, PriceQuote> pricingRules;

    private CheckoutSystem(){
        pricingRules = new HashMap<>();
    }

    public void setPricingRules(Map<SKU, PriceQuote> pricingRules){
        this.pricingRules = pricingRules;
    }

    public Map<SKU, PriceQuote> getPricingRules() {
        return pricingRules;
    }

    public CheckoutTransaction createTransaction(){
        //deep copy of pricing rules, if we want to have all checkout transaction share the pricing rule, we just use pricing ruleS in here
        //TODO new KataCheckoutTransaction (new hash map<>(pricingrules));
        return new KataCheckoutTransaction(pricingRules
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    private static final CheckoutSystem INSTANCE = new CheckoutSystem();

    public static CheckoutSystem getInstance(){
        return INSTANCE;
    }


}
