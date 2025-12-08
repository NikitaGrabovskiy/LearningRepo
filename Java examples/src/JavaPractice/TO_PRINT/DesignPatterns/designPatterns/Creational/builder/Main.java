package JavaPractice.TO_PRINT.DesignPatterns.designPatterns.Creational.builder;

public class Main {

    public static void main(String[] args){

        User user = new User.Builder("Alice","Test@Example.com")
                .age(30)
                .phone("123_345-3455")
                .address("123 street")
                .build();

        System.out.println(user);
    }
}

class User {

    private final String name;
    private final String email;

    private final int age;
    private final String phone;
    private final String address;

    public User(Builder builder) {
        this.name = builder.name;
        this.email =  builder.email;
        this.age =  builder.age;
        this.phone =  builder.phone;
        this.address =  builder.address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private final String name;
        private final String email;
        private int age;
        private String phone;
        private String address;

        public Builder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        Builder age(int age) {
            this.age = age;
            return this;
        }

        Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        Builder address(String address){
            this.address = address;
            return this;
        }

        public User build(){
            return new User(this);
        }

    }
}
