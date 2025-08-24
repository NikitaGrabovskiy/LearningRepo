import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Example8CheckAddNumbers {

    public static void main(String[] args) {

        List<Integer> integers = List.of(2,4,6,8);

        if(checkIfListContainsOddNumbers(integers)){
            System.out.println("List contains odd numbers");
        } else {
            System.out.println("List does not contain odd numbers");
        }
    }


    private static boolean checkIfListContainsOddNumbers(List<Integer> list){
        Optional<Integer> any = list.stream().filter(i -> i % 2 != 0).findAny();
        return any.isPresent() ? true : false;
    }

}
