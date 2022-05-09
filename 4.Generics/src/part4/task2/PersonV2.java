package part4.task2;

public class PersonV2 implements Comparable<PersonV2> {
    private String name;
    private int age;

    public PersonV2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(PersonV2 o) {
        if(this.age < o.age){
            return 1;
        }else if(this.age > o.age){
            return -1;
        }else return 0;
    }

    @Override
    public String toString() {
        return "Person: " + name + " " + age;
    }
}

