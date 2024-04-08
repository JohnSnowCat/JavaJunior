import java.util.ArrayList;
import java.util.List;

//      Напишите программу, которая использует Stream API для обработки списка чисел.
//      Программа должна вывести на экран среднее значение всех четных чисел в списке.
public class Program {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        int result = (int) numbers.stream()
                .filter(n -> (n % 2) == 0)
                .mapToInt(Integer::intValue)
                .average().getAsDouble();

        System.out.println(result);
    }
}
