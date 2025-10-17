package SDP.Ass5;

public abstract class PaymentDecorator implements Payment {
    protected Payment decoratedPayment;

    public PaymentDecorator(Payment payment) {
        this.decoratedPayment = payment;
    }

    @Override
    public void pay(double amount) {
        decoratedPayment.pay(amount);
    }
}

