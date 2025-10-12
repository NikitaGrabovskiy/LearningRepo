package Examples;

public class Example29CreateARecord {

    public static void main(String[] args) throws InterruptedException {


        Cat cat = new Cat("John",2);
        System.out.println(cat.name());

    }


}

record Cat(String name, int age){}
