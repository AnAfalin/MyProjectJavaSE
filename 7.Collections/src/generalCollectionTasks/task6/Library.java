package generalCollectionTasks.task6;

import java.util.*;

public class Library {
    private static final Map<Book, Integer> library = new HashMap<>();
    private static final List<Book> listBooks = new ArrayList<>();
    private static final List<Client> listClients = new LinkedList<>();

    private static Random random = new Random();

    private static final int MAX_VISITOR = 50;
    private static final int MIN_TIME_NEW_CLIENT = 1;
    private static final int MAX_TIME_NEW_CLIENT = 7;
    private static final int MIN_TIME_BORROW = 5;
    private static final int MAX_TIME_BORROW = 9;

    static {
        listBooks.add(new Book("Томас Харди", "Тэсс из рода д'Эрбервиллей"));
        listBooks.add(new Book("Артур Хейли", "Аэропорт"));
        listBooks.add(new Book("Артур Хейли", "Отель"));
        listBooks.add(new Book("Джулиан Барнс", "Как всё было"));
        listBooks.add(new Book("Джулиан Барнс", "Любовь и так далее"));
        listBooks.add(new Book("Эрих Мария Ремарк", "Три товарища"));
        listBooks.add(new Book("А.П. Чехов", "Вишневый сад"));
        listBooks.add(new Book("Г. И. Горин", "Поминальная молитва"));
        listBooks.add(new Book("М. Андерсон", "Королевские игры"));
        listBooks.add(new Book("Джейн Остин", "Гордость и предубеждение"));

        for (Book book : listBooks) {
            library.put(book, 2);
        }
    }

    private int countAwayClient;
    private int countServiceClient;

    private int timeNextClient;
    private int currentNumberClient = 1;

    public void start() {
        process();
        info();
    }

    private void newClient() {

        Book selectBook = selectBook(random.nextInt(library.size()));
        System.out.println("Посетитель №" + currentNumberClient + " хочет взять кигу " + selectBook.getTitle() + " автора " + selectBook.getAuthor());
        if (library.get(selectBook) != 0) {
            listClients.add(new Client(currentNumberClient, selectBook, random.nextInt(MIN_TIME_BORROW, MAX_TIME_BORROW)));
            getBook(selectBook);
            System.out.println("Книга есть в наличии. Книга выдана.");
        } else {
            System.out.println("Книги нет в наличии.");
            countAwayClient++;
        }
        timeNextClient = random.nextInt(MIN_TIME_NEW_CLIENT, MAX_TIME_NEW_CLIENT);
        currentNumberClient++;
    }

    private void getBook(Book selectBook) {
        library.put(selectBook, library.get(selectBook) - 1);
    }

    private void process() {
        while (!isEnd()) {
            if (timeNextClient == 0 && currentNumberClient <= MAX_VISITOR) {
                newClient();
            }
            if (timeNextClient != 0) {
                timeNextClient--;
            }
            returnBook();
        }
    }

    private void returnBook() {
        Iterator<Client> iterator = listClients.iterator();
        while (iterator.hasNext()) {
            Client currentClient = iterator.next();
            if (currentClient.timeBorrow == 0) {
                Book returnBook = currentClient.getBookBorrow();
                System.out.println("Клиент №" + currentClient.getNumber() + " вернул книгу " + returnBook);
                countServiceClient++;
                library.put(returnBook, library.get(returnBook) + 1);
                iterator.remove();
            } else {
                currentClient.timeBorrow--;
            }
        }
    }

    private Book selectBook(int numberBook) {
        return listBooks.get(numberBook);
    }

    private boolean isEnd() {
        return currentNumberClient == MAX_VISITOR + 1 && listClients.size() == 0;
    }

    private void info() {
        System.out.println("Колиество обслуженных клиентов составило " + countServiceClient + " человек");
        System.out.println("Количество ушедших клиентов составило " + countAwayClient + " человек");
        System.out.println("Книга - Взята количество раз");
        for (Book book:listBooks) {
            System.out.println(book.toString() + " -- " + book.getCountBorrow());
        }
    }
}
