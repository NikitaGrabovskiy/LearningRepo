package Examples;

public class Example29Inheritance {

    public static void main(String[] args) throws InterruptedException {

        Dog dog = new Dog();
        dog.makeSound();
        dog.move();



    }

}

abstract class Animal {
    abstract public void makeSound();

    void move(){
        System.out.println("MOVE");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}