
public class Example31SwitchExpression {

    public static void main(String[] args) throws InterruptedException {

        int choice = 4;

        int x = switch (choice) {
            case 1, 2, 3:
                yield choice;
            default:
                yield -1;
        };

        System.out.println("x = " + x); // x = 2

    }

}
