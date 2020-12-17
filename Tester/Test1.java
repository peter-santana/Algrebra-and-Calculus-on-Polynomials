package Tester;

import static org.junit.Assert.*;

import Implementations.PolynomialImp;
import Interfaces.Polynomial;
import org.junit.Before;
import org.junit.Test;

public class Test1 {
 
	private static final double EPSILON = 0.0001;
	
	private Polynomial P1;
	private Polynomial P2;

	@Before
	public void setUp() throws Exception {
		 P1 = new PolynomialImp("8x^2+1");
		 P2 = new PolynomialImp("4x^2+2");

	}

	@Test
	public void testAdd() {
		Polynomial P3 = P1.add(P2);
		Polynomial P4 = new PolynomialImp("12x^2+3");
		System.out.printf("Add-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));
		
	}

	@Test
	public void testSubtract() {
		Polynomial P3 = P1.subtract(P2);
		Polynomial P4 = new PolynomialImp("4x^2+-1");
		System.out.printf("Subtract-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));
	}

	@Test
	public void testMultiplyPolynomial() {
		Polynomial P3 = P1.multiply(P2);
		Polynomial P4 = new PolynomialImp("32x^4+20x^2+2");
		System.out.printf("Multiply-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));
	}

	@Test
	public void testDerivative() {
		Polynomial P3 = P1.derivative();
		Polynomial P4 = new PolynomialImp("16x");
		System.out.printf("Derivative-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));

	}

	@Test
	public void testIndefiniteIntegral() {
		Polynomial P3 = P2.indefiniteIntegral();
		double c1 = 4/3.0;
		String strP4 = c1 + "x^3+2x+1";
		Polynomial P4 = new PolynomialImp(strP4);
		System.out.printf("Indefinite Integral-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));

	}

	@Test
	public void testDefiniteIntegral() {
		double number1 = P1.definiteIntegral(2, 4);
		double number2 = 151.333333;
		System.out.printf("Definite Integral-> number1: %f, number2: %f\n", number1, number2);
		double delta = number1 - number2;
		assertTrue(delta < EPSILON);
	}

	@Test
	public void testDegree() {
		int number1 = P1.degree();
		int number2 = 2;
		System.out.printf("Degree -> number1: %d, number2: %d\n", number1, number2);
		assertTrue(number1 == number2);
	}

	@Test
	public void testEvaluate() {
		double number1 = P1.evaluate(3);
		double number2 = 73.0;
		System.out.printf("Evaluate-> number1: %f, number2: %f\n", number1, number2);
		double delta = Math.abs(number1 - number2);
		assertTrue(delta < EPSILON);
	}

	@Test
	public void testMultiplyDouble() {
		Polynomial P3 = P1.multiply(2);
		Polynomial P4 = new PolynomialImp("16x^2+2");
		System.out.printf("Multiply-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));
	}

	@Test
	public void testToString() {
		String string1 = P1.toString();
		String string2 = "8.00x^2+1.00";
		System.out.printf("toString-> string1: %s, string2: %s\n", string1, string2);
		assertTrue(string1.equals(string2));
	}

}
