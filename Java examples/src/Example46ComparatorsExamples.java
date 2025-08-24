import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example46ComparatorsExamples {

    public static void main(String[] args) {

        String [] array = {"Test","fewfe","fefesfes","mpm"};
        List<String> list = new ArrayList<>(List.of(array));

        Comparator<String> comparator = (a,b) -> Integer.valueOf(a.length()).compareTo(Integer.valueOf(b.length()));
        Collections.sort(list,comparator);
        System.out.println(list);

    }
}
