package com.test;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCalculator {
	Calculator obj = new Calculator();
	@Test
	public void testAdd() {
		assertEquals(30, obj.add(10, 20));
	}
}
