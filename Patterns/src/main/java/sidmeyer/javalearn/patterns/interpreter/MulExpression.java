package sidmeyer.javalearn.patterns.interpreter;

public class MulExpression  implements Expression {

	private Expression left;
	private Expression right;

	public MulExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public double interpret() {
		return left.interpret() * right.interpret();
	}
}