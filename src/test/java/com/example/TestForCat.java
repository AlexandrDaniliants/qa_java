package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestForCat {

    private Cat cat;

    @Mock
    Feline feline;

    @Test
    public void getSoundMethodTest(){
        cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void getFoodMethodTest() throws Exception {
        cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }


}
