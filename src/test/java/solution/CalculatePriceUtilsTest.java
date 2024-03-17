package solution;

import org.junit.jupiter.api.Test;
import solution.models.PriceQuote;
import solution.models.SpecialPrice;

import static org.junit.jupiter.api.Assertions.*;

class CalculatePriceUtilsTest {

    @Test
    void calculateItemPrice() {
        PriceQuote priceQuote = new PriceQuote(100);
        double result = CalculatePriceUtils.calculateItemPrice(10, priceQuote);
        assertEquals(1000, result);
    }

    @Test
    void calculateItemPriceWithSpecialPrice() {
        PriceQuote priceQuote = new PriceQuote(100, new SpecialPrice(100, 2));
        double result = CalculatePriceUtils.calculateItemPrice(2, priceQuote);
        assertEquals(100, result);
    }

    @Test
    void calculateItemPriceWithSpecialPriceUnitThreshold() {
        PriceQuote priceQuote = new PriceQuote(100, new SpecialPrice(100, 2));
        double result = CalculatePriceUtils.calculateItemPrice(10, priceQuote);
        assertEquals(500, result);
    }
}