package com.student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestStudent {
    Student obj = new Student();
    @Test
    public void TestVoting()
    {
        assertEquals(1,obj.voting(20));
        assertEquals('A',obj.validgrade(91));
    }
}
