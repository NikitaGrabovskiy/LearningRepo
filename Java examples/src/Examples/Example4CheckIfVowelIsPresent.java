package Examples;

public class Example4CheckIfVowelIsPresent {

    public static void main(String[] args) {



        // First Option using Streams


        String testWord = "TEST TEST";

        boolean isVowelPresent =
                testWord.chars().mapToObj( ch -> Character.valueOf((char) ch))
                .filter( ch -> {
                    String charAsString = String.valueOf(ch);

                    return charAsString.equalsIgnoreCase("a") ||
                            charAsString.equalsIgnoreCase("e") ||
                            charAsString.equalsIgnoreCase("i") ||
                            charAsString.equalsIgnoreCase("o") ||
                            charAsString.equalsIgnoreCase("u") ? true  : false;

                })  //. peek( sh -> System.out.println("CHARACTER: " + (char )sh))
                .findAny().isPresent();



        System.out.println("Is vowel present in word " + testWord + " : " + isVowelPresent);


        // Second option using contains
        System.out.println("______________");
        System.out.println("SECOND OPTION ");
        System.out.println("______________");

        if (testWord.contains("a") || testWord.contains("A") || testWord.contains("i")
        || testWord.contains("I") || testWord.contains("e") || testWord.contains("E")
                || testWord.contains("o") || testWord.contains("O") || testWord.contains("u")
                || testWord.contains("U")){
            System.out.println(" Word " + testWord + " contains vowels");
        } else {
            System.out.println(" Word " + testWord + " does not contains vowels");
        }




    }


}
