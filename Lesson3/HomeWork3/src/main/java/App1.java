import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
TASK1:
Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте его данными.
Сериализуйте этот объект в файл.
Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и ответьте на вопрос,
почему значение GPA не было сохранено/восстановлено.
 */

public class App1 {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 36);
        student1.setGPA(4.5);
        String filePath = ".\\src\\main\\resources\\Example.bin";

        //Сериализуем объект в файл
        try (FileOutputStream out = new FileOutputStream(filePath);
             ObjectOutputStream outputStream = new ObjectOutputStream(out)) {
            outputStream.writeObject(student1);
            System.out.println("The object has been serialized in file: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Десериализуем объект из файла
        Student savedStudent1 = null;
        try {
            FileInputStream in = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(in);
            savedStudent1 = (Student) inputStream.readObject();
            in.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Выводим десериализованный объект
        System.out.println(savedStudent1);
    }
}
