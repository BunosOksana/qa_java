package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionClassMockTest {

    @Mock
    Feline feline;

    @Test
    void testLionGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    void testLionGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }

    @Test
    void testCheckHasManeTrueWhenSexLionMale() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testCheckHasManeFalseWhenSexLionFemale() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void testInvalidSexThrowsException() {
        assertThrows(Exception.class, () ->
                new Lion(feline, "Используйте допустимые значения пола животного - самец или самка"));
    }
}
