package solution;

import solution.models.SKU;

public interface CheckoutTransaction {

    //if this fails, it will throw an exception
    default void scan(String item) {
        scan(SKU.fromName(item));
    }

    void scan(SKU item);
    double getTotalPrice();

}
