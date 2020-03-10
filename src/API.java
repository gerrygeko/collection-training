import java.util.List;

public class API {

    private static List<Person> listOfPerson = List.of(
            new Person(33, "Marco"),
            new Person(33, "Gennaro"),
            new Person(34, "Marco"),
            new Person(34, "Luca"),
            new Person(35, "Marco"),
            new Person(35, "Marco"));

    public static int getListLength() {
        return listOfPerson.size();
    }

    public static String getName(int i) {
        return listOfPerson.get(i).getName();
    }

    public static int getSize(int i) {
        return listOfPerson.get(i).getSize();
    }

    public static class Person {
        int size;
        String name;

        public Person(int size, String name) {
            this.size = size;
            this.name = name;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
