package part2.subpart2;

public class Main {
    public static void main(String[] args) {
        InMemoryStorage storage = new InMemoryStorage(3);
        storage.add(new Person("Кирилл", 15));
        storage.add(new Person("Евгений", 10));
        storage.add(new Person("Сергей", 4));

        storage.changeAgePerson(2);
        System.out.println(storage.getIndexAdultPerson());

    }
}
