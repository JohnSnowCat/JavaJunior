public class Dog extends Animal {
    public Dog(String name, int age, String nickName, boolean isTrained) {
        super(name, age);
        this.nickName = nickName;
        this.isTrained = isTrained;
    }

    private String nickName;
    private boolean isTrained;
    public void train() {
        isTrained = true;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "nickName='" + nickName + '\'' +
                ", isTrained=" + isTrained + ", name=' " + super.name + "',age=" + super.age +
                "} ";
    }
}
