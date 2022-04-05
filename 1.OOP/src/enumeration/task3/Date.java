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
        if(month == Month.JANUARY && day > 0 && day <= 31) {
            return true;
        }
        if(month == Month.FEBRUARY && day > 0 && year % 4 == 0 && day <=29) {
            return true;
        }
        if(month == Month.FEBRUARY && day > 0 && day <=28) {
            return true;
        }
        if(month == Month.MARCH && day > 0 && day <= 31) {
            return true;
        }
        if(month == Month.APRIL && day > 0 && day <= 30) {
            return true;
        }
        if(month == Month.MAY && day > 0 && day <= 31) {
            return true;
        }
        if(month == Month.JUNE && day > 0 && day <= 30) {
            return true;
        }
        if(month == Month.JULY && day > 0 && day <= 31) {
            return true;
        }
        if(month == Month.AUGUST && day > 0 && day <= 30) {
            return true;
        }
        if(month == Month.SEPTEMBER && day > 0 && day <= 31) {
            return true;
        }
        if(month == Month.OCTOBER && day > 0 && day <= 30) {
            return true;
        }
        if(month == Month.NOVEMBER&& day > 0 && day <= 31) {
            return true;
        }
        return month == Month.DECEMBER && day > 0 && day <= 31;
    }

    @Override
    public String toString() {
        return "Date: " + day + " " + month + " " + year + " " + weekDay;
    }
}
