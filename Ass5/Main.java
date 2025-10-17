package SDP.Ass5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CheckoutFacade checkout = new CheckoutFacade();

        System.out.println("    Brxlq Checkout System    ");

        boolean continueShopping = true;

        while (continueShopping) {
            System.out.print("\nEnter customer name: ");
            String name = sc.nextLine();

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            int methodChoice = 0;
            while (true) {
                System.out.println("\nSelect payment method:");
                System.out.println("1 - Credit Card");
                System.out.println("2 - PayPal");
                System.out.print("Your choice: ");
                try {
                    methodChoice = sc.nextInt();
                    if (methodChoice == 1 || methodChoice == 2) break;
                    else System.out.println(" Please enter 1 or 2 only.");
                } catch (InputMismatchException e) {
                    System.out.println(" Invalid input. Please enter a number (1 or 2).");
                    sc.nextLine();
                }
            }

            double amount = 0;
            while (true) {
                System.out.print("Enter total amount: $");
                try {
                    amount = sc.nextDouble();
                    if (amount > 0) break;
                    else System.out.println(" Must be positive!");
                } catch (InputMismatchException e) {
                    System.out.println(" Invalid input. Enter a number.");
                    sc.nextLine();
                }
            }

            Payment payment = null;

            if (methodChoice == 1) {
                double discount = 0;
                while (true) {
                    System.out.print("Enter discount percent: ");
                    try {
                        discount = sc.nextDouble();
                        if (discount >= 0) break;
                        else System.out.println(" Must be positive!");
                    } catch (InputMismatchException e) {
                        System.out.println(" Invalid input. Enter a number.");
                        sc.nextLine();
                    }
                }

                payment = new CreditCardPayment();
                payment = new DiscountDecorator(payment, discount);
                payment = new FraudDetectionDecorator(payment);

            } else if (methodChoice == 2) {
                double cashback = 0;
                while (true) {
                    System.out.print("Enter cashback percent: ");
                    try {
                        cashback = sc.nextDouble();
                        if (cashback >= 0) break;
                        else System.out.println(" Must be positive!");
                    } catch (InputMismatchException e) {
                        System.out.println(" Invalid input. Enter a number.");
                        sc.nextLine();
                    }
                }

                payment = new PayPalPayment();
                payment = new CashbackDecorator(payment, cashback);
            }

            System.out.println("\n    Checkout Summary    ");
            checkout.processOrder(name, email, payment, amount);

            sc.nextLine();

            while (true) {
                System.out.print("Do you want to make another purchase? (y/n): ");
                String choice = sc.nextLine().trim().toLowerCase();

                if (choice.equals("y")) {
                    break;
                } else if (choice.equals("n")) {
                    continueShopping = false;
                    System.out.println("\nThank you for shopping with us!");
                    break;
                } else {
                    System.out.println(" Please enter 'y' or 'n' only.");
                }
            }
        }

        sc.close();
    }
}
