package solution.models;

import solution.SKUNotFoundException;

public enum SKU {
    A,
    B,
    C,
    D;

    public static SKU fromName(String itemName) throws SKUNotFoundException {
        for(SKU item: SKU.values()){
            if(item.name().equals(itemName)){
                return item;
            }
        }
        throw new SKUNotFoundException("could not find item");
    }
}
