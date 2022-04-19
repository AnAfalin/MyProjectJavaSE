package part1;

public class Task10 {
    public static void main(String[] args) {

        //валидатор для номера банковской карты

        String str = "4578 4587 4568 4444";
        String str1 = "4578 4587 45684 4444";
        System.out.println(str.matches("((\\d{4})\\s){3}?\\d{4}"));
        System.out.println(str1.matches("((\\d{4})\\s){3}?\\d{4}"));
    }
}
