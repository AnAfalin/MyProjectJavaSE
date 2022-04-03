package basics.part2.task1;


public class Employee {
    private static final int DEFAULT_AGE = 16;

    private static int count = 0; //счетчик количества созданных объектов
    private static int countMan = 0;
    private static int countWoman = 0;

    private String name;
    private int age;
    private String gender;

    public Employee() {
        this.age = DEFAULT_AGE;
        countGender(null);
    }

    public Employee(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.age = DEFAULT_AGE;
        countGender(gender);
    }

    public Employee(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        countGender(gender);
    }

    public static void printInfo(){
        System.out.println("Всего работников: " + count + ".\nИз них женщин: " + countWoman + ", мужчин: " + countMan);
    }

    private static void countGender(String gender) {
        if ("Man".equals(gender)) {
            countMan++;
        }
        else if ("Woman".equals(gender)) {
            countWoman++;
        }

        count++;
    }
}

//class Main{
//    public static void main(String[] args) {
//        Employee employee1 = new Employee("Mike", "Man");
//        Employee employee2 = new Employee("Mike", "Woman");
//        Employee employee3 = new Employee("Mike", "Man");
//        Employee employee4 = new Employee("Mike", "Woman");
//        Employee employee5 = new Employee();
//
//        Employee.printInfo();
//    }
//}
