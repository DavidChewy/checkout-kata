package solution.models;

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

}
