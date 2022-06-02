package generalCollectionTasks.task9;

public class Worker {
    private String name;
    private int age;
    private int workExperience;
    private int markInterview;
    private PostOffice postOffice;

    public Worker(String name, int age, int workExperience, PostOffice postOffice) {
        this.name = name;
        this.age = age;
        this.workExperience = workExperience;
        this.postOffice = postOffice;
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

    public PostOffice getPostOffice() {
        return postOffice;
    }

    public void addMarkInterview(int markInterview) {
        this.markInterview += markInterview;
    }
}
