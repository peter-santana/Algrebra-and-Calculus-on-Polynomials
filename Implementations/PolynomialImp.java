package Implementations;
import Interfaces.Polynomial;
import Interfaces.Term;
import ArrayList.ArrayList;

import java.util.Iterator;
import java.util.StringTokenizer;

public class PolynomialImp implements Polynomial {
    private ArrayList<Term> terms;

    public PolynomialImp(String string) {
        terms = new ArrayList<Term>(1);
        fromString(string);
    }


    @Override
    public Polynomial add(Polynomial P2) {
        double coefficient;
        int exponent;
        //in case P2 is 0
        PolynomialImp testagainst = new PolynomialImp("0");
        if (P2.equals(testagainst)) {
            return this;
        }
        PolynomialImp result = new PolynomialImp("");
        ArrayList<Term> copy = new ArrayList<Term>();
        for (Term x : P2) {
            copy.add(x);
        }
        // I start by looking at both arrays
        for(int i = 0, j = 0; i < this.terms.size() || j < copy.size();){
            //If I haven't reached the end of both
            if(i != this.terms.size() && j!=copy.size()) {
                //And if their exponents are the same
                if (this.terms.get(i).getExponent() == copy.get(j).getExponent()) {
                    //I add the term normally, when the coefficient isn't 0
                    coefficient = this.terms.get(i).getCoefficient() + copy.get(j).getCoefficient();
                    exponent = terms.get(i).getExponent();
                    if(coefficient != 0) {
                        result.addTerm(new TermImp(coefficient, exponent));
                    }
                    i++; j++;
                    //If the exponent I have on my terms is bigger than the one in P2
                }else if (terms.get(i).getExponent() > copy.get(j).getExponent()) {
                    result.addTerm(terms.get(i));
                    i++;
                    //If the exponent in P2 is bigger than the one I have in my terms
                }else if (copy.get(j).getExponent() > terms.get(i).getExponent()) {
                    result.addTerm(copy.get(j));
                    j++;
                }
            }else {
                //If one polynomial is bigger than the other
             if (i == terms.size()) {
                    result.addTerm(copy.get(j));
                    j++;
                } else if (j == copy.size()) {
                    result.addTerm(terms.get(i));
                    i++;
                }
            }
        }
        return result;
    }



    @Override
    // Method recommended by TA in Laboratory
    public Polynomial subtract(Polynomial P2) {
        return this.add(P2.multiply(-1));
    }

    @Override
    //We multiply each coefficient with the ones in P2
    //We add the exponents with the ones in P2
    public Polynomial multiply(Polynomial P2) {
        Polynomial result = new PolynomialImp("0");
        PolynomialImp empty;
        double coefficient;
        int exponent;
        //We check if were not multiplying by 0
        if(!P2.equals(result))
        for (Term x : this.terms) {
            for (Term x2 : P2) {

                coefficient = x.getCoefficient() * x2.getCoefficient();
                exponent = x.getExponent() + x2.getExponent();
                empty = new PolynomialImp("");
                TermImp termino = new TermImp(coefficient,exponent);

                //we do this to add after multiplying
                empty.addTerm(termino);
                result = result.add(empty);
            }
        }
        return result;
    }

    @Override
    //We just multiply the coefficient by C and get the same exponent
    public Polynomial multiply(double c) {
        //Just in case we multiply by 0
        PolynomialImp resultado_si_es_0 = new PolynomialImp("0.00");
        PolynomialImp resultado = new PolynomialImp("");
        if (c == 0) {
            return resultado_si_es_0;
        }else {
            for (Term x : this.terms) {
                //each coefficient is multiplied by C,
                TermImp mult = new TermImp(x.getCoefficient() * c, x.getExponent());
                resultado.addTerm(mult);
            }
            return resultado;
        }
    }
    @Override
    public Polynomial derivative() {
        Term derivativedTerm;
        double coefficient = 0;
        int exponent = 0;
        PolynomialImp result = new PolynomialImp("");
        for (int i = 0; i < terms.size(); i++) {
            //each coefficient is multiplied by its exponent and its exponent lowered by 1
            coefficient = terms.get(i).getCoefficient() * terms.get(i).getExponent();
            exponent = terms.get(i).getExponent() - 1;
            derivativedTerm = new TermImp(coefficient,exponent);


            //checking if the coefficient is not 0
            if (derivativedTerm.getCoefficient() > 0 || derivativedTerm.getCoefficient()<0) {
                result.addTerm(derivativedTerm);
            }
        }
        return result;
    }

    @Override
    public Polynomial indefiniteIntegral() {
        double coefficient;
        int exponent;
        PolynomialImp result = new PolynomialImp("");
        for (int i = 0; i < terms.size(); i++) {
            //each coefficient is divided by its exponent + 1
            //we raise the exponent by + 1
            coefficient = (terms.get(i).getCoefficient()) / (terms.get(i).getExponent() + 1);
            exponent = terms.get(i).getExponent() + 1;
            result.addTerm(new TermImp(coefficient, exponent));
        }
        //The constant +c is represented as a term with a coefficient of 1
        result.addTerm(new TermImp(1, 0));
        return result;
    }

    @Override
    //the indfinite integrals are evaluated with both values and substracted
    public double definiteIntegral(double a, double b) {
        double FirstTerm = this.indefiniteIntegral().evaluate(a);
        double SecondTerm = this.indefiniteIntegral().evaluate(b);
        return SecondTerm - FirstTerm;
    }

    //We assume the polynomial is always in order,
    //so we can just grab the exponent from the first term
    @Override
    public int degree() {
        return terms.get(0).getExponent();
    }

    @Override
    //each coefficient is multiplied by the value of x to the power of its exponent
    public double evaluate(double x) {
        double result = 0;
        for (Term i : this) {
            result += i.getCoefficient() * Math.pow(x, i.getExponent());
        }
        return result;
    }

    @Override
    //method added to make tests work
    public boolean equals(Polynomial P) {
        return this.toString().equals(P.toString());
    }


    public void fromString(String str) {
        // Idea given by professor in class
        StringTokenizer strTok = new StringTokenizer(str, "+");
        String nextStr = null;
        Term nextTerm = null;
        this.terms.clear();
        while (strTok.hasMoreElements()) {
            nextStr = (String) strTok.nextElement();
            nextTerm = TermImp.fromString(nextStr);

            this.addTerm(nextTerm);
        }
    }


    public String toString() {
        //if there is nothing, we just return 0
        if(terms.isEmpty()){
            return "0.00";
        }//We declare a string builder since were going in a loop
        StringBuilder polynomialinString = new StringBuilder();
            for (int i = 0; i < terms.size(); i++) {
                //if i hasn't reached the end of the terms, each term is divided with a +
                if (i < terms.size() - 1) {
                    polynomialinString.append(terms.get(i).toString().concat("+"));
                } else {
                    //the last term is added without a + next to it
                    polynomialinString.append(terms.get(i).toString());
                }
            }
            return polynomialinString.toString();
    }

    public Iterator<Term> iterator() {
        return terms.iterator();
    }

    public void addTerm(Term nextTerm) {
        //easier way of adding terms
        terms.add(nextTerm);
    }
    public ArrayList<Term> getArray() {
        //gets the terms of a polynomial in array form
        return this.terms;
    }

}
