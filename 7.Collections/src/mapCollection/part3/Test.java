package mapCollection.part3;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, Integer.toString(i*i));
        }
        System.out.println(hashMap);
        System.out.println(hashMap.containsKey(3));
        hashMap.remove(3);
        System.out.println(hashMap);
        System.out.println(hashMap.get(5));
        System.out.println(hashMap.containsKey(3));
    }

}
