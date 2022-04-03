package abstraction.part3.task2;

public class Matrix {
    private final double[][] array;

    public Matrix(int sizeRow, int sizeColumn) {
        array = new double[sizeRow][sizeColumn];
    }

    public double sumElement(){
        double sum = 0;
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    public double averageValue(){
        if(array.length == 0) {
            return Double.NaN;
        }
        return sumElement() / (array.length * array[0].length);
    }

    public double[] getRow(int numberString){
        double[] newArr = new double[array.length];
        for (int i = 0; i < array[numberString].length; i++) {
            newArr[i] = array[numberString][i];
        }
        return newArr;
    }

}
