package basics.part3.task3;

public class Document {
    String text;
    String author;

    public Document(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String printText(){
        return "Text: " + text + " \nAuthor: " + author;
    }
}
