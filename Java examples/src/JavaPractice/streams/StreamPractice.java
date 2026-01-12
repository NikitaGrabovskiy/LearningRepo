package JavaPractice.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {


    public static void main(String[] args) {
        partitionPeople();
    }


    private static void countEven(){
        IntStream intStream = IntStream.range(0,20);
        long count = intStream.filter(i -> i % 2 == 0).peek(System.out::println).count();
        System.out.println(count);
    }

    private static void namesToUpperCase(){
        List<String> names = List.of("Mike","John","Marry","Pradeep");

        List<String> upperCaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseNames);

    }

    private static void distinctSort(){
        List<String> names = List.of("Mike","John","Marry","Pradeep","John","Marry","Jack");
        List<String> sorted = names.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(sorted);

    }

    private static void sumOfEachNumberSquired(){
        List<Integer> list = IntStream.range(1,10).boxed().toList();

        int sum = list.stream().map(i -> i * i).mapToInt(Integer::intValue).sum();

        System.out.println(sum);
    }

    private static void convertToMap(){
        List<String> names = List.of("Mike","John","Marry","Pradeep");
        Map<String, Integer> collect = names.stream().collect(Collectors.toMap(a -> a, b -> b.length()));
        System.out.println(collect);
    }

    private static void groupByLength(){
        List<String> names = List.of("Mike","John","Marry","Pradeep","Jack","Mark");
        Map<Integer, List<String>> collect = names.stream().collect(Collectors.groupingBy(a -> a.length()));
        System.out.println(collect);
    }

    private static void findLongestString(){
        List<String> names = List.of("Mike","John","Marry","Pradeep","Jack","Mark");


       String longestString = names.stream().max((a,b) -> {
            if(a.length() >b.length()) {
                return 1;
            } else if (a.length() <b.length()){
                return -1;
            } else {
                return 0;
            }
        }).get();

        System.out.println(longestString);

    }

    private static void joinStrings(){
        List<String> names = List.of("Mike","John","Marry","Pradeep","Jack","Mark");
        String collect = names.stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }

    private static void filterObjects(){

        List<Person> people = List.of(new Person(10,"John"), new Person(31,"Mike"),
                new Person(21,"Marry"));

        List<String> collect = people.stream()
                .filter(person -> person.age > 18)
                .map(person -> person.getName())
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void partitionPeople(){
        List<Person> people = List.of(new Person(10,"John"), new Person(31,"Mike"),
                new Person(21,"Marry"));


        Map<Boolean, List<Person>> collect = people.stream().collect(Collectors.groupingBy(person -> person.getAge() >= 18));
        System.out.println(collect);

    }

}

class Person{
    int age;
    String Name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Person(int age, String name) {
        this.age = age;
        Name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", Name='" + Name + '\'' +
                '}';
    }
}