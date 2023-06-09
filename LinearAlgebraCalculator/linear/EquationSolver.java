package linear;

import linear.algebra.GaussianElimination;

public class EquationSolver{
    public static double[][] parseMatrix(String[] input) {
        double[][] matrix = new double[input.length][];
        
        for (int i = 0; i < input.length; i++) {
            String[] row = input[i].split(",");
            matrix[i] = stringsToDoubles(row);
        }
        
        return matrix;
    }
    
    public static double[] stringsToDoubles(String[] strings) {
        double[] doubles = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            doubles[i] = Double.parseDouble(strings[i]);
        }
        return doubles;
    }
    public static void main(String[] args) {
        if (args.length > 0) {
            double[][] matrix = parseMatrix(args);
            GaussianElimination g = new GaussianElimination(matrix.length, matrix[0].length, matrix);
            g.rowEchelonForm();
            g.print();
            System.out.println();
            g.backSubstitution();
            g.print();
        } else {
            System.out.println("No command line arguments?");
        }
    }
}