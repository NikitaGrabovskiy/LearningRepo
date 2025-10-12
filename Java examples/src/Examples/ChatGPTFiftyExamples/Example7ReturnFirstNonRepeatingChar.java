package Examples.ChatGPTFiftyExamples;

public class Example7ReturnFirstNonRepeatingChar {

    public static void main(String [] args){
        System.out.println(getFirstNonRepeatedChar("aabbcc"));
    }

    private static char getFirstNonRepeatedChar(String word){

      char [] chars = word.toCharArray();

      for(int i = 0; i <chars.length; i++){

          if(i+1<chars.length && !word.substring(i+1,chars.length).contains(String.valueOf(chars[i]))
            && !(word.substring(0,i).contains(String.valueOf(chars[i])))){
              return chars[i];
          }
      }

      return '\0';
    }

}
