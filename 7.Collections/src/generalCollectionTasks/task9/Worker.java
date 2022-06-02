package generalCollectionTasks.task9;

public class Worker {
    private String name;
    private int age;
    private int workExperience;
    private int markInterview;
    private DepartmentOffice departmentOffice;

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
}
