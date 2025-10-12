package Examples;

import java.util.*;

public class Example26SortHashMapByValue {

    public static void main(String[] args) throws InterruptedException {

        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("1","A");
        hashMap.put("2","X");
        hashMap.put("4","B");
        hashMap.put("3","b");
        hashMap.put("6","a");

        Set<Map.Entry<String, String>> entries = hashMap.entrySet();

        List<Map.Entry<String, String>> listOfEntries = new ArrayList<>(entries);

        listOfEntries.sort((entry1,entry2) -> entry1.getValue().compareTo(entry2.getValue()));

        Map<String,String> map = new LinkedHashMap();

        for(Map.Entry<String, String> entry : listOfEntries){
            map.put(entry.getKey(),entry.getValue());
        }

        map.values().forEach(System.out::println);

    }

}
