package generalCollectionTasks.task1;

class Main {
    public static void main(String[] args) {
        CyclicList<Integer> cyclicList = new CyclicList<>();
        cyclicList.addFirst(5);
        System.out.println(cyclicList);
        cyclicList.addLast(10);
        System.out.println(cyclicList);
        cyclicList.add(20);
        cyclicList.add(30);
        System.out.println(cyclicList);
        cyclicList.addFirst(0);
        System.out.println(cyclicList);
        cyclicList.add(15, 3);
        System.out.println(cyclicList);
    }
}
