package com.student;

import com.student.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {
    Calculator obj = new Calculator();
    @Test
    public void testAdd() {

        assertEquals(30, obj.add(10, 20));
    }
}
