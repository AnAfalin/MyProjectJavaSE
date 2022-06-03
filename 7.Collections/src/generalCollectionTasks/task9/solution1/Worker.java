package generalCollectionTasks.task9.solution1;

public class Worker {
    private final String name;
    private final int age;
    private final int workExperience;
    private int markInterview;
    private final DepartmentOffice departmentOffice;

    public Worker(String name, int age, int workExperience, DepartmentOffice departmentOffice) {
        this.name = name;
        this.age = age;
        this.workExperience = workExperience;
        this.departmentOffice = departmentOffice;
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

    public DepartmentOffice departmentOffice() {
        return departmentOffice;
    }

    public void addMarkInterview(int markInterview) {
        this.markInterview += markInterview;
    }

    @Override
    public String toString() {
        return "Сотрудник. Имя: " + name + ". Возраст " + age + ". Стаж работы " + workExperience + ". Отдел работы " + departmentOffice + ". Рейтинг " + markInterview;
    }
}
