import java.util.Random;

public class Cat extends Animal{

    private String sex;
    private Random random = new Random();
    public Cat(String name, int age) {
        super(name, age);
        this.sex = getSex();
    }

    @Override
    public void makeSound() {
        System.out.println("meow");
    }

    public int getMale(){
        return random.nextInt(2);
    }

    public String getSex(){
        if(getMale() == 0){
            return "male";
        }
        else
            return "female";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "sex='" + sex + "', " + "name='" + super.name + "', age='" + super.age + "'}";
    }
}
