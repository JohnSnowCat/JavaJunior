import java.io.Serializable;

public class Student implements Serializable {
    private String name;

    private int age;
    private transient double GPA;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

//    public void setAge(int age) {
//        this.age = age;
//    }

//    public double getGPA() {
//        return GPA;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}
