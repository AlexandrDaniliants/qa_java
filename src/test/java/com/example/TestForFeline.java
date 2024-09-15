package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestForFeline {
    @Spy
    private  Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public  void getFamilyTest(){
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertEquals("Фактическое значение семейства не соответствует ожидаемому", "Кошачьи", actual);
    }

    @Test
    public void getKittensWithOutParametersTest(){
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        assertEquals("Фактическое количество котят не соответствует ожидаемому", 1, actual);
    }

    @Test
    public void getKittensWithParametersTest(){
        int actual = feline.getKittens(3);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        assertEquals("Фактическое количество котят не соответствует ожидаемому", 3, actual);
    }
}
