public abstract class Animal {
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    protected String name;
    protected int age;

    public abstract void makeSound();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
