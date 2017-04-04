package sidmeyer.javalearn.patterns.interpreter;

public class Context {
	public Expression evaluate(String s) {
		int pos = s.length() - 1;
		while(pos > 0) {
			if(Character.isDigit(s.charAt(pos)) || s.charAt(pos) == '.') {
				pos--;
			} else {
				Expression left = evaluate(s.substring(0, pos));
				Expression right = new NumberExpression(Double.valueOf(s.substring(pos + 1, s.length())));
				char operator = s.charAt(pos);
				switch(operator) {
					case '-':
						return new SubExpression(left, right);
					case '+':
						return new AddExpression(left, right);
					case '*':
						return new MulExpression(left, right);
					case '/':
						return new DivExpression(left, right);
				}
			}
		}
		double result = Double.valueOf(s);
		return new NumberExpression(result);
	}
}
