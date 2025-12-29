package JavaPractice.TO_PRINT.DesignPatterns.designPatterns.Creational.Structural.decorator;

public class Main {


    public static void main(String [] args){
        Notifier notifier = new SMSNotifier(new SlackNotifier(new EmailNotifier()));
        notifier.send("TEST MESSAGE");
    }

}

interface Notifier{
    void send(String message);
}

class EmailNotifier implements Notifier{

    @Override
    public void send(String message) {
        System.out.println("Sending email " + message);
    }
}

class NotifierDecorator implements Notifier {
    protected Notifier wrappee;

    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}

class SMSNotifier extends NotifierDecorator{

    public SMSNotifier (Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message){
        super.send(message);
        System.out.println("Sending SMS " + message);
    }

}

class SlackNotifier extends NotifierDecorator {

    public SlackNotifier (Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        super.send(message);
        System.out.println("Sending Slack notification " + message);
    }
}