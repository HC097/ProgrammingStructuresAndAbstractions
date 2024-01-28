import java.text.DecimalFormat;
public class Triangle {
	
	private double sideA;
	private double sideB;
	private double sideC;
	final private DecimalFormat df = new DecimalFormat("0.###"); //Three no zeros vs #.000
	
	//Constructors
	public Triangle() {
		
	}
	
	public Triangle(double a, double b, double c) {
		
		if (isTriangle(a, b, c) == true) {
			this.sideA = a;
			this.sideB = b;
			this.sideC = c;
		}else {
			this.sideA = 1;
			this.sideB = 1;
			this.sideC = 1;
		}
	
	}
	
	
	//Getters
	public double getSideA() {
		return this.sideA;
	}
	
	public double getSideB() {
		return this.sideB;
	}
	
	public double getSideC() {
		return this.sideC;
	}
	
	
	//Setters
	public boolean setSideA(double a) {
		
		
		if(isTriangle(a, sideB, sideC) == true) {
			sideA = a;
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean setSideB(double b) {
		
		
		if(isTriangle(sideA, b, sideC) == true) {
			sideB = b;
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean setSideC(double c) {
		
		if(isTriangle(sideA, sideB, c) == true) {
			sideC = c;
			return true;
		}else {
			return false;
		}
		
	}
	
	private static boolean isTriangle(double a, double b, double c) {
		
		if(a >  0 && b > 0 && c > 0 && a + b > c && b + c > a && c + a > b) {
			return true;
		}else { 
			return false;
		}
		
	}
	
	public String toString() {
		
		String str = "Triangle("+ df.format(getSideA()) + ", " + df.format(getSideB()) + ", " + df.format(getSideC()) + ")";
		return str;
	}
		
}