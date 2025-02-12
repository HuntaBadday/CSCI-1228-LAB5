import java.util.Arrays;

/**
 * a class representing a vector
 *
 * @author Nikita Neveditsin (A00000000)
 * @author Hunter Turner (A00488748)
 */
public class Vector {

    //tolerance for comparing double values (do not remove/modify)
    public static final double TOL = 0.0001;

    //underlying array of components
    private final double[] components;

    /**
     * primary constructor
     *
     * @param components array of doubles that represents a vector
     */
    public Vector(double[] components) {
        this.components = components;
    }
    
    /**
     * Returns the L1 norm of the vector
     * 
     * @return L1 Norm
     */
    public double l1norm() {
        double sum = 0;
        for (int i = 0; i < components.length; i++) {
            sum += Math.abs(components[i]);
        }
        return sum;
    }
    
    /**
     * Reuturns the L2 norm of the vector
     * 
     * @return L2 Norm
     */
    public double l2norm() {
        double sum = 0;
        for (int i = 0; i < components.length; i++) {
            sum += Math.pow(components[i], 2);
        }
        return Math.sqrt(sum);
    }
    
    /**
     * Returns a copy of the vector, multiplied by a scalar value
     * 
     * @param scalar scalar value to multiply the compnents by
     * @return copy of vector multiplied by the scalar value
     */
    public Vector multiplyByScalar(double scalar) {
        double[] vectorCopy = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            vectorCopy[i] = components[i]*scalar;
        }
        return new Vector(vectorCopy);
    }
    
    /**
     * Adds two vectors together
     * 
     * @param other other vector
     * @return vector containing the sum of each component
     */
    public Vector add(Vector other) {
        if (components.length != other.components.length) {
            return null;
        }
        
        double[] vectorCopy = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            vectorCopy[i] = components[i]+other.components[i];
        }
        
        return new Vector(vectorCopy);
    }
    
    /**
     * Subtracts one vector from another
     * 
     * @param other other vector
     * @return vector containing the difference of each component
     */
    public Vector subtract(Vector other) {
        if (components.length != other.components.length) {
            return null;
        }
        
        double[] vectorCopy = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            vectorCopy[i] = components[i]-other.components[i];
        }
        
        return new Vector(vectorCopy);
    }
    
    /**
     * Calculates the dot product of two vectors
     * 
     * @param other other vector
     * @return dot product
     */
    public double dotProduct(Vector other) {
        if (components.length != other.components.length) {
            return Double.NaN;
        }
        
        double sum = 0;
        for (int i = 0; i < components.length; i++) {
            sum += components[i]*other.components[i];
        }
        
        return sum;
    }
    
    /**
     * Returns cosine similarity between the current vector and the other vector.
     * 
     * @param other other vector
     * @return cosine similarity
     */
    public double cosine(Vector other) {
        if (components.length != other.components.length) {
            return Double.NaN;
        }
        
        double dotProduct = dotProduct(other);
        double l2norm1 = l2norm();
        double l2norm2 = other.l2norm();
        
        double similarity = dotProduct / (l2norm1*l2norm2);
        return similarity;
    }
    
    /**
     * Check if this is equals to another vector
     * 
     * @return true if vectors are equal within a tolerance
     */
    public boolean equals(Vector other) {
        if (components.length != other.components.length) {
            return false;
        }
        
        for (int i = 0; i < components.length; i++) {
            if (!doublesAreEqual(components[i], other.components[i]))
                return false;
        }
        return true;
    }
    
    /**
     * Return a string representation of the vector.
     * 
     * @return string representation
     */
    public String toString() {
        return Arrays.toString(components);
    }

    /**
     * DO NOT MODIFY THIS METHOD - USE IT FOR CHECKING DOUBLES FOR EQUALITY!
     * Compares two double values for equality within a specified tolerance.
     * 
     * This method checks if the absolute difference between the two double
     * values is less than a predefined tolerance. It is useful for comparing
     * floating-point numbers where precision errors may occur.
     *
     * @param x the first double value to compare
     * @param y the second double value to compare
     * @return true if the absolute difference between {@code x} and
     * {@code y} is less than the tolerance; {@code false} otherwise
     */
    private boolean doublesAreEqual(double x, double y) {
        return Math.abs(x - y) < TOL;
    }

}
