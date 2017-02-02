package serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestSerializer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person john = new Person("John", 23);
        System.out.println(john.getName() + john.getAge());
        //Person billy = new Person("Billy", 58);
        OutputStream os = Files.newOutputStream(Paths.get("person.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(john);
        oos.flush();
        oos.close();

        InputStream is = Files.newInputStream(Paths.get("person.txt"));
        ObjectInputStream ois = new ObjectInputStream(is);
        Person returnedJohn = (Person) ois.readObject();
        System.out.println(returnedJohn.getName() + returnedJohn.getAge());

    }
}
