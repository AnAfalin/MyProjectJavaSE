package queueCollection.part2.task1;

public class Stack<E> {
    private Object array[];
    private int capacity;
    private int top;

    public Stack() {
        capacity = 10;

        array = new Object[capacity];
    }

    public void push(E element){
        if(top + 1 >= capacity){
            capacity *= 2;
            Object[] newArray = new Object[capacity];
            System.arraycopy(array, 0, newArray, 0,array.length);
            array = newArray;
        }
        array[top] = element;
        top++;
    }

    public void pop(){
        isEmptyStack();
        array[top] = null;
        top--;
    }

    @SuppressWarnings("unchecked")
    public E peek(){
        isEmptyStack();
        return (E)array[top - 1];
    }

    private void isEmptyStack(){
        if(top == 0){
            throw new RuntimeException("Stack is empty");
        }
    }

    @Override
    public String toString() {
        String strStack = "";
        for (int i = 0; i < top; i++) {
            strStack += array[i] + " ";
        }
        return strStack;
    }
}
