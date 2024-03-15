package solution;

public interface CheckoutTransaction {

    void scan(String item);
    double getTotalPrice();

}
