package at.htl.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExersice {
    public static void main(String[] args) {


        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //Predicate
         List<Integer> evenNumbers = evenNumbers(numbers);
        evenNumbers.forEach(System.out::println);
         //Function
        System.out.println();
        List<Integer> doubledNumbers = doubleEvenNumbers(evenNumbers);
        doubledNumbers.forEach(System.out::println);
        //Consumer
        System.out.println();
        printDoubledNumbers(doubledNumbers);








    }

    public static List<Integer> evenNumbers(List<Integer> numbers) {
        Predicate<Integer> filter = number -> number % 2 == 0;
        return numbers
                .stream()
                .filter(filter)
                .toList();
    }
    public static List<Integer> doubleEvenNumbers(List<Integer> numbers) {
        Function<Integer,Integer> doubledNumbers = number -> number *2;
        return numbers
                .stream()
                .map(doubledNumbers)
                .toList();
    }
    public static void printDoubledNumbers(List<Integer> numbers) {
        Consumer<Integer> print = System.out::println;
        numbers.forEach(print);
    }
    public static List<Integer> createNewListIfEmpty(List<Integer> numbers) {
        Supplier<List<Integer>> supplier = () -> {
            List<Integer> newList = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                newList.add(random.nextInt(100)); // Zufallszahlen zwischen 0 und 99
            }
            return newList;
        };

        return numbers.isEmpty() ? supplier.get() : numbers;
    }




}
