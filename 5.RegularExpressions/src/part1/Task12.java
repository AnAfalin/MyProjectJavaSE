package part1;

public class Task12 {
    public static void main(String[] args) {

        //Написать валидатор для пароля:
        //хотя бы одна цифра, хотя бы один спецсимвол,
        //хотя бы одна заглавная и строчная буква,
        //количество символов – от 5 до 20.
        String str = "45rtA7*5";
        System.out.println(str.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}"));



    }
}
