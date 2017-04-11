package sidmeyer.javalearn.patterns.interpreter;

public class SqrtExpression  implements Expression {

	private Expression left;
//	private Expression right;

	public SqrtExpression(Expression left) {
		this.left = left;
//		this.right = right;
	}

	public double interpret() {
		return Math.sqrt(left.interpret());
	}
}