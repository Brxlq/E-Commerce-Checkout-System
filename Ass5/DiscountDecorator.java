package SDP.Ass5;

public class DiscountDecorator extends PaymentDecorator {
    private double discountPercent;

    public DiscountDecorator(Payment payment, double discountPercent) {
        super(payment);
        this.discountPercent = discountPercent;
    }

    @Override
    public void pay(double amount) {
        double discounted = amount - (amount * discountPercent / 100);
        System.out.printf(" Applied %.1f%% discount. New total: $%.2f%n", discountPercent, discounted);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.pay(discounted);
    }
}
