package basics.part3.task2;

public class Main {
    public static void main(String[] args) {


        Square[] array = {
                new Square(1),
                new Square(2),
                new Square(3),
                new Square(4),
                new Square(5),
        };

        int totalSquare = 0;
        int totalPerimeter = 0;
        int indexBig = 0;
        for (int i = 0; i < array.length; i++) {
            totalSquare += array[i].square();
            totalPerimeter += array[i].perimeter();
            if(array[i].getSide() > array[indexBig].getSide()) {
                indexBig = i;
            }
            System.out.println("Квадрат № " + (i+1) + "\n" + array[i]);
            System.out.println();
        }

        System.out.println("Общая площадь всех квадратов: " + totalSquare);
        System.out.println("Средняя площадь всех квадратов: " + totalSquare / array.length);
        System.out.println("Общий периметр всех квадратов: " + totalPerimeter);
        System.out.println("Средний периметр всех квадратов: " + totalPerimeter / array.length);
        System.out.println("Самый большой квадрат - это квардрат №" + (indexBig + 1) + " со стороной равной " + array[indexBig].getSide());

    }
}
