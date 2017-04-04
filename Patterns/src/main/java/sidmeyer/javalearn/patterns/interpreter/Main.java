package sidmeyer.javalearn.patterns.interpreter;

/**
 * Created by Stas on 04.04.2017.
 */
public class Main {
	public static void main(String[] args) {
		// 1-2+3

		Context context = new Context();
		Expression expr = context.evaluate("-1.0+2.0-3.0/2.0");
		System.out.println(expr.interpret());
	}
}
