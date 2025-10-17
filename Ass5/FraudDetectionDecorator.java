package SDP.Ass5;

public class FraudDetectionDecorator extends PaymentDecorator {

    public FraudDetectionDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Running fraud detection...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (amount > 1000) {
            System.out.println(" Suspicious activity detected! Transaction flagged for review.");
        } else {
            System.out.println(" No suspicious activity found.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
        }

        super.pay(amount);
        }
    }
}
