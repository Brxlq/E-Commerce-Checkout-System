package SDP.Ass5;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.printf("Paid $%.2f using Credit Card.%n", amount);
    }
}
