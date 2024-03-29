package solution.models;

public class SpecialPrice {

    private final double price;

    private final int unitThreshold;

    public SpecialPrice(double price, int unitThreshold){
      this.price = price;
      this.unitThreshold = unitThreshold;
    };

    public double getPrice(){
        return price;
    }

    public int getUnitThreshold(){
        return unitThreshold;
    }
}
