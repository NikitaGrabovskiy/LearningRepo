package Examples;

import java.util.LinkedHashMap;
import java.util.Map;

public class Example27CountOfDistinctCharsInString {

    public static void main(String[] args) throws InterruptedException {

        Map<Character, Integer> textExample = countOfDistinctCharacters("text example");
        textExample.forEach((character, integer) ->
                System.out.println("Character \"" + character + "\" occurs " + integer+" times" ));
    }

    private static Map<Character,Integer> countOfDistinctCharacters(String text){

        Map<Character,Integer> distinctValues = new LinkedHashMap<>();
        for(int index = 0; index<text.length();index++){
            char character = text.charAt(index);
            if(distinctValues.get(character) == null){
              distinctValues.put(character,1);
            } else {
                distinctValues.put(character,distinctValues.get(character)+1);
            }
        }

    return distinctValues;
    }

}
