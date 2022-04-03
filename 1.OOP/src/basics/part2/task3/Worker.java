package basics.part2.task3;

public class Worker {
    private String name;
    private int age;
    private int workExperience;

    public Worker(String name, int age, int workExperience) {
        this.name = name;
        if(age > 0 && age < 100) {
            this.age = age;
        }
        if(workExperience >= 0) {
            this.workExperience = workExperience;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0 && age < 100) {
            this.age = age;
        }
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        if(workExperience >= 0) {
            this.workExperience = workExperience;
        }
    }

    @Override
    public String toString() {
        return "Имя: " + name + ". Возраст: " + age + ". Стаж работы: " + workExperience;
    }
}