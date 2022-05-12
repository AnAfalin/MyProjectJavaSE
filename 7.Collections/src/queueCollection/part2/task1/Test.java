package queueCollection.part2.task1;

public class Test {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        //stack.pop();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);

        stack.pop();

        System.out.println(stack);
        System.out.println(stack.peek());

    }
}
