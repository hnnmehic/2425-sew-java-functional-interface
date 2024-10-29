package at.htl.students;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class FunctionalInterfaceExersiceTest {
    @Test
    void testEvenNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = FunctionalInterfaceExersice.evenNumbers(numbers);
        assertEquals(List.of(2, 4, 6, 8, 10), evenNumbers, "Die gefilterte Liste sollte nur gerade Zahlen enthalten");
    }

    @Test
    void testDoubleEvenNumbers() {
        List<Integer> evenNumbers = List.of(2, 4, 6, 8, 10);
        List<Integer> doubledNumbers = FunctionalInterfaceExersice.doubleEvenNumbers(evenNumbers);
        assertEquals(List.of(4, 8, 12, 16, 20), doubledNumbers, "Die verdoppelte Liste sollte die doppelten Werte enthalten");
    }




    @Test
    void testCreateNewListIfEmpty_withEmptyList() {
        List<Integer> numbers = List.of();
        List<Integer> newList = FunctionalInterfaceExersice.createNewListIfEmpty(numbers);

        assertFalse(newList.isEmpty(), "Die erstellte Liste sollte nicht leer sein, wenn eine leere Liste übergeben wurde");
        assertEquals(5, newList.size(), "Die erstellte Liste sollte 5 Zufallszahlen enthalten");
        assertTrue(newList.stream().allMatch(i -> i instanceof Integer), "Alle Elemente sollten ganze Zahlen sein");
    }

    @Test
    void testCreateNewListIfEmpty_withNonEmptyList() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> newList = FunctionalInterfaceExersice.createNewListIfEmpty(numbers);

        assertEquals(numbers, newList, "Wenn die Eingabeliste nicht leer ist, sollte die ursprüngliche Liste zurückgegeben werden");
    }
}