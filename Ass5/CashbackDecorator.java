package SDP.Ass5;

public class CashbackDecorator extends PaymentDecorator {
    private double cashbackPercent;

    public CashbackDecorator(Payment payment, double cashbackPercent) {
        super(payment);
        this.cashbackPercent = cashbackPercent;
    }

    @Override
    public void pay(double amount) {
        super.pay(amount);
        double cashback = amount * cashbackPercent / 100;
        System.out.printf(" You earned %.1f%% cashback: $%.2f%n", cashbackPercent, cashback);
    }
}
