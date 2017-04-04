package sidmeyer.javalearn.patterns.interpreter;

public class SubExpression implements Expression {

	private Expression left;
	private Expression right;

	public SubExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public double interpret() {
		return left.interpret() - right.interpret();
	}
}
