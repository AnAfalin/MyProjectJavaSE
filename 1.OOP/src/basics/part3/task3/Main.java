package basics.part3.task3;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Document doc = new Document("Some text", "Mike");
        Document docSecond = new Document("Интересный текст", "Известный автор");
        Document docThird = new Document("Скушный текст", "Неинтересный автор");
        Document docForth = new Document("Страница из книги Java", "Шилдт");

        printer.printDocument(doc);
        printer.printDocument(docSecond);
        printer.printDocument(docThird);
        printer.printDocument(docForth);
    }
}
