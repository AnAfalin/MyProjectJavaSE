package enumeration.task3;

public class Date {
    private int year;
    private Month month;
    private int day;
    private Weekday weekDay;


    public Date(int year, Month month, int day, Weekday weekDay) {
        this.year = year;
        this.month = month;
        if(dayIsCorrect(month, day, year)) {
            this.day = day;
        }else {
            this.day = 0;
        }
        this.weekDay = weekDay;
    }

    private boolean dayIsCorrect(Month month, int day, int year){
        if(day > 0 && day <= 31) {
            if (month.ordinal() == 0 || month.ordinal() == 2 || month.ordinal() == 4 ||
                    month.ordinal() == 6 || month.ordinal() == 7 || month.ordinal() == 9 || month.ordinal() == 11)
                return true;
        }
        if(day > 0 && day <= 30) {
            if (month.ordinal() == 3 || month.ordinal() == 5 || month.ordinal() == 8 || month.ordinal() == 10)
                return true;
        }
        if (month.ordinal() == 1) {
            if (day > 0 && year % 4 == 0 && day <=29) {
                return true;
            }else return day > 0 && day <= 28;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Date: " + day + " " + month + " " + year + " " + weekDay;
    }
}
