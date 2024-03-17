package solution;

import solution.models.PriceQuote;
import solution.models.SpecialPrice;



public final class CalculatePriceUtils {
    private CalculatePriceUtils(){

    };

    public static double calculateItemPrice(Integer quantity, PriceQuote priceQuote){
        double totalItemPrice = 0;
        int units = quantity; // set new field units and assigned value
        if (priceQuote.getSpecialPrice().isPresent()) { //see if the quote has the special price
            SpecialPrice specialPrice = priceQuote.getSpecialPrice().get(); //get the special price from SpecialPrice class
            int specialApplied = units / specialPrice.getUnitThreshold(); //see the amount of units divides the special price threshold to see how many times you get the special price
            units -= specialApplied * specialPrice.getUnitThreshold(); // result subtracted from units to reflect the units have accounted for or discounted due to the special price
            totalItemPrice += specialApplied * specialPrice.getPrice(); // calculates the total price for the units that qualify for the special price
        };
        totalItemPrice += units * priceQuote.getPrice();
        return totalItemPrice;
    }
}
