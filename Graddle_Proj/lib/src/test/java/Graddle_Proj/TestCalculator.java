package Graddle_Proj;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//import Graddle_Proj.Calculator;

public class TestCalculator {
	Calculator obj = new Calculator();
	@Test
	public void testAdd() {
		assertEquals(30, obj.add(10, 20));
	}
}
