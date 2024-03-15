package solution.models;

import java.util.Optional;

public class PriceQuote {
    private final double price;
    private final SpecialPrice specialPrice;

    public PriceQuote(double price){
       this(price,null);
    };

    public PriceQuote(double price, SpecialPrice specialPrice){
        this.price = price;
        this.specialPrice = specialPrice;
    };

    //Optional to check if there is a value is present (specialPrice)
    public Optional<SpecialPrice> getSpecialPrice(){
        return Optional.ofNullable(specialPrice);
    }

    public double getPrice(){
        return price;
    }


}
