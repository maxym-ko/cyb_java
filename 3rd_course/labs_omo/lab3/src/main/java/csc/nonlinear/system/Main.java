package csc.nonlinear.system;

import Jama.Matrix;

public class Main {

    public static void main(String[] args) throws Exception {
        demoNewton();
    }

    private static void demoNewton() throws Exception {
        String f1 = "5 * x - 6 * y + 20 * LN(x) + 16";
        String f2 = "2 * x + y -10 * LN(y) - 4";
        Matrix result = NewtonMethod.solve(f1, f2, 1, 1, 0.001);

        double x = result.get(0, 0);
        double y = result.get(1, 0);

        System.out.println("Answer vector: (" + x + "; " + y + ")");
    }
}