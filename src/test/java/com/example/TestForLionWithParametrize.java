package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestForLionWithParametrize {
    private final String sex;
    private final boolean expectedMane;

    @Parameterized.Parameters
    public  static  Object[][] data(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    public TestForLionWithParametrize(String sex, boolean expectedMane){
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Test
    public void lionHasManeTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }
}
