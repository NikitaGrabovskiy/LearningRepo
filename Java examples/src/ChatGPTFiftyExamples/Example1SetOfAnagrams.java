package ChatGPTFiftyExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Example1SetOfAnagrams {

    public static void main(String [] args){
       String[] array = {"bat", "tab", "tap", "pat", "cat"};
       List<String> list = Arrays.asList(array);
       List<List<String>> lists = groupByAnagrams(list.stream().collect(Collectors.toSet()));
       lists.stream().forEach(System.out::println);
    }


    private static List<List<String>> groupByAnagrams(Set<String> words){

        List<String> wordsList = new ArrayList(words);
        List<List<String>> result = new ArrayList<>();

        for (int i =0; i < wordsList.size(); i++){
            List innerList = new ArrayList();
            String word = wordsList.get(i);

            for(int a = 0; a < wordsList.size(); a++){
                String secondWord = wordsList.get(a);
               if(word.equals(secondWord)){
                   continue;
               }

               if(checkIfWordsAreAnagrams(word,wordsList.get(a))){
                   innerList.add(secondWord);
                   wordsList.remove(secondWord);
               }
            }

            innerList.add(word);
            result.add(innerList);

        }

        return result;
    }

    private static boolean checkIfWordsAreAnagrams(String first,String second){
        first = first.toLowerCase();
        second = second.toLowerCase();
        char [] firstChar = first.toCharArray();
        char [] secondChar = second.toCharArray();
        Arrays.sort(firstChar);
        Arrays.sort(secondChar);
        return String.valueOf(firstChar).equals(String.valueOf(secondChar));
    }
}
