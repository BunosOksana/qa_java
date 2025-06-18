package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatClassMockTest {

    @Mock
    Feline feline;

    @Test
    void testCatGetSound() {
        String expected = "Мяу";
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals(expected, actual);
    }

    @Test
    void testCatGetFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные", "Птица", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        assertEquals(expected, actual);
        verify(feline, times(1)).eatMeat();
    }
}
