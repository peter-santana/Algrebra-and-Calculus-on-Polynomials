package Implementations;
import Interfaces.Term;
import ArrayList.*;

import java.util.StringTokenizer;


public class TermImp implements Term {

    private double coefficient;
    private int exponent;

    public TermImp(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    @Override
    public double getCoefficient() {
        return coefficient;
    }
    @Override
    public int getExponent() {
        return exponent;
    }

    @Override
    public double evaluate(double x) {
        return coefficient * Math.pow(coefficient, exponent);
    }
    public String toString() {
        if (this.exponent == 0) {
            return String.format("%.2f", this.coefficient);
        } else if (this.exponent == 1) {
            return String.format("%.2fx", this.coefficient);
        } else {
            return String.format("%.2fx^%d", this.coefficient, this.exponent);
        }
    }
    //Method recommended by professor
    public static Term fromString(String str) {
        if (str.contains("x^")) {
            List<String> factors = new ArrayList<String>(2);
            StringTokenizer stringToken = new StringTokenizer(str, "x^");
            while (stringToken.hasMoreElements()) {
                factors.add((String) stringToken.nextElement());
            }
            if(factors.size() == 1) {
                Integer exponent = Integer.parseInt(factors.get(0));
                return new TermImp(1, exponent);
            } else {
                Double coefficient = Double.parseDouble(factors.get(0));
                Integer exponent = Integer.parseInt(factors.get(1));
                return new TermImp(coefficient, exponent);
            }
        } else if (str.contains("x")) {
            List<String> factors = new ArrayList<String>(2);
            StringTokenizer stringToken = new StringTokenizer(str, "x");
            while (stringToken.hasMoreElements()) {
                factors.add((String) stringToken.nextElement());
            }
            if (factors.isEmpty()) {
                return new TermImp(1.0, 1);
            } else {
                Double coefficient = Double.parseDouble(factors.get(0));
                return new TermImp(coefficient, 1);
            }
        } else {
            return new TermImp(Double.parseDouble(str), 0);
        }
    }
}