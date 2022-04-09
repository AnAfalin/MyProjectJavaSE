package part1.task3;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if(name == null) {
            throw new NullPointerException("Null не может быть использовано");
        }
        this.name = name;
        if(age < 0 || age > 100) {
            throw new IllegalArgumentException("Указано неверное число");
        }
        this.age = age;
    }

    public void setName(String name) {
        if(name == null) {
            throw new NullPointerException("Null не может быть использовано");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age < 0 || age > 100) {
            throw new IllegalArgumentException("Указано неверное число");
        }
        this.age = age;
    }

}
