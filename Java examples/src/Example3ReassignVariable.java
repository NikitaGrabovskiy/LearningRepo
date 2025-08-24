// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Example3ReassignVariable {
    public static void main(String[] args) {

    int a = 3;
    int b = 5;

    a = a + b;
    b = a - b;
    a = a - b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}