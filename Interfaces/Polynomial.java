package Interfaces;

public interface Polynomial extends Iterable<Term> {
	
	public Polynomial add(Polynomial P2);
	
	public Polynomial subtract(Polynomial P2);
	
	public Polynomial multiply(Polynomial P2);
	
	public Polynomial multiply(double c);

	public Polynomial derivative();
	
	public Polynomial indefiniteIntegral();
	
	public double definiteIntegral(double a, double b);
	
	public int degree();
	
	public double evaluate(double x);

	// Added
	public boolean equals(Polynomial P);
	

	

}
