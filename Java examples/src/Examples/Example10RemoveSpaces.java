package Examples;

public class Example10RemoveSpaces {

    public static void main(String[] args) {

        String word = "Hello world";
        System.out.println("\""+ word + "\" without spaces is \""+removeSpaces(word)+"\"");

    }

    private static String removeSpaces(String word){
       return word.replace(" ","");
    }
}
