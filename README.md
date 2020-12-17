# Algrebra-and-Calculus-on-Polynomials
Project for class CIIC4020(Data Structures)  implementing and testing a polynomial class, using the ArrayList container class as the data structure to store the terms in a polynomial
The general form of a polynomial is as follows:
P(x)an xn an−1xn−1 ...a1xa0
Here, each term has a coefficient, denoted as ai , and a exponent i, which represent the power of the variable x. The polynomial class implements the following operations:
1. Addition – given two polynomials P1 and P2 , compute the polynomial P3 = P1 + P2 .
2. Subtraction – given two polynomials P1 and P2 , compute the polynomial P3 = P1 − P2 .
3. Multiplication – given two polynomials P1 and P2 , compute the polynomial P3 = P1 * P2 .
4. Scalar Multiplication - given a polynomial P , multiply it by a constant c, and return it as a new polynomial.
5. Derivative – given a polynomial P , finds its derivative.
6. Indefinite integral – given a polynomial P , finds its indefinite integral (anti-derivative).
7. Definite integral – given a polynomial P , evaluate its definite integral over an interval
[a,b].
8. Degree – given a polynomial P , find its degree (the largest exponent in any term).
9. Evaluate – given a polynomial P , evaluate it at value x, to compute y = P(x) .
10. String Converter – a given a polynomial P, return its string representation in the form:
an xn  an−1xn−1 ...  a1x  a0
