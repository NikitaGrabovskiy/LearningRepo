package JavaPractice.DesignPatterns.Behaviour.strategy;

public class Main {

    public static void main(String[] args) {
        PaymentContext creditCardPaymentContext = new PaymentContext(new CreditCardPayment());

        creditCardPaymentContext.pay(100);

        PaymentContext payPalPayment = new PaymentContext(new PayPalPayment());

        payPalPayment.pay(200);
    }

}

interface PaymentStrategy{
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Pay " + amount + " using credit card");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pay " + amount + " using PayPal");
    }
}

class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount){
        paymentStrategy.pay(amount);
    }

}
