package ChatGPTFiftyExamples;

import java.util.*;

public class Example3LRUCache {

    public static void main(String [] args){

        LRUCache lruCache = new LRUCache(3);

        lruCache.put("1 key","1 value");
        lruCache.put("2 key","2 value");
        lruCache.put("3 key","3 value");

        lruCache.get("1 key");
        lruCache.get("3 key");

        lruCache.get("1 key");
        lruCache.get("3 key");

        lruCache.get("1 key");
        lruCache.get("3 key");

        lruCache.get("2 key");
        lruCache.get("2 key");
        lruCache.get("2 key");
        lruCache.get("2 key");
        lruCache.get("1 key");

        lruCache.put("4 key","4 value");

        System.out.println(lruCache.getAllCacheValues());
    }
}

class LRUCache{

    private int cacheSize;
    Map<String,Object> cache;

    Map<String,Integer> numberOfCalls;

    public LRUCache(int cacheSize){
        this.cacheSize = cacheSize;
        this.cache = new HashMap<>();
        this.numberOfCalls = new HashMap<>();
    }

    public Object get(String key){
        if(cache.get(key) == null) return Integer.valueOf(-1);
        numberOfCalls.put(key,numberOfCalls.get(key)+1);

        return cache.get(key);
    }

    public Set getAllCacheValues(){
        return Set.of(cache.values());
    }

    public boolean put(String key, Object value){

        try {
            if(cache.size()>=cacheSize){

                int minimalNumberOfGetCalls = 0;
                String nameOfLeastCalledValue = null;

                List<String> keyList = new ArrayList<>(cache.keySet());
                for(int i = 0; i<keyList.size(); i++){
                    String currentKey = keyList.get(i);
                    if(numberOfCalls.get(currentKey)==0){
                        cache.remove(currentKey);
                        numberOfCalls.remove(currentKey);
                        break;
                    } else {

                        if(minimalNumberOfGetCalls == 0){
                            minimalNumberOfGetCalls = numberOfCalls.get(currentKey);
                            nameOfLeastCalledValue = currentKey;
                            continue;
                        }

                        if(numberOfCalls.get(currentKey)<minimalNumberOfGetCalls){
                            minimalNumberOfGetCalls = numberOfCalls.get(currentKey);
                            nameOfLeastCalledValue = currentKey;
                        }
                    }
                }
                cache.remove(nameOfLeastCalledValue);
            }
        } catch (Exception e){
            return false;
        }

        cache.put(key,value);
        numberOfCalls.put(key,0);
        return true;
    }

}


