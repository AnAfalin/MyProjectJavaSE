package part3.task4;

public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Christian", "Grey", 30, "Programmer", new String[]{"Cat", "Dog"});
        people[1] = new Person("Mike", "Scott", 20, "Manager", new String[]{"Cat"});
        people[2] = new Person("Ana", "Wilson", 22, "Programmer", new String[]{"Cat", "Dog", "Fish"});

        Solution solution = new Solution();

        solution.saveXMLFile(people,"6.StreamInputOutput/src/part3/task4/XML_data.xml");
        Person[] peopleRead = solution.downloadXMLFile("6.StreamInputOutput/src/part3/task4/XML_data.xml");
        for (Person el : peopleRead) {
            System.out.println(el);
        }
    }
}
