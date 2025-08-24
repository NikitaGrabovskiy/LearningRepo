

public class Example17Pyramid {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("FIRST WAY");

        drawPyramid(50);

        System.out.println();

        drawPyramidWithOneOnTop(10);
    }


    private static void drawPyramid(int numberOfSteps) {

        for (int step = 0; step < numberOfSteps; step++) {
            printSpaces(numberOfSteps - step);
            for (int symbol = 1; symbol <= step; symbol++) {
                System.out.print("*");
                System.out.print("*");
            }
            System.out.println();
        }


    }

    private static void drawPyramidWithOneOnTop(int numberOfSteps) {

        int previousNumberOfSymbols = 1;
        for (int step = 0; step < numberOfSteps; step++) {
            printSpaces(numberOfSteps - step);

            for (int symbol = 0; symbol < previousNumberOfSymbols; symbol++) {
                System.out.print("*");
            }
            previousNumberOfSymbols+=2;
            System.out.println();
        }
    }



    private static void printSpaces(int numberOfSpaces) {
        for (int space = 0; space < numberOfSpaces; space++) {
            System.out.print(" ");
        }
    }
}
