package generalCollectionTasks.task9.solution2;

public class Worker {
    private final String name;
    private final int age;
    private final int workExperience;
    private int markInterview;

    public Worker(String name, int age, int workExperience) {
        this.name = name;
        this.age = age;
        this.workExperience = workExperience;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public int getAge() {
        return age;
    }

    public int getMarkInterview() {
        return markInterview;
    }


    public void addMarkInterview(int markInterview) {
        this.markInterview += markInterview;
    }

    @Override
    public String toString() {
        return "Сотрудник. Имя: " + name + ". Возраст " + age + ". Стаж работы " + workExperience + ". Рейтинг " + markInterview;
    }
}
