/*Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует. */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Animal[] animals = {
                new Dog("Bob", 5, "Bobik", true),
                new Cat("Tom", 3),
                new Dog("Bella", 2, "Bull", false),
                new Cat("Kitty", 1)
        };

        Class<?> clazz;

        for (Animal animal : animals) {
            clazz = animal.getClass();
            System.out.println(clazz.getSimpleName() + " " + clazz.getSuperclass().getSimpleName());
            printFields(clazz);

            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
            try {
                invokeMethod(animal, "makeSound"); //почему не работает при invokeMethod(clazz, "makeSound")?
                //и методе
                //     public static void invokeMethod(Class<?> clazz, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
                //        Method method = clazz.getDeclaredMethod(methodName);
                //        method.invoke(clazz);
                //    }
            } catch (NoSuchMethodException e) {
                System.out.println("Method not found in " + clazz.getSimpleName());
            }

            System.out.println("-------------------");
        }
    }

    public static void printFields(Class<?> clazz) {
        Field[] superFields = clazz.getSuperclass().getDeclaredFields();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : superFields) {
            System.out.println("Field: " + field.getName() + " " + field.getType().getSimpleName());
        }
        for (Field field : fields) {
            System.out.println("Field: " + field.getName() + " " + field.getType().getSimpleName());
        }
    }

    public static void invokeMethod(Object instance, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = instance.getClass().getDeclaredMethod(methodName);
        method.invoke(instance);
    }
}
