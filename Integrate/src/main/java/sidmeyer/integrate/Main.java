package sidmeyer.integrate;
//import java.util.function.DoubleUnaryOperator;

/**
 * Created by stas on 02.04.17.
 */
public class Main {
    public static void main(String[] args) {
        //DoubleUnaryOperator f = new DoubleUnaryOperator();
        System.out.println(integrate(new DoubleUnaryOperator(), 10.0, 20.0));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double c = 0.00000001;
        double res = 0.0;
        for (double s = a; s < b; s+=c) {
            res += f.applyAsDouble(s) * c;
        }
        return res;
    }

}


class DoubleUnaryOperator {
    double applyAsDouble(double f) {
        return f + 1.0;
    }

}

