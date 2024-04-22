import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

/*
TASK 2:
Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */
public class App2 {
    public static final String FILE_JSON = "file.json";
    public static final String FILE_XML = "file.xml";
    public static final String FILE_BIN = "file.bin";

    public static ObjectMapper objectMapper = new ObjectMapper();
    public static XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) {
        Student student = new Student("Vasya Pupkin", 33);
        student.setGPA(3.5);

        //Сериализуем объект в JSON
        saveToFile(FILE_JSON, student);

        //Cериализуем объект в XML
        saveToFile(FILE_XML, student);

        //Сериализуем объект в BIN
        saveToFile(FILE_BIN, student);

        //Десериализуем объект из JSON
        System.out.println("Объект из JSON: " + loadFromFile(FILE_JSON));

        //Десериализуем объект из XML
        System.out.println("Объект из XML: " + loadFromFile(FILE_XML));

        //Десериализуем объект из BIN
        System.out.println("Объект из BIN: " +loadFromFile(FILE_BIN));
    }

    /**
     * Метод сериализации объекта в JSON, XML или BIN
     * @param fileName имя сохраняемого файла
     * @param student сериализуемый объект
     */
    public static void saveToFile(String fileName, Student student) {
        try {
            if (fileName.endsWith(".json")) {
                //Сериализуем объект в JSON
                objectMapper.writeValue(new File(fileName), student);
            } else if (fileName.endsWith(".xml")) {
                //Сериализуем объект в XML
                xmlMapper.writeValue(new File(fileName), student);
            } else if (fileName.endsWith(".bin")) {
                //Сериализуем объект в BIN
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
                out.writeObject(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод десериализации объекта из JSON, XML или BIN
     * @param fileName Имя файла для загрузки объекта
     * @return Десериализованный объект
     */
    public static Student loadFromFile(String fileName) {
        Student serialisedStudent = new Student();
        File file = new File(fileName);
        try {
            if (file.exists()){
                if (fileName.endsWith(".json")){
                    serialisedStudent = objectMapper.readValue(file, Student.class);
                }
                else if(fileName.endsWith(".bin")){
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                    serialisedStudent = (Student) in.readObject();
                }
                else if(fileName.endsWith(".xml")){
                    serialisedStudent = xmlMapper.readValue(file, Student.class);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return serialisedStudent;
    }
}
