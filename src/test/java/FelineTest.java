package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FelineClassMockTest {

    @Test
    void testGetFamily() {
        String expected = "Кошачьи";
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    void testGetKittens() {
        int expected = 1;
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    void testGetKittensWithCount() {
        int expected = 3;
        Feline feline = new Feline();
        int actual = feline.getKittens(3);
        assertEquals(expected, actual);
    }

    @Test
    void testEatMeatReturnsExpectedFoodList() throws Exception {
        Feline felineMock = mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = felineMock.eatMeat();
        assertEquals(expectedFood, actualFood);
        verify(felineMock).eatMeat();
    }
}
