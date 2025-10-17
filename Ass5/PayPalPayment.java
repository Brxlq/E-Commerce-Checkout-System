package SDP.Ass5;

public class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.printf(" Paid $%.2f using PayPal.%n", amount);
    }
}
