package part1.task3;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
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

    public static void main(String[] args) {
        Person person = new Person("Sergio", 45);//отработает полностью
        Person person1 = new Person(null, -45);//отработает только исключение в setName
        Person person2 = new Person(null, -45);//отработает только исключение в setAge

    }
}
