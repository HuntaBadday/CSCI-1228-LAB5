
/**
 *
 * @author Nikita Neveditsin A00000000
 */
public class VectorTests {

    private static final String TF = "Test %d %s: %s\n";
    private static final String P = "PASSED";
    private static final String F = "FAILED";

    public static void main(String[] args) {
        Vector v1 = new Vector(new double[]{1.5, -2.4, 4.0, 9.1, -10.23});
        Vector v2 = new Vector(new double[]{12.8, 4.4, -7.3, 13.85, 8.2});
        Vector v3 = new Vector(new double[]{5.6, -5.8, 13.1});
        Vector v4 = new Vector(new double[]{-55.0});
        Vector v5 = new Vector(new double[]{});

        Vector v11 = new Vector(new double[]{1.5, -2.4, 4.0, 9.1, -10.23});
        Vector v13 = new Vector(new double[]{1.5, -2.4, 4.0, 9.1, -10.22});
        Vector v14 = new Vector(new double[]{1.5, -2.4, 4.0, 9.1});

        Vector v6 = new Vector(new double[]{});

        //if argument is null, don't expect proper results (GIGO) - exceptions 
        //are not covered yet
        double grade = 0.0;
        int testNo = 1;

        if (v1.equals(v11) // Identical vectors
                && !v1.equals(v13) // Slightly different vectors
                && !v1.equals(v14) // Different lengths
                && v5.equals(v6) // Both empty
                ) {
            System.out.printf(TF, testNo++, P, "+2 pts");
            grade += 2;
        } else {
            System.out.printf(TF, testNo++, F,
                    "equals method failed in one or more cases. Further tests"
                    + " are cancelled. Fix your equals method first!");
            return;
        }

        //toString
        if (v1.toString().equals("[1.5, -2.4, 4.0, 9.1, -10.23]")
                && v2.toString().equals("[12.8, 4.4, -7.3, 13.85, 8.2]")
                && v3.toString().equals("[5.6, -5.8, 13.1]")
                && v4.toString().equals("[-55.0]")
                && v5.toString().equals("[]")) {
            System.out.printf(TF, testNo++, P, "+1 pts");
            grade += 1.0;
        } else {
            System.out.printf(TF, testNo++, F, "check your toString method");
        }

        //scalar mul
        if (v1.multiplyByScalar(-1).
                equals(new Vector(new double[]{-1.5, 2.4, -4.0, -9.1, 10.23}))
                && v2.multiplyByScalar(10)
                        .equals(new Vector(new double[]{128.0, 44.0, -73.0,
                    138.5, 82.0}))
                && v3.multiplyByScalar(0.1)
                        .equals(new Vector(new double[]{0.56, -0.58, 1.31}))) {
            System.out.printf(TF, testNo++, P, "+0.5 pts");
            grade += 0.5;
        } else {
            System.out.printf(TF, testNo++, F, "check your multiplyByScalar"
                    + " method");
        }

        if (v1.equals(new Vector(new double[]{1.5, -2.4, 4.0, 9.1, -10.23}))
                && v2.equals(new Vector(new double[]{12.8, 4.4, -7.3, 13.85, 8.2}))) {
            System.out.printf(TF, testNo++, P, "+0.5 pts");
            grade += 0.5;
        } else {
            System.out.printf(TF, testNo++, F, "check your multiplyByScalar"
                    + "method: does it mutate the original vector?");
        }

        //l1 norm  
        if (Math.abs(v1.l1norm() - 27.23) < Vector.TOL
                && Math.abs(v2.l1norm() - 46.55) < Vector.TOL
                && Math.abs(v3.l1norm() - 24.5) < Vector.TOL
                && Math.abs(v4.l1norm() - 55.0) < Vector.TOL) {
            System.out.printf(TF, testNo++, P, "+1 pts");
            grade += 1.0;
        } else {
            System.out.printf(TF, testNo++, F, "check your l1norm method");
        }

        //l2norm
        if (Math.abs(v1.l2norm() - 14.5421) < Vector.TOL
                && Math.abs(v2.l2norm() - 22.2610) < Vector.TOL
                && Math.abs(v3.l2norm() - 15.3821) < Vector.TOL
                && Math.abs(v4.l2norm() - 55.0) < Vector.TOL) {
            System.out.printf(TF, testNo++, P, "+1 pts");
            grade += 1.0;
        } else {
            System.out.printf(TF, testNo++, F, "check your l2norm method");
        }

        //sum
        if (v1.add(v2).equals(new Vector(new double[]{14.3, 2.0, -3.3, 22.95,
            -2.03})) && v2.add(v3) == null) {
            System.out.printf(TF, testNo++, P, "+0.5 pts");
            grade += 0.5;
        } else {
            System.out.printf(TF, testNo++, F, "check your add method");
        }

        if (v1.equals(new Vector(new double[]{1.5, -2.4, 4.0, 9.1, -10.23}))
                && v2.equals(new Vector(new double[]{12.8, 4.4, -7.3, 13.85, 8.2}))) {
            System.out.printf(TF, testNo++, P, "+0.5 pts");
            grade += 0.5;
        } else {
            System.out.printf(TF, testNo++, F, "check your add method: does it "
                    + "mutate the original vector?");
        }

        //sub
        if (v1.subtract(v2).equals(new Vector(new double[]{-11.3, -6.80, 11.3,
            -4.75, -18.43}))
                && v2.subtract(v1).equals(v1.subtract(v2).multiplyByScalar(-1))
                && v1.subtract(v3) == null) {
            System.out.printf(TF, testNo++, P, "+0.5 pts");
            grade += 0.5;
        } else {
            System.out.printf(TF, testNo++, F, "check your subtract method");
        }

        if (v1.equals(new Vector(new double[]{1.5, -2.4, 4.0, 9.1, -10.23}))
                && v2.equals(new Vector(new double[]{12.8, 4.4, -7.3, 13.85, 8.2}))) {
            System.out.printf(TF, testNo++, P, "+0.5 pts");
            grade += 0.5;
        } else {
            System.out.printf(TF, testNo++, F, "check your subtract method:"
                    + " does it mutate the original vector?");
        }

        //dot
        if (Math.abs(v1.dotProduct(v2) - 21.589) < Vector.TOL
                && Math.abs(v2.dotProduct(v1) - 21.589) < Vector.TOL
                && Double.isNaN(v2.dotProduct(v3))) {
            System.out.printf(TF, testNo++, P, "+1 pts");
            grade += 1.0;
        } else {
            System.out.printf(TF, testNo++, F, "check your dotProduct method");
        }

        //cos
        if (Math.abs(v1.cosine(v2) - 0.06668994) < Vector.TOL
                && Math.abs(v2.cosine(v1) - 0.06668994) < Vector.TOL
                && Double.isNaN(v1.cosine(v3))) {
            System.out.printf(TF, testNo++, P, "+1 pts");
            grade += 1.0;
        } else {
            System.out.printf(TF, testNo++, F, "check your cosine method");
        }

        System.out.printf("Final Grade: %.1f\n", grade);

        System.out.printf("\nExpected grade: %.1f out of 10.0\n"
                + "Make sure you DO NOT hardcode any values and DO NOT"
                + " copy from other students/other resources\n", grade);

    }

}
