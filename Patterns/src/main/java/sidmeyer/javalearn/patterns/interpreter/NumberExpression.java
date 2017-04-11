package sidmeyer.javalearn.patterns.interpreter;


public class NumberExpression implements Expression {
	double number;

	public NumberExpression(double number) {
		this.number = number;
	}

	public double interpret() {
		return number;
	}
}
