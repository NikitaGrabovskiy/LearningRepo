
public class Example28ProveStringIsImmutable {

    public static void main(String[] args) throws InterruptedException {


        StringBuilder stringBuilder = new StringBuilder("Test");
        stringBuilder.replace(0,1,"t");

        System.out.println(stringBuilder);

        String text = "Text";
        text.replace("T","t");

        System.out.println(text);
    }


}
