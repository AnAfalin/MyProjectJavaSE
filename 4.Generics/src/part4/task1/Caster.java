package part4.task1;

public class Caster<T> {

    @SuppressWarnings("unchecked")
    public T castObject(Object o){
        return (T) o;
    }

    @SuppressWarnings("unchecked")
    public T[] castArray(Object[] array){
        return (T[]) array;
    }
}

class Main{
    public static void main(String[] args) {
        Caster<String> cast1 = new Caster<>();
        Caster<Integer> cast2 = new Caster<>();

        Object obj1 = "50";
        String strPastCast = cast1.castObject(obj1);

        Object obj2 = 40;
        int intPastCast = cast2.castObject(obj2);

        System.out.println(obj1 + " and " + strPastCast);
        System.out.println(obj2 + " and " + intPastCast);

        Object[] array = new Integer[3];
        array[0] = 1; array[1] = 2; array[2] = 3;

        Integer[] intArrayPastCast = cast2.castArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }


        //неработающий код
        //Exception java.lang.ClassCastException:
        // class java.lang.Double cannot be cast to class java.lang.Integer
        Caster<Integer> caster = new Caster<>();
        Object object = 45.0;
        Integer resultCast = caster.castObject(object);
        System.out.println(resultCast);

    }
}


