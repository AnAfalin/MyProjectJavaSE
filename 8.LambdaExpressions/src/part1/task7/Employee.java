package part1.task7;

public class Employee {
    private final String firstname;
    private final String lastname;
    private final int age;
    private final String job;
    private final String[] cityWorkExperience;

    public Employee(String firstname, String lastname, int age, String job, String[] cityWorkExperience) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.job = job;
        this.cityWorkExperience = cityWorkExperience;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String[] getCityWorkExperience() {
        return cityWorkExperience;
    }
}
