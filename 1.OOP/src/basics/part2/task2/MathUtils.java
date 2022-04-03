package basics.part2.task2;

public class MathUtils {

    private MathUtils(){}

    //Метод расчета суммы массива.
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    //Метод расчета среднего значения массива.
    public static double averageValue (int[] array) {
        return (double) sum(array) / array.length;
    }

    //Метод расчета количества элементов массива, попадающий в диапазон [a;b]
    public static int countElement(int[] array, int startIndex, int endIndex) {
        int countElement = 0;
        for (int i = startIndex; i < endIndex; i++) {
            countElement += array[i];
        }
        return countElement;
    }

    //Метод расчета расстояния (количества элементов) между минимальным и максимальным элементами массива
    public static int countMinMax(int[] array) {
        int min = array[0];
        int max = array[0];
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 0; i < array.length ; i++) {
            if (array[i] > max) {
                indexMax = i;
            }
            if (array[i] < min) {
                indexMin = i;
            }
        }
        return Math.abs(indexMax - indexMin);
    }

    //Метод преобразования double[] в int[]
    public static int[] toInt(double[] array) {
        int[] newArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = (int) array[i];
        }
        return newArr;
    }

    //Метод вычисления выражения: x^2 + x + 1
    public static double calculation(double x) {
        return x * x + x + 1;
    }

    //Метод вычисления длины окружности
    public static double lengthCircle(double radius) {
        return Math.PI * radius * 2;
    }

}
