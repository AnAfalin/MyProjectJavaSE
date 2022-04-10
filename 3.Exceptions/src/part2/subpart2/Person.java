package part2.subpart2;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age > 95) {
            throw new IllegalArgumentException("Недопустимое значение возраста");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person " + " name: " + name + "  age: " + age;
    }
}
