package Tester;

import static org.junit.Assert.*;

import Implementations.PolynomialImp;
import Interfaces.Polynomial;
import org.junit.Before;
import org.junit.Test;

public class Test2 {
 
	private static final double EPSILON = 0.0001;
	
	private Polynomial P1;
	private Polynomial P2;

	@Before
	public void setUp() throws Exception {
		 P1 = new PolynomialImp("3x^2+2x+1");
		 P2 = new PolynomialImp("x^2+2");
	}

	@Test
	public void testAdd() {
		Polynomial P3 =  P1.add(P2);
		Polynomial P4 = new PolynomialImp("4x^2+2x+3");
		System.out.printf("Add-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));
		
	}

	@Test
	public void testSubtract() {
		Polynomial P3 = P1.subtract(P2);
		Polynomial P4 = new PolynomialImp("2x^2+2x+-1");
		System.out.printf("Subtract I-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));
		
		P3 = P1.subtract(P1);
		P4 = new PolynomialImp("0");
		System.out.printf("Subtract II-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));
		
	
		
	}

	@Test
	public void testMultiplyPolynomial() {
		Polynomial P3 = P1.multiply(P2);
		Polynomial P4 = new PolynomialImp("3x^4+2x^3+7x^2+4x+2");
		System.out.printf("Multiply-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));
	}

	@Test
	public void testDerivative() {
		Polynomial P3 = P1.derivative();
		Polynomial P4 = new PolynomialImp("6x+2");
		System.out.printf("Derivative-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));

	}

	@Test
	public void testIndefiniteIntegral() {
		Polynomial P3 = P1.indefiniteIntegral();
		String strP4 = "x^3+x^2+x+1";
		Polynomial P4 = new PolynomialImp(strP4);
		System.out.printf("Indefinite Integral-> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));

	}

	@Test
	public void testDefiniteIntegral() {
		double number1 = P1.definiteIntegral(2, 4);
		double number2 = 70.0;
		System.out.printf("Definite Integral-> number1: %f, number2: %f\n", number1, number2);
		double delta = Math.abs(number1 - number2);
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
		double number1 = P1.evaluate(5);
		double number2 = 86.0;
		System.out.printf("Evaluate-> number1: %f, number2: %f\n", number1, number2);
		double delta = Math.abs(number1 - number2);
		assertTrue(delta < EPSILON);
	}

	@Test
	public void testMultiplyDouble() {
		Polynomial P3 = P1.multiply(0);
		Polynomial P4 = new PolynomialImp("0");
		System.out.printf("Multiply -> P3: %s, P4: %s\n", P3, P4);
		assertTrue(P3.equals(P4));
	}

	@Test
	public void testToString() {
		String string1 = P1.toString();
		String string2 = "3.00x^2+2.00x+1.00";
		System.out.printf("toString-> string1: %s, string2: %s\n", string1, string2);
		assertTrue(string1.equals(string2));
	}

}
