package solution.models;

public enum SKU {
    A,
    B,
    C,
    D;

    public static SKU fromName(String itemName){
        for(SKU item: SKU.values()){
            if(item.name().equals(itemName)){
                return item;
            }
        }
        throw new RuntimeException("could not item");
    }
}
