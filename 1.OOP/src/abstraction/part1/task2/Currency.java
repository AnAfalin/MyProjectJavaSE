package abstraction.part1.task2;

public abstract class Currency {
    private double courseToRub;

    public Currency(double courseToRub) {
        this.courseToRub = courseToRub;
    }

    public double getCourseToRub() {
        return courseToRub;
    }

    public double exchange(int volume){
        return volume * getCourseToRub();
    }

}
