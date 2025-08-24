
public class Example33CreateEnum {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Seasons.AUTUMN);

    }


}

enum Seasons{
    WINTER(-10),
    SUMMER(100),
    SPRING(50),
    AUTUMN(50);

    Seasons (int temperature){
        System.out.println(temperature);
    }
}