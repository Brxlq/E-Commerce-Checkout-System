package SDP.Ass5;

class CheckoutFacade {

    public void processOrder(String customer, String email, Payment payment, double amount) {
        System.out.println("Customer: " + customer);
        System.out.println("Email: " + email);
        System.out.printf("Order Total: $%.2f%n", amount);
        System.out.println("               ");
        payment.pay(amount);
        EmailSender.sendReceipt(email, customer, amount);

        System.out.println("Order completed successfully.\n");
    }
}
