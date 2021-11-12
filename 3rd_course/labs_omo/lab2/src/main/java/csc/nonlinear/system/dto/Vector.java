package csc.nonlinear.system.dto;

public class Vector {

    private final Matrix vector;

    public Vector(double[] vector) {
        double[][] matrix = new double[vector.length][1];
        for (int i = 0; i < vector.length; i++) {
            matrix[i][0] = vector[i];
        }
        this.vector = new Matrix(matrix);
    }

    public Vector(double[][] vector) {
        if (vector == null || vector.length == 0 || vector[0].length != 1) {
            throw new IllegalArgumentException("The vector cannot be null or have more than 1 row");
        }
        this.vector = new Matrix(vector);
    }

    public Vector(int size) {
        this.vector = new Matrix(size, 1);
    }

    public double get(int row) {
        return vector.get(row, 0);
    }

    public void set(int row, double value) {
        vector.set(row, 0, value);
    }

    public int getSize() {
        return vector.getRow();
    }

    @Override
    public String toString() {
        return vector.toString();
    }
}
