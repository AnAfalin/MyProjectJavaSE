package part1;

public class Task6 {
    public static void main(String[] args) {
        //шаблон, ищущий любые слова, но в которых нет дефиса
        String str = "text world bot-tle milk juice са-хар 12-345 sun one -20";
        String[] arr = str.split(" ");


        for (int i = 0; i < arr.length; i++) {
            if(arr[i].matches("[^-]+")){
                System.out.println(arr[i]);
            }
        }
    }
}
