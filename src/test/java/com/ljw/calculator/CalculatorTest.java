package com.ljw.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class CalculatorTest{
	private Calculator calculator = new Calculator();

	@Test
	public void testSum(){
		assertEquals(5, calculator.sum(2,3));
	}
	public void testSub(){
		assertEquals(2, calculator.sum(5,3));
	}
	public void testMul(){
		assertEquals(6, calculator.mul(2,3));				       
	}
	public void testDiv(){
		assertEquals(2, calculator.div(6,3));
	}
}
