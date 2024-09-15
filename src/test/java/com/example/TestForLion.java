package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@RunWith(MockitoJUnitRunner.class)
public class TestForLion {
    private Lion lion;

    @Mock
    private Feline feline;

    @Test
    public void getKittensTest() throws Exception{
        lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception{
        lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void doesHaveManeExceptionTest() throws Exception{
//        lion = new Lion("Неизвестный", feline);
//        //lion.getFood();
//        assertThrows(Exception.class, () -> lion.doesHaveMane());
        Exception exception = assertThrows(Exception.class, () -> {
            lion = new Lion("Неизвестный", feline);
            lion.doesHaveMane();
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }

}
