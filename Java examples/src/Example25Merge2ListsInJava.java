import java.util.ArrayList;
import java.util.List;

public class Example25Merge2ListsInJava {

    public static void main(String[] args) throws InterruptedException {

    List<String> list1 = List.of("String","Test"); // Remember creates an immutable collection !!!
    List<String> list2 = List.of("String1","Test2");

    List<String> list3 = new ArrayList<>(list1);
    list3.addAll(list2);

    list3.forEach(System.out::println);
    }

}
