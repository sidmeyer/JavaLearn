package sidmeyer.poland;

import sidmeyer.poland.RPNParserException;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by stas on 03.04.17.
 */
public class Application {

    public static void main(String[] args) {
        System.out.println(parse("10 20 + 30 40 + *"));
    }

    public static double parse(String rpnString) {
        String[] rpn = rpnString.split(" ");
        Deque<Double> stack = new LinkedList<>();
        try {
            for (String o : rpn) {
                try {
                    stack.push(Double.parseDouble(o));
                    continue;
                } catch (NumberFormatException nfe) {
                }
                switch (o) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        Double o2 = stack.pop();
                        Double o1 = stack.pop();
                        if (o2 == 0) {
                            throw new ArithmeticException();
                        }
                        stack.push(o1 / o2);
                        break;
                    default:
                        throw new RPNParserException();
                }
            }
            if (stack.size() != 1) throw new RPNParserException();
            return stack.pop();
        } catch(NoSuchElementException nsee) {
        throw new RPNParserException();
        }
    }
}
